package grupo5.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IClientesDao;
import grupo5.entidad.Clientes;

@Repository("ClientesDao")
public class ClientesDao implements IClientesDao {

	@Autowired
	private Conexion conexion;

	@Override
	public List<Clientes> ObtenerFiltros(Integer Id, Integer DNI, String Nombre, String Apellido) {

		Session session = conexion.abrirConexion();

		// Traigo el Cliente con el Id especifico y si el Id es 0 traigo todos
		String Query = "select c from Clientes c where " + "(c.Id = " + Id + " or 0 = " + Id + ")  ";

		// Para los demas campos consulto solo si no vienen vacios
		if (DNI != 0) {
			Query += " and (c.DNI = " + DNI + ")";
		}

		if (Nombre != "") {
			Query += " and (c.Nombre like  '%" + Nombre + "%')";

		}

		if (Apellido != "") {
			Query += " and (c.Apellido like '%" + Apellido + "%')";

		}

		List<Clientes> ClientesLista = new ArrayList<Clientes>();

		ClientesLista = session.createQuery(Query).list();

		conexion.cerrarSession();

		return ClientesLista;
	}

	@Override
	public Clientes ObtenerPorId(Integer Id) {

		Session session = conexion.abrirConexion(); // Abro conexion
		// Traigo el Cliente con el Id especifico
		String Query = "select c from Clientes c where " + " c.Id = " + Id + "  ";

		Clientes c = (Clientes) session.get(Clientes.class, Id);

		conexion.cerrarSession();

		return c;
	}

	@Override
	public Boolean VerificarDatos(int DNI) {
		Boolean hayRegistros = false;

		Session session = conexion.abrirConexion();

		List<Object[]> rl = session.createQuery("select c from Clientes c where c.DNI = " + DNI).list();

		if (rl.size() != 0) {
			hayRegistros = true;
		}

		conexion.cerrarSession();
		return hayRegistros;
	}

	@Override
	public Boolean Guardar(Clientes c) {
		// verifico si la tabla esta cargada

		Session session = conexion.abrirConexion(); // Abro conexion
		Transaction tx = session.beginTransaction(); // Empiezo Transaccion

		boolean aux = true;
		try {

			session.saveOrUpdate(c); // Guardo en base
			tx = session.getTransaction(); // Commit de la trans
			tx.commit();

		} catch (Exception e) {
			aux = false;// por si algo sale mal
			tx.rollback();
		}

		conexion.cerrarSession(); // cierro
		return aux; // Devuelvo true si se guardo bien

	}


}
