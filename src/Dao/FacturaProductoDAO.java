package Dao;

import modelo.FacturaProducto;

public interface FacturaProductoDAO {
	public void crear_tabla();

	public void agregar(FacturaProducto f);

	//3) Producto que mas recaudó
	public void productoMayorRecaudacion();
}
