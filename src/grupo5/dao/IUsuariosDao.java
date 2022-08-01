package grupo5.dao;

import grupo5.entidad.Usuarios;

public interface IUsuariosDao {

	Boolean Verificar(String Usuario, String Pass);

	Boolean CargarTablaDefault(Usuarios user);

}
