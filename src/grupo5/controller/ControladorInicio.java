package grupo5.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import grupo5.daoImp.*;

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
		
		//Cargo las tablas parametros
		NacionalidadDao.CargarNacionalidades();
		
		
		
		return MV;
	}
	


	
}
