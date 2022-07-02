package grupo5.negocioImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.INacionalidadesDao;
import grupo5.entidad.Nacionalidades;
import grupo5.entidad.Result;
import grupo5.negocio.INegNacionalidades;

@Service("NacionalidadesServicio")
public class NegNacionalidades implements INegNacionalidades {

	@Autowired
	private INacionalidadesDao NacionalidadDao;

	@Override
	public List<Nacionalidades> Obtener() {
		return NacionalidadDao.Obtener();
	}

	@Override
	public Nacionalidades ObtenerPorId(int id) {
		return NacionalidadDao.ObtenerPorId(id);
	}

	@Override
	public Result CargarTablaDefault() {

		Result r = new Result(0, "El cliente se agrego correctamente.");

		List<Nacionalidades> NacioListaAux = NacionalidadDao.Obtener(); // Obtengo la tabla

		if (NacioListaAux.size() == 0) // Si no hay registros
		{

			// declaro Lista de nacio
			List<Nacionalidades> NacioLista = new ArrayList<Nacionalidades>();

			// Declaro nacionalidades
			Nacionalidades n1 = new Nacionalidades();
			n1.setDescripcion("Argentina");

			Nacionalidades n2 = new Nacionalidades();
			n2.setDescripcion("Mexico");

			Nacionalidades n3 = new Nacionalidades();
			n3.setDescripcion("EEUU");

			Nacionalidades n4 = new Nacionalidades();
			n4.setDescripcion("Colombia");

			NacioLista.add(n1);
			NacioLista.add(n2);
			NacioLista.add(n3);
			NacioLista.add(n4);

			Boolean Respuesta = NacionalidadDao.CargarTablaDefault(NacioLista); // Cargo la tabla deefault

			if (Respuesta == false) {
				r.setCodigo(1);
				r.setMensaje("Ocurrio un error al dar de alta las Nacionalidades.");
			}

		} else {

			r.setCodigo(0);
			r.setMensaje("Ya existen Nacionalidades en la base");
		}

		return r; // devuelvo la respuesta

	}
}
