package grupo5.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import grupo5.daoImp.LibrosDao;
import grupo5.entidad.Bibliotecas;
import grupo5.entidad.Libros;
import grupo5.entidad.Result;
import grupo5.negocio.INegBibliotecas;
import grupo5.negocio.INegLibros;
import grupo5.negocioImp.NegBibliotecas;

@Controller
public class ControladorBiblioteca {

	@Autowired
	@Qualifier("BibliotecasServicio")
	private INegBibliotecas negBibliotecas;
	
	@Autowired
	@Qualifier("LibrosServicio")
	private INegLibros negLibros;
	
	@RequestMapping("Biblioteca_Grilla.html")
	public ModelAndView eventoRedireccionarBiblioteca_Grilla() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Biblioteca_Grilla");
		return MV;
	}

	@RequestMapping("Biblioteca_ABM.html")
	public ModelAndView eventoRedireccionarBiblioteca_ABM() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Biblioteca_ABM");
		return MV;
	}
	
	@RequestMapping("Biblioteca_Alta.html")
	public ModelAndView eventoNuevoLibroEnBiblioteca(String txtLibro, String dateFecha) {
		ModelAndView MV = new ModelAndView();
		SimpleDateFormat formato = new SimpleDateFormat("yyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		
		Libros libro = negLibros.obtenerPorISBN(txtLibro);
		
		// Compruebo si el libro existe
		if(Objects.isNull(libro)) {
			MV.setViewName("Biblioteca_ABM");
			MV.addObject("ErrorMsj", "El libro no existe en la base de datos");
			return MV;
		}
		
		// Parseo la fecha
		try {
			date = formato.parse(dateFecha);
		} catch (ParseException e) {
			e.printStackTrace();
			MV.setViewName("Biblioteca_ABM");
			MV.addObject("ErrorMsj","Error con la fecha ingresada");
			return MV;
		}
		
		// Guardo el libro en la biblioteca
		Bibliotecas biblioteca = new Bibliotecas(libro, date);
		Result r = negBibliotecas.alta(biblioteca);
		if(r.getCodigo() != 0) {
			MV.setViewName("Biblioteca_ABM");
			MV.addObject("ErrorMsj", r.getMensaje());
		}
		
		//Si todo sale bien
		MV.setViewName("Biblioteca_Grilla");
		
		
		return MV;
	}

}
