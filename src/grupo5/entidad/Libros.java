package grupo5.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Libros")
public class Libros implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ISBN")

	private String ISBN;

	@Column(name = "Titulo")
	private String Titulo;

	@Column(name = "FechaLanzamiento")
	private Date FechaLanzamiento;

	@Column(name = "Idioma")
	private String Idioma;

	@Column(name = "CantPaginas")
	private int CantPaginas;

	@Column(name = "Descripcion")
	private String Descripcion;

	@ManyToMany(cascade = { CascadeType.REFRESH })
	@JoinTable(name = "Libros_x_Generos", joinColumns = { @JoinColumn(name = "ISBN_Libro") }, inverseJoinColumns = {
			@JoinColumn(name = "IdGenero") })
	private Set<Generos> Generos = new HashSet<Generos>();

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "IdAutor")
	private Autores Autor;

	public Libros() {
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public Date getFechaLanzamiento() {
		return FechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		FechaLanzamiento = fechaLanzamiento;
	}

	public String getIdioma() {
		return Idioma;
	}

	public void setIdioma(String idioma) {
		Idioma = idioma;
	}

	public int getCantPaginas() {
		return CantPaginas;
	}

	public void setCantPaginas(int cantPaginas) {
		CantPaginas = cantPaginas;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Set<Generos> getGeneros() {
		return Generos;
	}

	public void setGeneros(Set<Generos> generos) {
		Generos = generos;
	}

	public Autores getAutor() {
		return Autor;
	}

	@Override
	public String toString() {
		return "Libros [ISBN=" + ISBN + ", Titulo=" + Titulo + ", FechaLanzamiento=" + FechaLanzamiento + ", Idioma="
				+ Idioma + ", CantPaginas=" + CantPaginas + ", Descripcion=" + Descripcion +  ", Autor=" + Autor + "]";
	}

	public void setAutor(Autores autor) {
		Autor = autor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Libros(String iSBN, String titulo, Date fechaLanzamiento, String idioma, int cantPaginas, String descripcion,
			Set<grupo5.entidad.Generos> generos, Autores autor) {
		super();
		ISBN = iSBN;
		Titulo = titulo;
		FechaLanzamiento = fechaLanzamiento;
		Idioma = idioma;
		CantPaginas = cantPaginas;
		Descripcion = descripcion;
		Generos = generos;
		Autor = autor;
	}
	

}
