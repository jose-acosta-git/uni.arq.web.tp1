package modelo;

import java.util.HashSet;

public class Cliente {
	
	private Integer id;
	private String nombre;
	private String email;
	private HashSet<Factura> facturas;
	
	public Cliente(Integer id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.facturas = new HashSet<Factura>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public void removeFactura(Factura f) {
		facturas.remove(f);
	}
	
	public void addFactura (Factura f) {
		facturas.add(f);
	}

}
