package modelo;

public class Cliente {
	
	private Integer idCliente;
	private String nombre;
	private String email;
	
	public Cliente(Integer id, String nombre, String email) {
		this.idCliente = id;
		this.nombre = nombre;
		this.email = email;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer id) {
		this.idCliente = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
