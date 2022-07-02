package grupo5.negocio;

import java.util.List;

import grupo5.entidad.Nacionalidades;
import grupo5.entidad.Result;

public interface INegNacionalidades {

	public List<Nacionalidades> Obtener();

	public Nacionalidades ObtenerPorId(int id);

	public Result CargarTablaDefault();
}
