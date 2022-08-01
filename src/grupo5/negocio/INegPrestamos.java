package grupo5.negocio;

import java.util.List;

import grupo5.entidad.Prestamos;
import grupo5.entidad.Result;

public interface INegPrestamos {

	public Result alta(Prestamos p);
	
	public Result baja(int idPrestamo);
	
	public List<Prestamos> obtenerTodos();
}
