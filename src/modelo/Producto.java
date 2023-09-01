package modelo;

public class Producto {

	private Integer id;
	private String nombre;
	private float valor;
	
	public Producto(Integer id, String nombre, float valor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
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
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
