package grupo5.negocio;

import grupo5.entidad.Result;

public interface INegUsuarios {

	Boolean VerificarUsuarios(String Usuario, String Pass);

	Result CargarTablaDefault();

}
