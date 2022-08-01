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
	public Boolean guardar(Bibliotecas b) {
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
		Session session = conexion.abrirConexion();
		String query = "select l from Bibliotecas l where l.Estado =" + estado;
		List<Bibliotecas> listaLibros = new ArrayList<Bibliotecas>();
		listaLibros = session.createQuery(query).list();
		conexion.cerrarSession();
		return listaLibros;
	}

	@Override
	public Boolean baja(Bibliotecas b) {
		Session session = conexion.abrirConexion();
		Transaction t = session.beginTransaction();
		Boolean flag = false;
		try {
			session.delete(b);
			t.commit();
			flag = true;
		} catch(HibernateException e) {
			t.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Bibliotecas obtener(int id) {
		Session session = conexion.abrirConexion();
		Bibliotecas b = new Bibliotecas();
		try {
			b = (Bibliotecas) session.get(Bibliotecas.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		}
		conexion.cerrarSession();
		return b;
	}
}
