package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IdaoGenero;
import grupo5.negocio.InegGenero;

@Service("servicioGenero")
public class NegGenero implements InegGenero {

	@Autowired
	private IdaoGenero daoGenero;
}
