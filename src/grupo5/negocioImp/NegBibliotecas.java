package grupo5.negocioImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		
		boolean respuesta = bibliotecasDao.guardar(b);
		
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

	@Override
	public Result baja(int idBiblioteca) {
		Result r = new Result(0, "Libro eliminado de bilbioteca correctamente");
		Bibliotecas libro = bibliotecasDao.obtener(idBiblioteca);
		
		//En caso de que el libro vuelva como Null
		if(Objects.isNull(libro)) {
			r.setCodigo(1);
			r.setMensaje("Error, el libro no se encuentra en la biblioteca");
		}
		
		//en caso de un error al eliminar el libro de biblioteca
		if(!bibliotecasDao.baja(libro)) {
			r.setCodigo(2);
			r.setMensaje("Error al intentar eliminar el libro de biblioteca");
		}
		
		return r;
	}

	@Override
	public Bibliotecas obtener(int id) {
		Bibliotecas libro = bibliotecasDao.obtener(id);
		
		return libro;
	}
}
