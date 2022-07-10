package grupo5.negocioImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IBibliotecasDao;
import grupo5.entidad.Bibliotecas;
import grupo5.entidad.Result;
import grupo5.negocio.INegBibliotecas;

@Service("BibliotecasServicio")
public class NegBibliotecas implements INegBibliotecas {

	@Autowired
	private IBibliotecasDao bibliotecasDao;

	@Override
	public Result alta(Bibliotecas b) {
		
		Result r = new Result(0, "Libro agregado a la biblioteca correctamente");
		
		boolean respuesta = bibliotecasDao.Guardar(b);
		
		if(!respuesta) {
			r.setCodigo(2);
			r.setMensaje("Ocurrio un error al agregar el libro a la biblioteca");
		}
		return r;
	}

	@Override
	public List<Bibliotecas> obtenerTodos() {
		List<Bibliotecas> libros = new ArrayList<Bibliotecas>();
		libros = bibliotecasDao.obtenerTodos();
		return libros;
	}
}
