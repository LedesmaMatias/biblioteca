package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IGeneroDao;
import grupo5.negocio.INegGeneros;

@Service("GenerosServicio")
public class NegGeneros implements INegGeneros {

	@Autowired
	private IGeneroDao GenerosDao;
}
