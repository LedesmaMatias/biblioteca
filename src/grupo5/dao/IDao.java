package grupo5.dao;

import java.util.List;

//uso general?
public interface IDao {

	public List<Object> listar();
	public boolean agregar(Object o);
	public boolean eliminar(Object o);
	public boolean modificar(Object o);
}
