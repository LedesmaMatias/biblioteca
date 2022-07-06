package grupo5.negocio;

import grupo5.entidad.Autores;
import grupo5.entidad.Result;

public interface INegAutores {

	public Result cargarTablaDefault();
	
	public Autores obtenerPorId(int id);
}
