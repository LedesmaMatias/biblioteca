package grupo5.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IPrestamosDao;
import grupo5.entidad.Clientes;
import grupo5.entidad.Prestamos;

@Repository("prestamoDao")
public class PrestamosDao implements IPrestamosDao {

	@Autowired
	private Conexion conexion;
	
	
	@Override
	public List<Prestamos> ObtenerFiltros(Integer Id, Integer IdCliente) {

		Session session = conexion.abrirConexion();

		// Traigo el Prestamo con el Id especifico y si el Id es 0 traigo todos
		String Query = "select p from Prestamos p where " + "(p.Id = " + Id + " or 0 = " + Id + ")  ";

		// Para los demas campos consulto solo si no vienen vacios
		if (IdCliente != 0) {
			Query += " and (p.Cliente = " + IdCliente + ")";
		}
	
		List<Prestamos> PrestamosLista = new ArrayList<Prestamos>();

		PrestamosLista = session.createQuery(Query).list();

		conexion.cerrarSession();

		return PrestamosLista;
	}
}
