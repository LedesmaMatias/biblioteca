package grupo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorInicio {

	
	@RequestMapping("toIndex.html")
	public ModelAndView eventoRedireccionarPag1()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("index");
		return MV;
	}
	
	
	@RequestMapping("Main.html")
	public ModelAndView eventoRedireccionarMain()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Main");
		return MV;
	}
	
	@RequestMapping("Clientes_Grilla.html")
	public ModelAndView eventoRedireccionarClientes_Grilla()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Clientes_Grilla");
		return MV;
	}
	
	
	@RequestMapping("Clientes_ABM.html")
	public ModelAndView eventoRedireccionarClientes_ABM()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Clientes_ABM");
		return MV;
	}
	
}
