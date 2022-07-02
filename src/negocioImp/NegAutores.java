package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IAutoresDao;
import grupo5.negocio.INegAutores;

@Service("AutoresServicios")
public class NegAutores implements INegAutores {

	@Autowired
	private IAutoresDao AutoresDao;
}
