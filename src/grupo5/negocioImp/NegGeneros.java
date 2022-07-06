package grupo5.negocioImp;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IGeneroDao;
import grupo5.entidad.Generos;
import grupo5.entidad.Result;
import grupo5.negocio.INegGeneros;

@Service("GenerosServicio")
public class NegGeneros implements INegGeneros {

	@Autowired
	private IGeneroDao generosDao;

	@Override
	public Result cargarTablaDefault() {
		Result r = new Result(0, "Generos agregados correctamente");
		if(!generosDao.hayRegistros()) {
			Set<Generos> generos = new HashSet<>();
			generos.add(new Generos("Policial"));
			generos.add(new Generos("Suspenso"));
			generos.add(new Generos("Fantasía"));
			
			if(!generosDao.cargarTablaDefault(generos)) {
				r.setCodigo(2);
				r.setMensaje("Ocurrio un error al cargar la tabla por defecto de generos");
			}
		} else {
			r.setCodigo(1);
			r.setMensaje("Ya existen generos en la base de datos");
		}
		return r;
	}

	@Override
	public Generos obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Generos obtenerPorDescripcion(String descripcion) {
		Generos genero = generosDao.obtenerPorDescripcion(descripcion);
		return genero;
	}
}
