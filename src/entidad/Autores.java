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
@Table(name = "Autores")
public class Autores implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "Nombre")
	private String Nombre;

	@Column(name = "Apellido")
	private String Apellido;

	@Column(name = "Email")
	private String Email;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "IdNacionalidad")
	private Nacionalidades Nacionalidad;

	public Autores() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Nacionalidades getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(Nacionalidades nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public Autores(int id, String nombre, String apellido, String email, grupo5.entidad.Nacionalidades nacionalidad) {
		super();
		Id = id;
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
		Nacionalidad = nacionalidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
