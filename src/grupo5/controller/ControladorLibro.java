package grupo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import grupo5.entidad.Libros;
import grupo5.negocio.INegLibros;

@Controller
public class ControladorLibro {

	@Autowired
	@Qualifier("LibrosServicio")
	private INegLibros negLibros;

	@RequestMapping("Libros_Grilla.html")
	public ModelAndView eventoRedireccionarLibros_Grilla(String txtISBN, String txtTitulo) {
		ModelAndView MV = new ModelAndView();

		// Parametros para la busqueda
		if (txtTitulo == null) {
			txtTitulo = "";
		}

		if (txtISBN == null) {
			txtISBN = "";
		}

		List<Libros> libros = negLibros.ObtenerFiltros(txtISBN, txtTitulo);
		MV.addObject("lista", libros.toArray());

		MV.addObject("txtTitulo", txtTitulo);
		MV.addObject("txtISBN", txtISBN);

		MV.setViewName("Libros_Grilla");
		return MV;
	}
}
