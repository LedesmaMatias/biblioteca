package grupo5.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Biblioteca")
public class Biblioteca implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_biblioteca")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_biblioteca;
	@Column(name = "fecla_alta")
	private Date fecha_alta;
	@Column(name = "estado")
	private int estado;
	
	@ManyToOne(cascade= {CascadeType.REFRESH})
	@JoinColumn(name="ISBN")
	private Libro libro;
	
	public Biblioteca(int id, Date fecha_alta, int estado, Libro libro) {
		super();
		this.ID_biblioteca = id;
		this.fecha_alta = fecha_alta;
		this.estado = estado;
		this.libro = libro;
	}
	
	public Biblioteca() {
		
	}
	
	

	public int getID_biblioteca() {
		return ID_biblioteca;
	}

	public void setID_biblioteca(int iD_biblioteca) {
		ID_biblioteca = iD_biblioteca;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Biblioteca [ID_biblioteca=" + ID_biblioteca + ", fecha_alta=" + fecha_alta + ", estado=" + ((estado==1)?"En biblioteca":"Prestado")
				+ ", libro=" + libro + "]";
	}
	
	
	

}
