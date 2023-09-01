package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modelo.Producto;
import utils.ConnectionFactory;

public class productoDAOimpMySQL implements productoDAO {
	private Connection connection;

	public productoDAOimpMySQL(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void crear_tabla() {
		try {
			Statement stmt = this.connection.createStatement();
			// secuencia de crear la tabla
			String sql = "CREATE TABLE producto (id INT, nombre VARCHAR(45), valor FLOAT, PRIMARY KEY(id))";
			stmt.executeUpdate(sql);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregar(Producto p) {
		try {
			// secuencia de crear la tabla
			String sql = "INSERT INTO producto (id, nombre, valor) VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setFloat(3, p.getValor());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
