package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IdaoAutor;
import grupo5.negocio.InegAutor;

@Service("servicioAutor")
public class NegAutor implements InegAutor {

	@Autowired
	private IdaoAutor daoAutor;
}
