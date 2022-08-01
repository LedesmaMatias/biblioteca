package grupo5.daoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.ILibrosDao;
import grupo5.entidad.Libros;

@Repository("libroDao")
public class LibrosDao implements ILibrosDao {

	@Autowired
	private Conexion conexion;

	@Override
	public boolean hayRegistros() {
		Session session = conexion.abrirConexion();
		long cantidad = (long) session.createQuery("select count(*) from Libros l").uniqueResult();
		conexion.cerrarSession();
		if (cantidad > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean cartarTablaDefault(Set<Libros> libros) {
		Session session = conexion.abrirConexion();
		Transaction t = session.beginTransaction();
		boolean aux = true;
		try {
			for (Libros l : libros) {

				session.merge(l);

			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			aux = false;
			t.rollback();
			e.printStackTrace();
		}
		conexion.cerrarSession();
		return aux;
	}

	@Override
	public Libros obtenerPorISBN(String ISBN) {
		Session session = conexion.abrirConexion();
		Libros libros = (Libros) session.createQuery("FROM Libros WHERE ISBN =" + ISBN).uniqueResult();
		conexion.cerrarSession();
		return libros;
	}

	@Override
	public List<Libros> ObtenerFiltros(String ISBN, String Titulo) {

		Session session = conexion.abrirConexion();

		// Traigo el Cliente con el Id especifico y si el Id es 0 traigo todos
		String Query = "select l FROM Libros l WHERE " + "( ISBN like '%" + ISBN + "%')  ";

		if (Titulo != "") {
			Query += " and (Titulo like  '%" + Titulo + "%')";

		}

		/*
		 * if (Apellido != "") { Query += " and (c.Apellido like '%" + Apellido + "%')";
		 * 
		 * }
		 */

		List<Libros> LibrosLista = new ArrayList<Libros>();

		LibrosLista = session.createQuery(Query).list();

		conexion.cerrarSession();

		return LibrosLista;
	}
}
