package grupo5.dao;

import java.util.List;

import grupo5.entidad.Prestamos;

public interface IPrestamosDao {

	public List<Prestamos> ObtenerFiltros(Integer Id, Integer IdCliente);

}
