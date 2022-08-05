package grupo5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import grupo5.entidad.Result;
import grupo5.negocio.INegGeneros;
import grupo5.negocio.INegLibros;
import grupo5.negocio.INegUsuarios;
import grupo5.negocioImp.NegAutores;
import grupo5.negocioImp.NegNacionalidades;

@Controller
public class ControladorInicio {

	@Autowired
	@Qualifier("UsuariosServicio")
	private INegUsuarios NegUsuarios;

	@Autowired
	@Qualifier("NacionalidadesServicio")
	private NegNacionalidades NegNacionalidad;

	@Autowired
	@Qualifier("AutoresServicio")
	private NegAutores negAutores;

	@Autowired
	@Qualifier("GenerosServicio")
	private INegGeneros negGeneros;

	@Autowired
	@Qualifier("LibrosServicio")
	private INegLibros negLibros;

	@RequestMapping("toIndex.html")
	public ModelAndView eventoRedireccionarPag1() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("index");
		return MV;
	}

	@RequestMapping("Login.html")
	public ModelAndView eventoRedireccionarLogin() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");
		Result r = NegUsuarios.CargarTablaDefault();

		return MV;
	}

	@RequestMapping("ValidarLogin.html")
	public ModelAndView eventoValidarLogin(String txtUser, String txtPass) {
		ModelAndView MV = new ModelAndView();

		boolean existe = NegUsuarios.VerificarUsuarios(txtUser, txtPass);

		// Si existe el usuario
		if (existe) {
			MV.setViewName("Main");
			// Cargo las tablas parametros
			cargarTablasPorDefecto();
		} else {
			MV.addObject("ErrorMsj", "El usuario ingresado no existe o es incorrecto.");
			MV.setViewName("Login");
		}

		return MV;
	}

	@RequestMapping("Main.html")
	public ModelAndView eventoRedireccionarMain() {
		ModelAndView MV = new ModelAndView();

		MV.setViewName("Main");

		return MV;
	}

	private void cargarTablasPorDefecto() {
		Result r = NegNacionalidad.CargarTablaDefault();
		r.println();
		r = negAutores.cargarTablaDefault();
		r.println();
		r = negGeneros.cargarTablaDefault();
		r.println();
		r = negLibros.cargarTablaDefault();
		r.println();
	}

}
