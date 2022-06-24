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
@Table(name="Libros")
public class Libro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ISBN")
	
	private int ISBN;
	@Column(name="titulo")
	private String titulo;
	@Column(name="fecha_lanzamiento")
	private Date fechaLanzamiento;
	@Column(name="idioma")
	private String idioma;
	@Column(name="cantidad_paginas")
	private int cantidad_paginas;
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="libros_x_generos", joinColumns= {@JoinColumn(name="ISBN_libro")}, inverseJoinColumns= {@JoinColumn(name="ID_genero")})
	private Set<Genero> generos = new HashSet<Genero>();
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="ID_autor")
	private Autor autor;
	
	public Libro() {}
	
	public Libro(int ISBN, String titulo, Date fechaLanzamiento, String idioma, int cantidad_paginas, String descripcion, Set<Genero> generos, Autor autor) {
		super();
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.idioma = idioma;
		this.cantidad_paginas = cantidad_paginas;
		this.descripcion = descripcion;
		this.generos = generos;
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", fechaLanzamiento=" + fechaLanzamiento + ", idioma="
				+ idioma + ", cantidad_paginas=" + cantidad_paginas + ", descripcion=" + descripcion + ", autor=" + autor +"]";
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getCantidad_paginas() {
		return cantidad_paginas;
	}

	public void setCantidad_paginas(int cantidad_paginas) {
		this.cantidad_paginas = cantidad_paginas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	

}
