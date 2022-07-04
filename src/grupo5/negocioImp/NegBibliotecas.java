package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IBibliotecasDao;
import grupo5.negocio.INegBibliotecas;

@Service("BibliotecasServicio")
public class NegBibliotecas implements INegBibliotecas {

	@Autowired
	private IBibliotecasDao BibliotecasDao;
}
