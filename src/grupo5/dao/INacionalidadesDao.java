package grupo5.dao;

import java.util.List;

import grupo5.entidad.Nacionalidades;

public interface INacionalidadesDao {

	public List<Nacionalidades> Obtener();

	public Nacionalidades ObtenerPorId(int id);

	public boolean CargarTablaDefault(List<Nacionalidades> NacioLista);

}
