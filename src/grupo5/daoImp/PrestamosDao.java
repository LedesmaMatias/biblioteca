package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IPrestamosDao;

@Repository("prestamoDao")
public class PrestamosDao implements IPrestamosDao {

	@Autowired
	private Conexion conexion;
}
