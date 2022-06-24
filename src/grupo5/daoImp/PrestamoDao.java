package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IdaoPrestamo;

@Repository("prestamoDao")
public class PrestamoDao implements IdaoPrestamo {

	@Autowired
	private Conexion conexion;
}
