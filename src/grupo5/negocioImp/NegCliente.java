package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IdaoCliente;
import grupo5.negocio.InegCliente;

@Service("servicioCliente")
public class NegCliente implements InegCliente{

	@Autowired
	private IdaoCliente daoCliente;
}
