package Dao;

import java.sql.Connection;

import utils.ConnectionFactory;

public class DAOFactory {

	public DAOFactory() {
	}

	// esto es para conectarte a la base de datos
	public static ClienteDAO getClienteDAO(String type) {
		// aca es para diferenciar la base de datos
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new ClienteDAOimpMySQL(connection);
		} // else if (type.equals("derby")) {
			// por si piden derby
			// }
		else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}

	public static ProductoDAO getProductoDAO(String type) {
		// aca es para diferenciar la base de datos
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new ProductoDAOimpMySQL(connection);
		} // else if (type.equals("derby")) {
			// por si piden derby
			// }
		else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}

	public static FacturaDAO getFacturaDAO(String type) {
		// aca es para diferenciar la base de datos
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new FacturaDAOimpMySQL(connection);
		} // else if (type.equals("derby")) {
			// por si piden derby
			// }
		else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}
	
	public static FacturaProductoDAO getFacturaProductoDAO(String type) {
		// aca es para diferenciar la base de datos
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new FacturaProductoDAOimpMySQL(connection);
		} // else if (type.equals("derby")) {
			// por si piden derby
			// }
		else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}

// si hay mas tablas hacer un copipaste siguiendo la logica esta
// otros métodos para obtener instancias de DAOs
}
