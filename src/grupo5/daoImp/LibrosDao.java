package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.ILibrosDao;

@Repository("libroDao")
public class LibrosDao implements ILibrosDao {

	@Autowired
	private Conexion conexion;
}
