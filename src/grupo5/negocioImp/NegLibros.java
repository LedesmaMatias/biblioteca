package grupo5.negocioImp;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import grupo5.dao.ILibrosDao;
import grupo5.entidad.Generos;
import grupo5.entidad.Libros;
import grupo5.entidad.Result;
import grupo5.negocio.INegAutores;
import grupo5.negocio.INegGeneros;
import grupo5.negocio.INegLibros;

@Service("LibrosServicio")
public class NegLibros implements INegLibros {

	@Autowired
	private ILibrosDao librosDao;

	@Autowired
	@Qualifier("AutoresServicio")
	private INegAutores negAutores;

	@Autowired
	@Qualifier("GenerosServicio")
	private INegGeneros negGeneros;

	@Override
	public Result cargarTablaDefault() {
		Result r = new Result(0, "Libros agregados correctamente");
		if (!librosDao.hayRegistros()) {
			Set<Libros> libros = new HashSet<Libros>();
			Set<Generos> generosLibro1 = new HashSet<Generos>();

			generosLibro1.add(negGeneros.obtenerPorDescripcion("Fantasia"));
			libros.add(new Libros("8493283614", "El ultimo deseo", new Date(System.currentTimeMillis()), "Español", 174,
					"La historia de Geralt de Rivia", generosLibro1, negAutores.obtenerPorId(3)));

			Set<Generos> generosLibro3 = new HashSet<Generos>();
			generosLibro3.add(negGeneros.obtenerPorDescripcion("Policial"));
			libros.add(new Libros("9789871512072", "Estudio en escarlata", new Date(System.currentTimeMillis()),
					"Español", 174, "El detective Sherlock Holmes y su compañero, el doctor Watson", generosLibro3,
					negAutores.obtenerPorId(2)));

			Set<Generos> generosLibro2 = new HashSet<Generos>();
			generosLibro2.add(negGeneros.obtenerPorDescripcion("Policial"));
			generosLibro2.add(negGeneros.obtenerPorDescripcion("Suspenso"));
			libros.add(new Libros("8401011809", "Instinto Animal", new Date(System.currentTimeMillis()), "Español", 349,
					"Una maleta con un millon de dolares", generosLibro2, negAutores.obtenerPorId(1)));

			if (!librosDao.cartarTablaDefault(libros)) {
				r.setCodigo(2);
				r.setMensaje("Ocurrio un error al cargar la tabla por defecto de libros");
			}
		} else {
			r.setCodigo(1);
			r.setMensaje("Ya existen libros por defecto");
		}
		return r;
	}

	@Override
	public Libros obtenerPorISBN(String ISBN) {
		Libros libro = librosDao.obtenerPorISBN(ISBN);
		return libro;
	}

	@Override
	public List<Libros> ObtenerFiltros(String ISBN, String Titulo) {

		List<Libros> LibrosList = librosDao.ObtenerFiltros(ISBN, Titulo);
		return LibrosList;

	}
}
