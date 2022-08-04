package grupo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import grupo5.negocio.INegPrestamos;

@Controller
public class ControladorPrestamo {

	@Autowired
	@Qualifier("PrestamosServicio")
	private INegPrestamos negPrestamos;
	
	
	@RequestMapping("Prestamos_Grilla.html")
	public ModelAndView eventoRedireccionarPrestamos_Grilla() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Prestamos_Grilla");
		return MV;
	}
	
	@RequestMapping("Prestamos_ABM.html")
	public ModelAndView eventoRedireccionarPrestamos_Alta() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Prestamos_Alta");
		return MV;
	}
	
	@RequestMapping("Prestamos_Alta.html")
	public ModelAndView eventoNuevoPrestamo() {
		ModelAndView MV = new ModelAndView();
		return MV;
	}
}
