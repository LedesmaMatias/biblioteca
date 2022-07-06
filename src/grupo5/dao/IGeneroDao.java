package grupo5.dao;

import java.util.Set;

import grupo5.entidad.Generos;

public interface IGeneroDao {

	public boolean hayRegistros();
	
	public boolean cargarTablaDefault(Set<Generos> generos);
	
	public Generos obtenerPorId(int id);
	
	public Generos obtenerPorDescripcion(String descripcion);
}
