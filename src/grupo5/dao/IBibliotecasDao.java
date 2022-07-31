package grupo5.dao;

import java.util.List;

import grupo5.entidad.Bibliotecas;

public interface IBibliotecasDao {

	public Boolean guardar(Bibliotecas b);
	
	public Boolean baja(Bibliotecas b);
	
	public Bibliotecas obtener(int id);
	
	public List<Bibliotecas> obtenerTodos();
	
	public List<Bibliotecas> obtenerPorFiltro(int estado);
}
