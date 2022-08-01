package grupo5.negocio;

import java.util.List;

import grupo5.entidad.Libros;
import grupo5.entidad.Result;

public interface INegLibros {

	public Result cargarTablaDefault();

	public Libros obtenerPorISBN(String ISBN);

	public List<Libros> ObtenerFiltros(String ISBN, String Titulo);
}
