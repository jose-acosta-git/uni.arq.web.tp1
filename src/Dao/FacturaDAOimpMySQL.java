package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modelo.Factura;
import utils.ConnectionFactory;

public class FacturaDAOimpMySQL implements FacturaDAO {
	private Connection connection;

	public FacturaDAOimpMySQL(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void crear_tabla() {
		try {
			Statement stmt = this.connection.createStatement();
			// secuencia de crear la tabla
			String createFactura = "CREATE TABLE Factura (idFactura INT, idCliente INT, PRIMARY KEY (idFactura), FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente))";
			stmt.executeUpdate(createFactura);
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

	@Override
	public void agregar(Factura f) {
		try {
			Statement stmt = this.connection.createStatement();
			// secuencia de crear la tabla
			String createFactura = "INSERT INTO factura(idFactura,idCliente) VALUES(?,?)";
			PreparedStatement ps = connection.prepareStatement(createFactura);

			ps.setInt(1, f.getIdFactura());
			ps.setInt(2, f.getIdCliente());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
