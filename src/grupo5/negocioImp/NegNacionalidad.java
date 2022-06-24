package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IdaoNacionalidad;
import grupo5.negocio.InegNacionalidad;

@Service("servicioNacionalidad")
public class NegNacionalidad implements InegNacionalidad{

	@Autowired
	private IdaoNacionalidad daoNacionalidad;
}
