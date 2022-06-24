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
@Table(name="Generos")
public class Genero implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_genero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_genero;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public Genero() {}
	
	public Genero(int ID, String descripcion) {
		super();
		this.ID_genero = ID;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Genero [ID_genero=" + ID_genero + ", descripcion=" + descripcion + "]";
	}
	
	
}
