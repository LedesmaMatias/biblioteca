package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IdaoUsuario;

@Repository("usuarioDao")
public class UsuarioDao implements IdaoUsuario {

	@Autowired
	private Conexion conexion;
	
	
}
