package grupo5.daoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grupo5.dao.IdaoBiblioteca;

@Repository("bibliotecaDao")
public class BibliotecaDao implements IdaoBiblioteca {

	@Autowired
	private Conexion conexion;
}
