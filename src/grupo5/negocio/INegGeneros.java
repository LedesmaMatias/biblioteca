package grupo5.negocio;

import grupo5.entidad.Generos;
import grupo5.entidad.Result;

public interface INegGeneros {

	public Result cargarTablaDefault();
	
	public Generos obtenerPorId(int id);
	
	public Generos obtenerPorDescripcion(String descripcion);
}
