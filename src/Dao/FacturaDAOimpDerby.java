package Dao;

import java.sql.Connection;
import java.util.List;

import modelo.Factura;

public class FacturaDAOimpDerby implements FacturaDAO {

	private Connection connection;

	public FacturaDAOimpDerby(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void crear_tabla() {
		// TODO Auto-generated method stub

	}

	@Override
	public void agregar(Factura f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Factura> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
