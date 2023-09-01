package Dao;

import java.util.List;

import modelo.Factura;

public interface facturaDAO {
	public void crear_tabla();

	public void eliminar();
	
	public List<Factura> listar();
}
