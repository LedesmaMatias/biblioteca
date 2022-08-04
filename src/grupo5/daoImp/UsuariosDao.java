package grupo5.daoImp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IUsuariosDao;
import grupo5.entidad.Usuarios;

@Repository("UsuariosDao")
public class UsuariosDao implements IUsuariosDao {

	@Autowired
	private Conexion conexion;

	@Override
	public Boolean CargarTablaDefault(Usuarios user) {

		Session session = conexion.abrirConexion(); // Abro conexion
		Transaction tx = session.beginTransaction(); // Empiezo Transaccion

		boolean aux = true;

		try {

			session.saveOrUpdate(user); // Guardo en base
			tx.commit();
		} catch (HibernateException e) {
			aux = false;// por si algo sale mal
			tx.rollback();
		}

		conexion.cerrarSession();

		return aux;
	}

	@Override
	public Boolean Verificar(String Usuario, String Pass) {

		Boolean hayRegistros = false;
		Session session = conexion.abrirConexion(); // Abro conexion

		List<Object[]> rl = session
				.createQuery(
						"select u from Usuarios u where " + " (user = '" + Usuario + "') and (pass = '" + Pass + "')")
				.list();

		if (rl.size() != 0) {
			hayRegistros = true;
		}

		conexion.cerrarSession();

		return hayRegistros;
	}
}
