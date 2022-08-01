package grupo5.negocio;

import java.util.List;

import grupo5.entidad.Bibliotecas;
import grupo5.entidad.Result;

public interface INegBibliotecas {
	
	public Result alta(Bibliotecas b);
	
	public Result baja(int idBiblioteca);
	
	public Bibliotecas obtener(int id);
	
	public List<Bibliotecas> obtenerTodos();
	
	public List<Bibliotecas> obtenerPorFiltro(Integer estado);

}
