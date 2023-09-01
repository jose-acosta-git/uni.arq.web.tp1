package Dao;

import java.util.List;

import modelo.Producto;

public interface ProductoDAO {
	public void crear_tabla();

	public void agregar(Producto p);
	
	public List<Producto> listar();
}
