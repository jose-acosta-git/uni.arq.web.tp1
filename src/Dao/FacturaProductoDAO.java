package Dao;

import java.util.List;

import modelo.FacturaProducto;

public interface FacturaProductoDAO {
	public void crear_tabla();

	public void eliminar();
	
	public List<FacturaProducto> listar();
}
