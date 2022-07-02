package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IUsuariosDao;
import grupo5.negocio.INegUsuarios;

@Service("UsuariosServicio")
public class NegUsuario implements INegUsuarios {

	@Autowired
	private IUsuariosDao UsuarioDao;

}
