package grupo5.entidad;

public class Result {

	private int Codigo;
	private String Mensaje;

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	public Result(int codigo, String mensaje) {
		super();
		Codigo = codigo;
		Mensaje = mensaje;
	}

}
