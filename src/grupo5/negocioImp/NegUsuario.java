package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IdaoUsuario;
import grupo5.negocio.InegUsuario;

@Service("servicioUsuario")
public class NegUsuario implements InegUsuario{
	
	@Autowired
	private IdaoUsuario daoUsuario;

}
