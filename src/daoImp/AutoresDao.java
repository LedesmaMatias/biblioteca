package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IAutoresDao;

@Repository("autorDao")
public class AutoresDao implements IAutoresDao {

	@Autowired
	private Conexion conexion;
}
