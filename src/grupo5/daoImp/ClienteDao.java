package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IdaoCliente;

@Repository("clienteDao")
public class ClienteDao implements IdaoCliente {

	@Autowired
	private Conexion conexion;
}
