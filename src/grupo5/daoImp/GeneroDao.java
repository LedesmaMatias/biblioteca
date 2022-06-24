package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IdaoGenero;

@Repository("generoDao")
public class GeneroDao implements IdaoGenero{

	@Autowired
	private Conexion conexion;
}
