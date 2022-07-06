package grupo5.negocioImp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import grupo5.dao.IAutoresDao;
import grupo5.entidad.Autores;
import grupo5.entidad.Result;
import grupo5.negocio.INegAutores;
import grupo5.negocio.INegNacionalidades;

@Service("AutoresServicio")
public class NegAutores implements INegAutores {

	@Autowired
	private IAutoresDao autoresDao;
	
	@Autowired
	@Qualifier("NacionalidadesServicio")
	private INegNacionalidades negNacionalidades;

	@Override
	public Result cargarTablaDefault() {
		Result r = new Result(0, "Autores agregados correctamente");
		if(!autoresDao.hayRegistros()) {
			List<Autores> autores = new ArrayList<Autores>();
			
			autores.add(new Autores("Alfonso", "Rojo","alfonsorojo@gmail.com" , negNacionalidades.ObtenerPorId(5)));
			autores.add(new Autores("Arthur", "Conan Doyle","arthurConan@gmail.com" , negNacionalidades.ObtenerPorId(6)));
			autores.add(new Autores("Andrzej", "Sapkowski","andrzekSap@gmail.com" , negNacionalidades.ObtenerPorId(7)));
			
			boolean b = autoresDao.cargarTablaDefault(autores);
			
			if (!b) {
				r.setCodigo(2);
				r.setMensaje("Ocurrio un error al cargar la tabla de autores por defecto");
			}
		} else {
			r.setCodigo(1);
			r.setMensaje("Ya existen Autores en la base de datos");
		}
		return r;
	}

	@Override
	public Autores obtenerPorId(int id) {
		Autores autor = autoresDao.obtenerPorId(id);
		return autor;
	}
}
