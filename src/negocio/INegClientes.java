package grupo5.negocio;

import java.util.List;

import grupo5.entidad.Clientes;
import grupo5.entidad.Result;

public interface INegClientes {

	public List<Clientes> ObtenerFiltros(Integer Id, Integer DNI, String Nombre, String Apellido);

	public Result Alta(Clientes c);

	public Clientes ObtenerPorId(Integer Id);

	public Boolean VerificarDatos(int DNI);

	public Result Modificar(Clientes c);
}
