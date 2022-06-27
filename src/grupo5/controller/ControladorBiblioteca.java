package grupo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorBiblioteca {

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
}
