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
@Table(name = "Generos")
public class Generos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "Descripcion")
	private String Descripcion;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Generos() {
	}

	public Generos(int ID, String descripcion) {
		super();
		this.Id = ID;
		this.Descripcion = descripcion;
	}

	public Generos(String descripcion) {

		this.Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Genero [ID_genero=" + Id + ", descripcion=" + Descripcion + "]";
	}

}
