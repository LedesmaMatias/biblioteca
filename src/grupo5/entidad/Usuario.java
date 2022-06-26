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
@Table(name="Usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_usuario;
	
	@Column(name="user")
	private String usuario;
	
	@Column(name="password")
	private String password;
	
	public Usuario() {
		
	}
	
}
