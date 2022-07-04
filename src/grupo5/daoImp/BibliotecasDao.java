package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IBibliotecasDao;

@Repository("bibliotecaDao")
public class BibliotecasDao implements IBibliotecasDao {

	@Autowired
	private Conexion conexion;
}
