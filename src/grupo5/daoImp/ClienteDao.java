package grupo5.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IdaoCliente;
import grupo5.entidad.Cliente;
import grupo5.entidad.Result;

@Repository("clienteDao")
public class ClienteDao implements IdaoCliente {

	@Autowired
	private Conexion conexion;

	public static List<Cliente> ObtenerTabla() {
		Boolean hayRegistros = false;

		Conexion ch = new Conexion();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		List<Cliente> rl = session.createQuery("from Cliente").list();
		System.out.println("Number of Elements: " + rl.size());

		if (rl.size() != 0) {
			hayRegistros = true;
		}

		session.getTransaction().commit();
		session.close();

		return rl;
	}

	public static List<Cliente> ObtenerClientes(Integer Id, Integer DNI, String Nombre, String Apellido) {
		Boolean hayRegistros = false;

		Conexion ch = new Conexion();
		Session session = ch.abrirConexion();
		session.beginTransaction();

		// Traigo el Cliente con el Id especifico y si el Id es 0 traigo todos
		String Query = "select c from Cliente c where " + "(c.ID_cliente = " + Id + " or 0 = " + Id + ")  ";

		// Para los demas campos consulto solo si no vienen vacios
		if (DNI != 0) {
			Query += " and (c.DNI = " + DNI + ")";
		}

		if (Nombre != "") {
			Query += " and (c.nombre like  '%" + Nombre + "%')";

		}

		if (Apellido != "") {
			Query += " and (c.apellido like '%" + Apellido + "%')";

		}

		List<Cliente> rl = session.createQuery(Query).list();

		if (rl.size() != 0) {
			hayRegistros = true;
		}

		session.getTransaction().commit();
		session.close();

		return rl;
	}

	public static Cliente ObtenerClienteById(Integer Id) {

		Conexion ch = new Conexion();
		Session session = ch.abrirConexion();
		session.beginTransaction();

		// Traigo el Cliente con el Id especifico y si el Id es 0 traigo todos
		String Query = "select c from Cliente c where " + " c.ID_cliente = " + Id + "  ";

		Cliente c = (Cliente) session.createQuery(Query);

		session.getTransaction().commit();
		session.close();

		return c;
	}

	public static Boolean VerificarDatos(int DNI) {
		Boolean hayRegistros = false;

		Conexion ch = new Conexion();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		List<Object[]> rl = session.createQuery("select c from Cliente c where c.DNI = " + DNI).list();

		if (rl.size() != 0) {
			hayRegistros = true;
		}

		session.getTransaction().commit();
		session.close();
		return hayRegistros;
	}

	public static Result ClienteAlta(Cliente c) {
		// verifico si la tabla esta cargada

		Result r = new Result(0, "El cliente se agrego correctamente.");

		if (!VerificarDatos(c.getDNI())) {

			try {
				Conexion ch = new Conexion();
				Session session = ch.abrirConexion();

				session.beginTransaction();

				session.save(c);

				session.getTransaction().commit();
				session.close();
			} catch (Exception e) {

				r.setCodigo(2);
				r.setMensaje("Ocurrio un error al dar de alta el cliente: " + e.toString());
			}

		} else {

			r.setCodigo(1);
			r.setMensaje("El cliente ya se encuentra registrado en nuestro sistema");
		}

		return r;

	}

}
