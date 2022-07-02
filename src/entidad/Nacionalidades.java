package grupo5.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Nacionalidades")
public class Nacionalidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id = 0;

	@Column(name = "Descripcion")
	private String Descripcion;

	public Nacionalidades() {
	}

	public Nacionalidades(int Id, String descripcion) {
		super();
		this.Id = Id;
		this.Descripcion = descripcion;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}

	@Override
	public String toString() {
		return "Nacionalidades [Id=" + Id + ", Descripcion=" + Descripcion + "]";
	}

}