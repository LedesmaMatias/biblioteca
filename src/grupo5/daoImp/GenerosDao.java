package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IGeneroDao;

@Repository("generoDao")
public class GenerosDao implements IGeneroDao{

	@Autowired
	private Conexion conexion;
}
