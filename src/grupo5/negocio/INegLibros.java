package grupo5.negocio;

import grupo5.entidad.Libros;
import grupo5.entidad.Result;

public interface INegLibros {

	public Result cargarTablaDefault();
	
	public Libros obtenerPorISBN(String ISBN);
}
