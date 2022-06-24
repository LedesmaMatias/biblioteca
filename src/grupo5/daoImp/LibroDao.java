package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IdaoLibro;

@Repository("libroDao")
public class LibroDao implements IdaoLibro {

	@Autowired
	private Conexion conexion;
}
