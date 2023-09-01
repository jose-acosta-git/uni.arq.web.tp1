package Dao;

import java.util.List;

import modelo.Producto;

public interface productoDAO {
	public void crear_tabla();

	public void agregar(Producto p);
	
	public List<Producto> listar();
}
