package Dao;

import java.sql.Connection;

import utils.ConnectionFactory;

public class DAOFactory {

	public DAOFactory() {
	}

	// esto es para conectarte a la base de datos
	public static clienteDAO getClienteDAO(String type) {
		// aca es para diferenciar la base de datos
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new clienteDAOimpMySQL(connection);
		} // else if (type.equals("derby")) {
			// por si piden derby
			// }
		else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}

	public static productoDAO getProductoDAO(String type) {
		// aca es para diferenciar la base de datos
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new productoDAOimpMySQL(connection);
		} // else if (type.equals("derby")) {
			// por si piden derby
			// }
		else {
			throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
		}
	}

	public static facturaDAO getFacturaDAO(String type) {
		// aca es para diferenciar la base de datos
		if (type.equals("mysql")) {
			Connection connection = ConnectionFactory.getInstance().connect(ConnectionFactory.MYSQL);
			return new facturaDAOimpMySQL(connection);
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
