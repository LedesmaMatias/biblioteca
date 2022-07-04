package grupo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorLibro {

	@RequestMapping("Libros_Grilla.html")
	public ModelAndView eventoRedireccionarLibros_Grilla() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Libros_Grilla");
		return MV;
	}
}
