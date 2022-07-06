package grupo5.daoImp;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IAutoresDao;
import grupo5.entidad.Autores;

@Repository("autorDao")
public class AutoresDao implements IAutoresDao {

	@Autowired
	private Conexion conexion;


	@Override
	public boolean cargarTablaDefault(List<Autores> autores) {
		Session session = conexion.abrirConexion();
		Transaction t = session.beginTransaction();
		boolean aux = true;
		try {
			for(Autores a : autores) {
				session.save(a);
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
	public Autores obtenerPorId(int id) {
		Session session = conexion.abrirConexion();
		Autores autor = (Autores) session.createQuery("FROM Autores WHERE Id=" + id).uniqueResult();
		conexion.cerrarSession();
		return autor;
	}


	@Override
	public boolean hayRegistros() {
		Session session = conexion.abrirConexion();
		long cantidad = (long)session.createQuery("select count(*) from Autores a").uniqueResult();
		conexion.cerrarSession();
		if(cantidad>0) {
			return true;
		}
		return false;
	}
}
