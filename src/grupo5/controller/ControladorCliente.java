package grupo5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import grupo5.daoImp.ClienteDao;
import grupo5.daoImp.NacionalidadDao;
import grupo5.entidad.Cliente;
import grupo5.entidad.Nacionalidad;
import grupo5.entidad.Result;

@Controller
public class ControladorCliente {

	@RequestMapping("Clientes_Grilla.html")
	public ModelAndView eventoRedireccionarClientes_Grilla() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Clientes_Grilla");

		return MV;
	}

	@RequestMapping("Clientes_ABM.html")
	public ModelAndView eventoRedireccionarClientes_ABM() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Clientes_ABM");
		return MV;
	}

	@RequestMapping("Clientes_Alta.html")
	public ModelAndView evento_Clientes_Alta(String txtNombre, String txtApellido, Integer txtDNI, Integer cboNacio,
			String txteMail, String txtDireccion, String txtLocalidad, String txtTelefono, String txtNac) {

		Nacionalidad n = NacionalidadDao.ReadOne(cboNacio);// Busco el objeto nacionalida xq lo pide la clase cliente

		// Genero cliente para guardar en base
		Cliente c = new Cliente(txtDNI, txtNombre, txtApellido, n, txteMail, txtDireccion, txtLocalidad, txtTelefono,
				txtNac);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("Clientes_Grilla");

		// Si sale todo bien
		String ErrorMsj = "El cliente se agrego correctamente";
		int ErrorCodigo = 0;

		// intento guardar
		Result r = ClienteDao.ClienteAlta(c);

		// Si hubo algun fallo me quedo en Clientes ABM e informo el error, sino me voy
		// a la grilla
		if (r.getCodigo() != 0) {
			ErrorCodigo = r.getCodigo();
			ErrorMsj = r.getMensaje();
			mv.setViewName("Clientes_ABM");
		}

		mv.addObject("ErroCodigo", ErrorCodigo);
		mv.addObject("ErroMsj", ErrorMsj);

		return mv;
	}

}
