package Dao;

import java.util.List;

import modelo.Factura;

public interface FacturaDAO {
	public void crear_tabla();
	
	public void agregar(Factura f);

	public void eliminar();
	
	public List<Factura> listar();
}
