package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modelo.Factura;
import utils.ConnectionFactory;

public class facturaDAOimpMySQL implements facturaDAO {
	private Connection connection;

	public facturaDAOimpMySQL(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void crear_tabla() {
		try {
			Statement stmt = this.connection.createStatement();
			// secuencia de crear la tabla
			String createFactura = "CREATE TABLE factura (id INT, idCliente INT, PRIMARY KEY (id), FOREIGN KEY (idCliente) REFERENCES cliente (id))";
			stmt.executeUpdate(createFactura);
			
			String createFacturaProducto = "CREATE TABLE factura_producto (idFactura INT, idProducto INT, cantidad INT, FOREIGN KEY (idFactura) REFERENCES factura (id), FOREIGN KEY (idProducto) REFERENCES producto (id) )";
			stmt.executeUpdate(createFacturaProducto);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
