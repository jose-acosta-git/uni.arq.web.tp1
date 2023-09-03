package TpIntegrador1;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Dao.DAOFactory;
import modelo.Cliente;
import modelo.Factura;
import modelo.FacturaProducto;
import modelo.Producto;
import utils.ConnectionFactory;

public class main {

	public static void main(String[] args) {
		
		// Obtencion de tipos de DB
		
		String mysqlDb = ConnectionFactory.MYSQL;
		String derbyDb = ConnectionFactory.DERBY;
		
		// Creacion de tablas
		
		DAOFactory.getClienteDAO(mysqlDb).crear_tabla();
		DAOFactory.getProductoDAO(mysqlDb).crear_tabla();
		DAOFactory.getFacturaDAO(mysqlDb).crear_tabla();
		DAOFactory.getFacturaProductoDAO(mysqlDb).crear_tabla();

		DAOFactory.getClienteDAO(derbyDb).crear_tabla();
		DAOFactory.getProductoDAO(derbyDb).crear_tabla();
		DAOFactory.getFacturaDAO(derbyDb).crear_tabla();
		DAOFactory.getFacturaProductoDAO(derbyDb).crear_tabla();

		// Carga de datos
		cargaCSV(mysqlDb);
		cargaCSV(derbyDb);

		//3) Producto que mas recaudó
		DAOFactory.getFacturaProductoDAO(mysqlDb).productoMayorRecaudacion();
		DAOFactory.getFacturaProductoDAO(derbyDb).productoMayorRecaudacion();

		//4) Clientes ordenados por facturación
		System.out.println("Clientes con mayor factuacion: implementación MySQL");
		DAOFactory.getClienteDAO(mysqlDb).listarClientes();
		
		System.out.println("Clientes con mayor factuacion: implementación Derby");
		DAOFactory.getClienteDAO(derbyDb).listarClientes();
		
	}

	public static void cargaCSV(String dbType) {
		cargaCSVProductos(dbType);
		cargaCSVClientes(dbType);
		cargaCSVFacturas(dbType);
		cargaCSVFacturasProducto(dbType);
	}

	public static void cargaCSVProductos(String dbType) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/datos/productos.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			Integer id = Integer.parseInt(row.get("idProducto"));
			Float valor = Float.parseFloat(row.get("valor"));
			Producto p = new Producto(id, row.get("nombre"), valor);
			DAOFactory.getProductoDAO(dbType).agregar(p);
		}
	}

	public static void cargaCSVClientes(String dbType) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/datos/clientes.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			Integer id = Integer.parseInt(row.get("idCliente"));
			String nombre = row.get("nombre");
			String email = row.get("email");
			Cliente c = new Cliente(id, nombre, email);
			DAOFactory.getClienteDAO(dbType).agregar(c);
		}
	}

	public static void cargaCSVFacturas(String dbType) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/datos/facturas.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			Integer id = Integer.parseInt(row.get("idFactura"));
			Integer idCliente = Integer.parseInt(row.get("idCliente"));
			Factura f = new Factura(id, idCliente);
			DAOFactory.getFacturaDAO(dbType).agregar(f);
		}
	}

	public static void cargaCSVFacturasProducto(String dbType) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/datos/facturas-productos.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			Integer id = Integer.parseInt(row.get("idFactura"));
			Integer idProducto = Integer.parseInt(row.get("idProducto"));
			Integer cantidad = Integer.parseInt(row.get("cantidad"));
			FacturaProducto f = new FacturaProducto(id, idProducto, cantidad);
			DAOFactory.getFacturaProductoDAO(dbType).agregar(f);
		}
	}
}
