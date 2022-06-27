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
@Table(name = "Clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_cliente;

	@Column(name = "DNI")
	private int DNI;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_nacionalidad")
	private Nacionalidad nacionalidad;

	@Column(name = "email")
	private String email;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "localidad")
	private String localidad;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "fecha_nacimiento")
	private String fecha_nacimiento;

	public int getID_cliente() {
		return ID_cliente;
	}

	public void setID_cliente(int iD_cliente) {
		ID_cliente = iD_cliente;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
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

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cliente(int dNI, String nombre, String apellido, Nacionalidad nacionalidad, String email, String direccion,
			String localidad, String telefono, String fecha_nacimiento) {
		super();

		DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.email = email;
		this.direccion = direccion;
		this.localidad = localidad;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Cliente() {

	}

}
