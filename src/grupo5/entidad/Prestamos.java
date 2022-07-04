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
@Table(name = "Prestamos")
public class Prestamos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@Column(name = "FechaPrestamo")
	private Date FechaPrestamo;

	@Column(name = "CantDias")
	private int CantDias;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "IdCliente")
	private Clientes Cliente;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "IdBiblioteca")
	private Bibliotecas Biblioteca;

	public Prestamos() {

	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getFechaPrestamo() {
		return FechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		FechaPrestamo = fechaPrestamo;
	}

	public int getCantDias() {
		return CantDias;
	}

	public void setCantDias(int cantDias) {
		CantDias = cantDias;
	}

	public Clientes getCliente() {
		return Cliente;
	}

	public void setCliente(Clientes cliente) {
		Cliente = cliente;
	}

	public Bibliotecas getBiblioteca() {
		return Biblioteca;
	}

	public void setBiblioteca(Bibliotecas biblioteca) {
		Biblioteca = biblioteca;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
