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
@Table(name="Nacionalidades")
public class Nacionalidad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_nacionalidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public Nacionalidad() {}
	
	public Nacionalidad(int ID, String descripcion) {
		this.ID = ID;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Nacionalidad [ID=" + ID + ", descripcion=" + descripcion + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}