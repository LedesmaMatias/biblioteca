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
@Table(name = "Bibliotecas")
public class Bibliotecas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "FechaAlta")
	private Date FechaAlta;
	@Column(name = "Estado")
	private int Estado;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "ISBN")
	private Libros Libro;

	public Bibliotecas() {

	}
	
	public Bibliotecas(Libros libro, Date fechaAlta) {
		this.Libro = libro;
		this.FechaAlta = fechaAlta;
		this.Estado = 1;
	}

}
