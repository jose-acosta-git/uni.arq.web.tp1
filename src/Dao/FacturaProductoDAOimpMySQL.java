package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modelo.FacturaProducto;
import utils.ConnectionFactory;

public class FacturaProductoDAOimpMySQL implements FacturaProductoDAO {
	private Connection connection;

	public FacturaProductoDAOimpMySQL(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void crear_tabla() {
		try {
			Statement stmt = this.connection.createStatement();
			String createFacturaProducto = "CREATE TABLE Factura_Producto (idFactura INT, idProducto INT, cantidad INT, FOREIGN KEY (idFactura) REFERENCES Factura (idFactura), FOREIGN KEY (idProducto) REFERENCES Producto (idProducto) )";
			stmt.executeUpdate(createFacturaProducto);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
