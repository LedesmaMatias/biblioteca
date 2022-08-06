package grupo5.dao;

import java.util.List;

import grupo5.entidad.Clientes;

public interface IClientesDao {

	public List<Clientes> ObtenerFiltros(Integer Id, Integer DNI, String Nombre, String Apellido, Integer estado);

	public Boolean Guardar(Clientes c);

	public Clientes ObtenerPorId(Integer Id);

	public Boolean VerificarDatos(int DNI);
}
