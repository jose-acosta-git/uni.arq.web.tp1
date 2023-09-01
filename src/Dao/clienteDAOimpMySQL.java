package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modelo.Cliente;
import utils.ConnectionFactory;

public class clienteDAOimpMySQL implements clienteDAO {
	private Connection connection;
	
	public clienteDAOimpMySQL(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void crear_tabla() {
		try {
			Statement stmt = this.connection.createStatement();
			//secuencia de crear la tabla
			String sql = "CREATE TABLE cliente(id INT, nombre VARCHAR(500), email VARCHAR(150), PRIMARY KEY(id))";
			stmt.executeUpdate(sql);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertar() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
