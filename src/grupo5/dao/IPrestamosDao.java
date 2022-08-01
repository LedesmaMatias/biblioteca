package grupo5.dao;

import java.util.List;

import grupo5.entidad.Prestamos;

public interface IPrestamosDao {
	
	public Boolean guardar(Prestamos p);
	
	public Boolean baja(Prestamos p);
	
	public Prestamos obtener(int id);
	
	public List<Prestamos> obtenerTodos();

}
