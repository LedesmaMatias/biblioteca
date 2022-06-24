package grupo5.entidad;

import java.io.Serializable;

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
@Table(name="Autores")
public class Autor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_autor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_autor;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="email")
	private String email;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="ID_nacionalidad")
	private Nacionalidad nacionalidad;
	
	public Autor() {}
	
	public Autor(int ID, String nombre, String apellido, String email, Nacionalidad nacionalidad) {
		super();
		this.ID_autor = ID;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nacionalidad = nacionalidad;
	}

	public int getID() {
		return ID_autor;
	}

	public void setID(int id) {
		this.ID_autor = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return "Autor [ID_autor=" + ID_autor + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", nacionalidad=" + nacionalidad.getDescripcion() + "]";
	}

}
