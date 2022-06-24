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
@Table(name="Prestamos")
public class Prestamo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_prestamo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_prestamo;
	
	@Column(name="fecha_prestamo")
	private Date fecha_prestamo;
	
	@Column(name="cantidad_dias")
	private int cantidad_dias;
	
	@ManyToOne(cascade= {CascadeType.REFRESH})
	@JoinColumn(name="ID_cliente")
	private Cliente cliente;
	
	@ManyToOne(cascade= {CascadeType.REFRESH})
	@JoinColumn(name="ID_biblioteca")
	private Biblioteca biblioteca;
	
	public Prestamo() {
		
	}
}
