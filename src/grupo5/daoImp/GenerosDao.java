package grupo5.daoImp;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IGeneroDao;
import grupo5.entidad.Generos;

@Repository("generoDao")
public class GenerosDao implements IGeneroDao{

	@Autowired
	private Conexion conexion;

	@Override
	public boolean hayRegistros() {
		Session session = conexion.abrirConexion();
		long cantidad = (long)session.createQuery("select count(*) from Generos g").uniqueResult();
		conexion.cerrarSession();
		if(cantidad>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean cargarTablaDefault(Set<Generos> generos) {
		Session session = conexion.abrirConexion();
		Transaction t = session.beginTransaction();
		boolean aux = true;
		try {
			for(Generos g : generos) {
				session.save(g);
			}
			session.getTransaction().commit();
		} catch(HibernateException e) {
			aux=false;
			t.rollback();
			e.printStackTrace();
		}
		conexion.cerrarSession();
		return aux;
	}

	@Override
	public Generos obtenerPorId(int id) {
		
		return null;
	}

	@Override
	public Generos obtenerPorDescripcion(String descripcion) {
		Session session = conexion.abrirConexion();
		Generos genero = (Generos) session.createQuery("FROM Generos WHERE Descripcion='" + descripcion + "'" ).uniqueResult();
		conexion.cerrarSession();
		return genero;
	}
}
