package Dao;

import java.sql.Connection;
import java.util.List;

import modelo.Producto;

public class ProductoDAOimpDerby implements ProductoDAO {
	private Connection connection;

	public ProductoDAOimpDerby(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void crear_tabla() {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregar(Producto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
