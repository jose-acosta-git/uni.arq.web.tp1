package Dao;

import java.sql.Connection;
import java.util.List;

import modelo.FacturaProducto;

public class FacturaProductoDAOimpDerby implements FacturaProductoDAO{
	private Connection connection;

	public FacturaProductoDAOimpDerby(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregar(FacturaProducto f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FacturaProducto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
