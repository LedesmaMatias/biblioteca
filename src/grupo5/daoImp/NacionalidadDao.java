package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IdaoNacionalidad;

@Repository("nacionalidadDao")
public class NacionalidadDao implements IdaoNacionalidad {

	@Autowired
	private Conexion conexion;
}
