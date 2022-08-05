package grupo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Entidades
import grupo5.entidad.Clientes;
import grupo5.entidad.Nacionalidades;
import grupo5.entidad.Result;
//Negocio
import grupo5.negocioImp.NegClientes;
import grupo5.negocioImp.NegNacionalidades;

@Controller
public class ControladorCliente {

	@Autowired
	@Qualifier("ClientesServicio")
	private NegClientes NegCliente;

	@Autowired
	@Qualifier("NacionalidadesServicio")
	private NegNacionalidades NegNacionalidad;

	@RequestMapping("Clientes_Grilla.html")
	public ModelAndView eventoRedireccionarClientes_Grilla(String txtNombre, String txtApellido, Integer txtDNI) {
		ModelAndView mv = new ModelAndView();

		// Parametros para la busqueda
		if (txtNombre == null) {
			txtNombre = "";
		}

		if (txtApellido == null) {
			txtApellido = "";
		}

		if (txtDNI == null) {
			txtDNI = 0;
		}

		// Obtenga la lista de clientes
		List<Clientes> cl = NegCliente.ObtenerFiltros(0, txtDNI, txtNombre, txtApellido);

		mv.addObject("lista", cl.toArray());
		mv.addObject("txtApellido", txtApellido);
		mv.addObject("txtDNI", txtDNI);
		mv.addObject("txtNombre", txtNombre);

		mv.setViewName("Clientes_Grilla");
		return mv;
	}

	@RequestMapping("Clientes_ABM.html")
	public ModelAndView eventoRedireccionarClientes_ABM() {
		ModelAndView mv = new ModelAndView();

		// Para el Select de Nacionalidades
		List<Nacionalidades> NacioLista = NegNacionalidad.Obtener();

		mv.addObject("NacioLista", NacioLista);

		mv.setViewName("Clientes_ABM");
		return mv;
	}

	@RequestMapping("Clientes_ABM_Editar.html")
	public ModelAndView eventoRedireccionarClientes_ABM_Editar(Integer IdCliente) {
		ModelAndView mv = new ModelAndView();

		Clientes cl = NegCliente.ObtenerPorId(IdCliente);

		mv.addObject("cliente", cl);

		// Para el Select de Nacionalidades
		List<Nacionalidades> NacioLista = NegNacionalidad.Obtener();
		mv.addObject("NacioLista", NacioLista);

		mv.setViewName("Clientes_ABM");
		return mv;
	}

	@RequestMapping("Clientes_Alta.html")
	public ModelAndView evento_Clientes_Alta(String txtNombre, String txtApellido, Integer txtDNI, Integer cboNacio,
			String txteMail, String txtDireccion, String txtLocalidad, String txtTelefono, String txtNac) {

		Nacionalidades n = NegNacionalidad.ObtenerPorId(cboNacio);// Busco el objeto nacionalida xq lo pide la clase
		// cliente

		// Genero cliente para guardar en base
		Clientes c = new Clientes(0, txtDNI, txtNombre, txtApellido, n, txteMail, txtDireccion, txtLocalidad,
				txtTelefono, txtNac);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("Clientes_Grilla");

		// Si sale todo bien
		String ErrorMsj = "El cliente se agrego correctamente";
		int ErrorCodigo = 0;

		// intento guardar
		Result r = NegCliente.Alta(c);

		// Si hubo algun fallo me quedo en Clientes ABM e informo el error, sino me voy
		// a la grilla
		if (r.getCodigo() != 0) {

			ErrorCodigo = r.getCodigo();
			ErrorMsj = r.getMensaje();

			mv.setViewName("Clientes_ABM");

			mv.addObject("ErroCodigo", ErrorCodigo);
			mv.addObject("ErroMsj", ErrorMsj);

			return mv;

		}

		// Obtenga la lista de clientes
		List<Clientes> cl = NegCliente.ObtenerFiltros(0, txtDNI, txtNombre, txtApellido);

		mv.addObject("lista", cl.toArray());
		mv.addObject("txtApellido", txtApellido);
		mv.addObject("txtDNI", txtDNI);
		mv.addObject("txtNombre", txtNombre);

		mv.setViewName("Clientes_Grilla");

		mv.addObject("ErroCodigo", ErrorCodigo);
		mv.addObject("ErroMsj", ErrorMsj);

		return mv;
	}

	@RequestMapping("Clientes_Editar.html")
	public ModelAndView evento_Clientes_Alta(Integer txtIdCliente, String txtNombre, String txtApellido, Integer txtDNI,
			Integer cboNacio, String txteMail, String txtDireccion, String txtLocalidad, String txtTelefono,
			String txtNac) {

		Nacionalidades n = NegNacionalidad.ObtenerPorId(cboNacio);// Busco el objeto nacionalida xq lo pide la clase
																	// cliente

		// Genero cliente para guardar en base
		Clientes c = new Clientes(txtIdCliente, txtDNI, txtNombre, txtApellido, n, txteMail, txtDireccion, txtLocalidad,
				txtTelefono, txtNac);

		ModelAndView mv = new ModelAndView();

		// Si sale todo bien
		String ErrorMsj = "El cliente se agrego correctamente";
		int ErrorCodigo = 0;

		// intento guardar
		Result r = NegCliente.Modificar(c);

		// Si hubo algun fallo me quedo en Clientes ABM e informo el error, sino me voy
		// a la grilla
		if (r.getCodigo() != 0) {

			ErrorCodigo = r.getCodigo();
			ErrorMsj = r.getMensaje();

			mv.setViewName("Clientes_ABM");

			mv.addObject("ErroCodigo", ErrorCodigo);
			mv.addObject("ErroMsj", ErrorMsj);

			return mv;

		}

		// Obtenga la lista de clientes
		List<Clientes> cl = NegCliente.ObtenerFiltros(0, txtDNI, txtNombre, txtApellido);

		mv.addObject("lista", cl.toArray());
		mv.addObject("txtApellido", txtApellido);
		mv.addObject("txtDNI", txtDNI);
		mv.addObject("txtNombre", txtNombre);

		mv.setViewName("Clientes_Grilla");

		mv.addObject("ErroCodigo", ErrorCodigo);
		mv.addObject("ErroMsj", ErrorMsj);

		return mv;

	}
	@RequestMapping("Clientes_ABM_CambiarEstado.html")
	public ModelAndView evento_Clientes_CambiarEstado(Integer IdCliente,String txtNombre, String txtApellido, Integer txtDNI) {
		
		ModelAndView mv = new ModelAndView();
	
		// Si sale todo bien
		String ErrorMsj = "El cliente se Modifico correctamente";
		int ErrorCodigo = 0;

		// intento guardar
		Result r = NegCliente.CambiarEstado(IdCliente);

		// Si hubo algun fallo me quedo en Clientes ABM e informo el error, sino me voy
		// a la grilla
		if (r.getCodigo() != 0) {

			ErrorCodigo = r.getCodigo();
			ErrorMsj = r.getMensaje();	
		}
	
		
		mv.addObject("txtApellido", txtApellido);
		mv.addObject("txtDNI", txtDNI);
		mv.addObject("txtNombre", txtNombre);
		mv.addObject("ErroCodigo", ErrorCodigo);
		mv.addObject("ErroMsj", ErrorMsj);

		mv.setViewName("Clientes_Grilla");
		
	    return mv;
	}
}