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
public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "DNI")
	private int DNI;

	@Column(name = "Nombre")
	private String Nombre;

	@Column(name = "Apellido")
	private String Apellido;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "IdNacionalidad")
	private Nacionalidades Nacionalidad;

	@Column(name = "Email")
	private String Email;

	@Column(name = "Direccion")
	private String Direccion;

	@Column(name = "Localidad")
	private String Localidad;

	@Column(name = "Telefono")
	private String Telefono;

	@Column(name = "FechaNacimiento")
	private String FechaNacimiento;

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	@Column(name = "Estado")
	private int Estado;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return this.Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
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

	public Nacionalidades getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(Nacionalidades nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fecha_Nacimiento) {
		FechaNacimiento = fecha_Nacimiento;
	}

	public Clientes() {

	}

	public Clientes(int Id, int DNI, String nombre, String apellido, grupo5.entidad.Nacionalidades nacionalidad,
			String email, String direccion, String localidad, String telefono, String fecha_Nacimiento) {
		super();
		this.Id = Id;
		this.DNI = DNI;
		Nombre = nombre;
		Apellido = apellido;
		Nacionalidad = nacionalidad;
		Email = email;
		Direccion = direccion;
		Localidad = localidad;
		Telefono = telefono;
		FechaNacimiento = fecha_Nacimiento;
	}

	public void CopiarDatos(Clientes c) {
		this.DNI = c.getDNI();
		this.Nombre = c.getNombre();
		this.Apellido = c.getApellido();
		this.Nacionalidad = c.getNacionalidad();
		this.Email = c.getEmail();
		this.Direccion = c.getDireccion();
		this.Localidad = c.getLocalidad();
		this.Telefono = c.getTelefono();
		this.FechaNacimiento = c.getFechaNacimiento();

	}

	@Override
	public String toString() {
		return "Clientes [Id=" + Id + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido
				+ ", Nacionalidad=" + Nacionalidad + ", Email=" + Email + ", Direccion=" + Direccion + ", Localidad="
				+ Localidad + ", Telefono=" + Telefono + ", FechaNacimiento=" + FechaNacimiento + "]";
	}

}
