package grupo5.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.INacionalidadesDao;
import grupo5.entidad.Nacionalidades;

@Repository("NacionalidadesDao")
public class NacionalidadesDao implements INacionalidadesDao {

	@Autowired
	private Conexion conexion;

	@Override
	public List<Nacionalidades> Obtener() {

		Session session = conexion.abrirConexion(); // Abro conexion

		List<Nacionalidades> NacioLista = new ArrayList<Nacionalidades>();

		NacioLista = session.createQuery("from Nacionalidades").list();

		conexion.cerrarSession();
		return NacioLista;
	}

	@Override
	public Nacionalidades ObtenerPorId(int id) {

		Session session = conexion.abrirConexion(); // Abro conexion

		Nacionalidades Nacio = (Nacionalidades) session.get(Nacionalidades.class, id);

		conexion.cerrarSession();

		return Nacio;
	}

	@Override
	public boolean CargarTablaDefault(List<Nacionalidades> NacioLista) {

		Session session = conexion.abrirConexion(); // Abro conexion
		Transaction tx = session.beginTransaction(); // Empiezo Transaccion

		// Recorro la lista de nacionalidad guardando en base
		boolean aux = true;
		for (Nacionalidades Nacio : NacioLista) {

			try {

				session.save(Nacio); // Guardo en base

			} catch (Exception e) {
				aux = false;// por si algo sale mal
				tx.rollback();
			}

		}

		tx = session.getTransaction(); // Commit de la trans
		tx.commit();
		conexion.cerrarSession();

		return aux;
	}

}
