package modelo;

public class Factura {
	
	private int id;
	private int idProducto;
	private int cantidad;
	public Factura(int id, int idProducto, int cantidad) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

}
