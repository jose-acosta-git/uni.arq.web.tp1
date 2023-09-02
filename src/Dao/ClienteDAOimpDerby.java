package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import modelo.Cliente;

public class ClienteDAOimpDerby implements ClienteDAO {
	private Connection connection;

	public ClienteDAOimpDerby(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void crear_tabla() {
		// TODO Auto-generated method stub
		
		try {
			String crear = "";	
			connection.prepareStatement(crear).execute();
			connection.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void agregar(Cliente c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarClientes() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
