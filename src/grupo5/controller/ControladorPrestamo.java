package grupo5.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import grupo5.entidad.Bibliotecas;
import grupo5.entidad.Clientes;
import grupo5.entidad.Prestamos;
import grupo5.entidad.Result;
import grupo5.negocio.INegBibliotecas;
import grupo5.negocio.INegClientes;
import grupo5.negocio.INegPrestamos;
import grupo5.negocioImp.NegClientes;

@Controller
public class ControladorPrestamo {

	@Autowired
	@Qualifier("PrestamosServicio")
	private INegPrestamos negPrestamos;

	@Autowired
	@Qualifier("BibliotecasServicio")
	private INegBibliotecas negBibliotecas;

	@Autowired
	@Qualifier("ClientesServicio")
	private INegClientes negClientes;

	@Autowired
	@Qualifier("ClientesServicio")
	private NegClientes NegCliente;

	@RequestMapping("Prestamos_Grilla.html")
	public ModelAndView eventoRedireccionarPrestamos_Grilla() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Prestamos_Grilla");
		List<Prestamos> prestamos = negPrestamos.obtenerTodos();
		MV.addObject("lista", prestamos.toArray());
		return MV;
	}

	@RequestMapping("Prestamos_ABM.html")
	public ModelAndView eventoRedireccionarPrestamos_Alta() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Prestamos_Alta");

		// Obtenga la lista de clientes
		List<Clientes> cl = NegCliente.ObtenerFiltros(0, 0, "", "", 1);

		List<Bibliotecas> biblio = negBibliotecas.obtenerPorFiltro(1);

		MV.addObject("listaClientes", cl.toArray());
		MV.addObject("LibrosLista", biblio);

		return MV;
	}

	@RequestMapping("Prestamos_Baja.html")
	public ModelAndView eventoEliminarPrestamo(Integer idPrestamo) {
		ModelAndView MV = new ModelAndView();
		Prestamos prestamo = negPrestamos.obtener(idPrestamo);
		Bibliotecas biblioteca = negBibliotecas.obtener(prestamo.getBiblioteca().getId());
		biblioteca.setEstado(1);
		Result r = negBibliotecas.alta(biblioteca);
		r = negPrestamos.baja(idPrestamo);
		List<Prestamos> prestamos = negPrestamos.obtenerTodos();
		MV.setViewName("Prestamos_Grilla");
		MV.addObject("lista", prestamos.toArray());
		MV.addObject("ErrorMsj", r.getMensaje());
		return MV;
	}

	@RequestMapping("Prestamos_ABM_Modificar.html")
	public ModelAndView eventoRedireccionarBiblioteca_ABM_Modificar(Integer idPrestamo) {
		ModelAndView MV = new ModelAndView();
		Prestamos prestamo = negPrestamos.obtener(idPrestamo);

		MV.setViewName("Prestamos_Alta");
		MV.addObject("idPrestamo", idPrestamo);
		return MV;
	}

	@RequestMapping("Prestamos_Modificar.html")
	public ModelAndView eventoModificarPrestamo(Integer idPrestamo, Integer txtBiblioteca, String dateFecha,
			Integer txtDias, Integer txtCliente) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Prestamos_Alta");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Prestamos prestamo = negPrestamos.obtener(idPrestamo);

		Bibliotecas bibliotecaAnterior = negBibliotecas.obtener(prestamo.getBiblioteca().getId());
		Bibliotecas bibliotecaNueva = negBibliotecas.obtener(txtBiblioteca);
		Clientes cliente = negClientes.ObtenerPorId(txtCliente);

		if (Objects.isNull(bibliotecaNueva)) {

			MV.addObject("ErrorMsj", "El libro en la biblioteca no existe");
			return MV;
		}

		if (Objects.isNull(cliente)) {
			MV.addObject("ErrorMsj", "El cliente no existe");
			return MV;
		}

		// parseo la fecha
		try {
			date = formato.parse(dateFecha);
		} catch (ParseException e) {
			e.printStackTrace();
			MV.addObject("ErrorMsj", "Error con la fecha ingresada");
			return MV;
		}

		// Libero el libro en biblioteca anterior
		bibliotecaAnterior.setEstado(1);
		Result r = negBibliotecas.alta(bibliotecaAnterior);
		if (r.getCodigo() != 0) {
			MV.addObject("ErrorMsj", r.getMensaje());
			return MV;
		}

		// Modifico el estado del libro en biblioteca
		bibliotecaNueva.setEstado(2);
		r = negBibliotecas.alta(bibliotecaNueva);
		if (r.getCodigo() != 0) {
			MV.addObject("ErrorMsj", r.getMensaje());
			return MV;
		}

		// Guardo el prestamo

		prestamo.setFechaPrestamo(date);
		prestamo.setCantDias(txtDias);
		prestamo.setCliente(cliente);
		prestamo.setBiblioteca(bibliotecaNueva);
		r = negPrestamos.alta(prestamo);
		if (r.getCodigo() != 0) {
			MV.addObject("ErrorMsj", r.getMensaje());
			return MV;
		}

		MV.setViewName("Prestamos_Grilla");
		List<Prestamos> prestamos = negPrestamos.obtenerTodos();
		MV.addObject("idPrestamo", idPrestamo);
		MV.addObject("lista", prestamos.toArray());
		MV.addObject("ErrorMsj", "Prestamo agregado con exito");
		return MV;
	}

	@RequestMapping("Prestamos_Alta.html")
	public ModelAndView eventoNuevoPrestamo(Integer txtBiblioteca, String dateFecha, Integer txtDias,
			Integer txtCliente) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Prestamos_Alta");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		// TODO: VALIDAR QUE TXTBIBLIOTECA y TXTCLIENTE SEA NUMERICO
		Bibliotecas biblioteca = negBibliotecas.obtener(txtBiblioteca);
		Clientes cliente = negClientes.ObtenerPorId(txtCliente);

		if (Objects.isNull(biblioteca)) {

			MV.addObject("ErrorMsj", "El libro en la biblioteca no existe");
			return MV;
		}

		if (Objects.isNull(cliente)) {
			MV.addObject("ErrorMsj", "El cliente no existe");
			return MV;
		}

		// parseo la fecha
		try {
			date = formato.parse(dateFecha);
		} catch (ParseException e) {
			e.printStackTrace();
			MV.addObject("ErrorMsj", "Error con la fecha ingresada");
			return MV;
		}

		// Modifico el estado del libro en biblioteca
		biblioteca.setEstado(2);
		Result r = negBibliotecas.alta(biblioteca);
		if (r.getCodigo() != 0) {
			MV.addObject("ErrorMsj", r.getMensaje());
			return MV;
		}

		// Guardo el prestamo
		Prestamos prestamo = new Prestamos(date, txtDias, cliente, biblioteca);
		r = negPrestamos.alta(prestamo);
		if (r.getCodigo() != 0) {
			MV.addObject("ErrorMsj", r.getMensaje());
			return MV;
		}

		MV.setViewName("Prestamos_Grilla");
		List<Prestamos> prestamos = negPrestamos.obtenerTodos();
		MV.addObject("lista", prestamos.toArray());
		MV.addObject("ErrorMsj", "Prestamo agregado con exito");
		return MV;
	}
}