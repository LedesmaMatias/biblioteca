package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IdaoBiblioteca;
import grupo5.negocio.InegBiblioteca;

@Service("servicioBiblioteca")
public class NegBiblioteca implements InegBiblioteca {

	@Autowired
	private IdaoBiblioteca daoBiblioteca;
}
