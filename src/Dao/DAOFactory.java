package Dao;

import java.sql.Connection;

import utils.ConnectionFactory;

public class DAOFactory {

	public DAOFactory() {
	}

	public static ClienteDAO getClienteDAO(String type) {
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new ClienteDAOimpMySQL(connection);
		} else if (type.equals("derby")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
			return new ClienteDAOimpDerby(connection);
		} else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}

	public static ProductoDAO getProductoDAO(String type) {
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new ProductoDAOimpMySQL(connection);
		} else if (type.equals("derby")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
			return new ProductoDAOimpDerby(connection);
		} else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}

	public static FacturaDAO getFacturaDAO(String type) {
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new FacturaDAOimpMySQL(connection);
		} else if (type.equals("derby")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
			return new FacturaDAOimpDerby(connection);
		} else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}

	public static FacturaProductoDAO getFacturaProductoDAO(String type) {
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new FacturaProductoDAOimpMySQL(connection);
		} else if (type.equals("derby")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.DERBY);
			return new FacturaProductoDAOimpDerby(connection);
		} else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}
	
}
