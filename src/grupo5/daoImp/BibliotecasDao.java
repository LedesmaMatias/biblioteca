package grupo5.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IBibliotecasDao;
import grupo5.entidad.Bibliotecas;

@Repository("bibliotecaDao")
public class BibliotecasDao implements IBibliotecasDao {

	@Autowired
	private Conexion conexion;

	@Override
	public Boolean Guardar(Bibliotecas b) {
		Session session = conexion.abrirConexion();
		Transaction t = session.beginTransaction();
		boolean bool = true;
		try {
			session.saveOrUpdate(b);
			t.commit();
		} catch(HibernateException e) {
			bool = false;
			t.rollback();
			e.printStackTrace();
			
		}
		conexion.cerrarSession();
		return bool;
	}

	@Override
	public List<Bibliotecas> obtenerTodos() {
		Session session = conexion.abrirConexion();
		List<Bibliotecas> listaLibros = new ArrayList<Bibliotecas>();
		listaLibros = session.createQuery("from Bibliotecas").list();
		conexion.cerrarSession();
		return listaLibros;
	}

	@Override
	public List<Bibliotecas> obtenerPorFiltro(int estado) {
		// TODO Auto-generated method stub
		return null;
	}
}
