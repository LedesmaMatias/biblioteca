package grupo5.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IClientesDao;
import grupo5.entidad.Clientes;
import grupo5.entidad.Result;
import grupo5.negocio.INegClientes;

@Service("ClientesServicio")
public class NegClientes implements INegClientes {

	@Autowired
	private IClientesDao ClientesDao;

	@Override
	public List<Clientes> ObtenerFiltros(Integer Id, Integer DNI, String Nombre, String Apellido) {

		return ClientesDao.ObtenerFiltros(Id, DNI, Nombre, Apellido);
	}

	@Override
	public Clientes ObtenerPorId(Integer Id) {

		return ClientesDao.ObtenerPorId(Id);
	}

	@Override
	public Boolean VerificarDatos(int DNI) {
		return ClientesDao.VerificarDatos(DNI);
	}

	@Override
	public Result Alta(Clientes c) {

		Result r = new Result(0, "El cliente se agrego correctamente.");

		// Verifico que los datos sean correctos
		if (!VerificarDatos(c.getDNI())) {

			boolean Respuesta = ClientesDao.Guardar(c); // alta del cliente

			if (Respuesta == false) {
				r.setCodigo(2);
				r.setMensaje("Ocurrio un error al dar de alta el cliente.");
			}

		} else {

			r.setCodigo(1);
			r.setMensaje("El cliente" + c.getNombre() + " " + c.getApellido()
					+ "ya se encuentra registrado en nuestro sistema");
		}

		return r; // devuelvo la respuesta
	}

	@Override
	public Result Modificar(Clientes c) {

		Result r = new Result(0, "El cliente se agrego correctamente.");

		Clientes Cliente = ClientesDao.ObtenerPorId(c.getId()); // Obtengo el Cliente de la base

		// Modifico los datos
		// Cliente.CopiarDatos(c);

		Cliente.setNombre(c.getNombre());
		Cliente.setApellido(c.getApellido());
		Cliente.setDNI(c.getDNI());
		Cliente.setDireccion(c.getDireccion());
		Cliente.setNacionalidad(c.getNacionalidad());
		Cliente.setLocalidad(c.getLocalidad());
		Cliente.setFechaNacimiento(c.getFechaNacimiento());
		Cliente.setEmail(c.getEmail());
		Cliente.setTelefono(c.getTelefono());

		boolean Respuesta = ClientesDao.Guardar(Cliente); // modifica el cliente

		if (Respuesta == false) {
			r.setCodigo(2);
			r.setMensaje("Ocurrio un error al modificar el cliente.");
		}

		return r; // devuelvo la respuesta
	}

}
