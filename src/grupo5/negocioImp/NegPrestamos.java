package grupo5.negocioImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo5.dao.IPrestamosDao;
import grupo5.entidad.Prestamos;
import grupo5.entidad.Result;
import grupo5.negocio.INegPrestamos;

@Service("PrestamosServicio")
public class NegPrestamos implements INegPrestamos {

	@Autowired
	private IPrestamosDao prestamosDao;

	@Override
	public Result alta(Prestamos p) {
		Result r = new Result(0, "Prestamo agregado con exito");
		boolean respuesta = prestamosDao.guardar(p);
		if(!respuesta) {
			r.setCodigo(2);
			r.setMensaje("Ocurrio un error al agregar el prestamo");
		}
		return r;
	}

	@Override
	public Result baja(int idPrestamo) {
		Result r = new Result(0, "Prestamo eliminado con exito");
		Prestamos prestamo = prestamosDao.obtener(idPrestamo);
		
		//En caso de que el prestamo sea null
		if(Objects.isNull(prestamo)) {
			r.setCodigo(1);
			r.setMensaje("Error, el prestamo no se encuentra en la base de datos");
			
		}
		
		//en caso de un error al eliminar el prestamo
		if(!prestamosDao.baja(prestamo)) {
			r.setCodigo(2);
			r.setMensaje("Error al intentar eliminar el prestamo de la base de datos");
		}
		
		return r;
	}

	@Override
	public List<Prestamos> obtenerTodos() {
		List<Prestamos> prestamos = new ArrayList<Prestamos>();
		prestamos = prestamosDao.obtenerTodos();
		return prestamos;
	}

	@Override
	public Prestamos obtener(int id) {
		Prestamos prestamo = prestamosDao.obtener(id);
		return prestamo;
	}
}