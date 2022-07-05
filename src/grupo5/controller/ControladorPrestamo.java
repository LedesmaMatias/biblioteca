package grupo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPrestamo {

	@RequestMapping("Prestamos_Grilla.html")
	public ModelAndView eventoRedireccionarPrestamos_Grilla() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Prestamos_Grilla");
		return MV;
	}
	
	@RequestMapping("Prestamos_Alta.html")
	public ModelAndView eventoRedireccionarPrestamos_Alta() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Prestamos_Alta");
		return MV;
	}
}
