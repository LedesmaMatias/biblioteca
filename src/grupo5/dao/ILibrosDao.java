package grupo5.dao;

import java.util.List;
import java.util.Set;

import grupo5.entidad.Libros;

public interface ILibrosDao {

	public boolean hayRegistros();

	public boolean cartarTablaDefault(Set<Libros> libros);

	public Libros obtenerPorISBN(String ISBN);

	public List<Libros> ObtenerFiltros(String ISBN, String Titulo);

}
