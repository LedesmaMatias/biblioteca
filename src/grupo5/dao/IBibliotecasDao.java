package grupo5.dao;

import java.util.List;

import grupo5.entidad.Bibliotecas;

public interface IBibliotecasDao {

	public Boolean Guardar(Bibliotecas b);
	
	public List<Bibliotecas> obtenerTodos();
	
	public List<Bibliotecas> obtenerPorFiltro(int estado);
}
