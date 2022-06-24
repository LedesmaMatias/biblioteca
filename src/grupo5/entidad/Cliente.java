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
@Table(name="Clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_cliente;
	
	@Column(name="DNI")
	private int DNI;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="ID_nacionalidad")
	private Nacionalidad nacionalidad;
	
	@Column(name="email")
	private String email;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="fecha_nacimiento")
	private Date fecha_nacimiento;
}
