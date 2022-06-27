package grupo5.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IdaoNacionalidad;
import grupo5.entidad.Nacionalidad;

@Repository("nacionalidadDao")
public class NacionalidadDao implements IdaoNacionalidad {

	@Autowired
	private Conexion conexion;

	public static Boolean VerificarTabla() {
		Boolean hayRegistros = false;

		Conexion ch = new Conexion();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		List<Nacionalidad> rl = session.createQuery("from Nacionalidad").list();
		System.out.println("Number of Elements: " + rl.size());

		if (rl.size() != 0) {
			hayRegistros = true;
		}

		session.getTransaction().commit();
		session.close();
		return hayRegistros;
	}

	public static Nacionalidad ReadOne(int id) {
		Conexion ch = new Conexion();
		Session session = ch.abrirConexion();
		session.beginTransaction();

		Nacionalidad n = (Nacionalidad) session.get(Nacionalidad.class, id);

		session.getTransaction().commit();
		session.close();
		return n;
	}

	public static void CargarNacionalidades() {
		// verifico si la tabla esta cargada

		if (!VerificarTabla()) {

			Conexion ch = new Conexion();
			Session session = ch.abrirConexion();

			session.beginTransaction();

			// Declaro nacionalidades
			Nacionalidad n = new Nacionalidad();
			n.setDescripcion("Argentina");

			session.save(n);

			Nacionalidad n2 = new Nacionalidad();
			n2.setDescripcion("Mexico");

			session.save(n2);

			Nacionalidad n3 = new Nacionalidad();
			n3.setDescripcion("EEUU");

			// Agrego a la tabla

			session.save(n3);

			Nacionalidad n4 = new Nacionalidad();
			n3.setDescripcion("Colombia");

			// Agrego a la tabla

			session.save(n4);

			session.getTransaction().commit();
			session.close();

		}

	}

}
