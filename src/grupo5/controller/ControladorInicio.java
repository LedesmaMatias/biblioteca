package grupo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import grupo5.entidad.Result;
import grupo5.negocio.INegAutores;
import grupo5.negocioImp.NegAutores;
import grupo5.negocioImp.NegNacionalidades;

@Controller
public class ControladorInicio {

	@Autowired
	@Qualifier("NacionalidadesServicio")
	private NegNacionalidades NegNacionalidad;
	
	@Autowired
	@Qualifier("AutoresServicio")
	private NegAutores negAutores;

	@RequestMapping("toIndex.html")
	public ModelAndView eventoRedireccionarPag1() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping("Login.html")
	public ModelAndView eventoRedireccionarLogin() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("login");
		return MV;
	}

	@RequestMapping("Main.html")
	public ModelAndView eventoRedireccionarMain() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Main");

		// Cargo las tablas parametros
		Result r = NegNacionalidad.CargarTablaDefault();
		r.println();
		r = negAutores.cargatTablaDefault();
		r.println();

		return MV;
	}

}
