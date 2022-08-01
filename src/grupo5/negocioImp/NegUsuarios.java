package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IUsuariosDao;
import grupo5.entidad.Result;
import grupo5.entidad.Usuarios;
import grupo5.negocio.INegUsuarios;

@Service("UsuariosServicio")
public class NegUsuarios implements INegUsuarios {

	@Autowired
	private IUsuariosDao UsuariosDao;

	@Override
	public Boolean VerificarUsuarios(String Usuario, String Pass) {
		return UsuariosDao.Verificar(Usuario, Pass);
	}

	@Override
	public Result CargarTablaDefault() {

		Result r = new Result(0, "El cliente se agrego correctamente.");

		Usuarios user = new Usuarios();

		user.setUser("Admin");
		user.setPass("123");
		Boolean Respuesta = UsuariosDao.CargarTablaDefault(user); // Cargo la tabla deefault

		if (Respuesta == false) {
			r.setCodigo(1);
			r.setMensaje("Ocurrio un error al dar de alta el Usuario Administrador.");
		}

		else {

			r.setCodigo(0);
			r.setMensaje("Ya existen usuario Administrador en la base");
		}

		return r; // devuelvo la respuesta

	}

}
