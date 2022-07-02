package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.ILibrosDao;
import grupo5.negocio.INegLibros;

@Service("LibrosServicio")
public class NegLibros implements INegLibros {

	@Autowired
	private ILibrosDao LibrosDao;
}
