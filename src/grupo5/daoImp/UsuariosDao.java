package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IUsuariosDao;

@Repository("UsuariosDao")
public class UsuariosDao implements IUsuariosDao {

	@Autowired
	private Conexion conexion;

}
