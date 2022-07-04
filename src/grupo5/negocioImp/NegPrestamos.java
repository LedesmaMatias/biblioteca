package grupo5.negocioImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IPrestamosDao;
import grupo5.negocio.INegPrestamos;

@Service("PrestamosServicio")
public class NegPrestamos implements INegPrestamos {

	@Autowired
	private IPrestamosDao PrestamosDao;
}