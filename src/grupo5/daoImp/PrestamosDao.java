package grupo5.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IPrestamosDao;
import grupo5.entidad.Prestamos;

@Repository("prestamoDao")
public class PrestamosDao implements IPrestamosDao {

	@Autowired
	private Conexion conexion;

	@Override
	public Boolean guardar(Prestamos p) {
		Session session = conexion.abrirConexion();
		Transaction t = session.beginTransaction();
		boolean bool = true;
		try {
			session.saveOrUpdate(p);
			t.commit();
		} catch(HibernateException e) {
			bool = false;
			t.rollback();
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public Boolean baja(Prestamos p) {
		Session session = conexion.abrirConexion();
		Transaction t = session.beginTransaction();
		Boolean bool = true;
		try {
			session.delete(p);
			t.commit();
		} catch(HibernateException e) {
			bool = false;
			t.rollback();
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public Prestamos obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestamos> obtenerTodos() {
		Session session = conexion.abrirConexion();
		List<Prestamos> listaPrestamos = new ArrayList<Prestamos>();
		listaPrestamos = session.createQuery("from Prestamos").list();
		conexion.cerrarSession();
		return listaPrestamos;
	}
}
