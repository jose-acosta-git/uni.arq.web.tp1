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
		
		//CREACION DE TABLAS
		
		DAOFactory.getClienteDAO(ConnectionFactory.MYSQL).crear_tabla();
		DAOFactory.getProductoDAO(ConnectionFactory.MYSQL).crear_tabla();
		DAOFactory.getFacturaDAO(ConnectionFactory.MYSQL).crear_tabla();
		DAOFactory.getFacturaProductoDAO(ConnectionFactory.MYSQL).crear_tabla();

		DAOFactory.getClienteDAO(ConnectionFactory.DERBY).crear_tabla();
		DAOFactory.getProductoDAO(ConnectionFactory.DERBY).crear_tabla();
		DAOFactory.getFacturaDAO(ConnectionFactory.DERBY).crear_tabla();
		DAOFactory.getFacturaProductoDAO(ConnectionFactory.DERBY).crear_tabla();

		// CARGA DE DATOS
		cargaCSV(ConnectionFactory.MYSQL);
		cargaCSV(ConnectionFactory.DERBY);

		/*
		 * PUNTO 3
		 */

		/*
		 * PUNTO 4 DAOFactory.getClienteDAO(ConnectionFactory.MYSQL).listarClientes();
		 */
	}

	public static void cargaCSV(String type) {
		cargaCSVProductos(type);
		cargaCSVClientes(type);
		cargaCSVFacturas(type);
		cargaCSVFacturasProducto(type);
	}

	public static void cargaCSVProductos(String type) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/datos/productos.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			Integer id = Integer.parseInt(row.get("idProducto"));
			Float valor = Float.parseFloat(row.get("valor"));
			Producto p = new Producto(id, row.get("nombre"), valor);
			DAOFactory.getProductoDAO(type).agregar(p);
		}
	}

	public static void cargaCSVClientes(String type) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/datos/clientes.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			Integer id = Integer.parseInt(row.get("idCliente"));
			String nombre = row.get("nombre");
			String email = row.get("email");
			Cliente c = new Cliente(id, nombre, email);
			DAOFactory.getClienteDAO(type).agregar(c);
		}
	}

	public static void cargaCSVFacturas(String type) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/datos/facturas.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			Integer id = Integer.parseInt(row.get("idFactura"));
			Integer idCliente = Integer.parseInt(row.get("idCliente"));
			Factura f = new Factura(id, idCliente);
			DAOFactory.getFacturaDAO(type).agregar(f);
		}
	}

	public static void cargaCSVFacturasProducto(String type) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/datos/facturas-productos.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			Integer id = Integer.parseInt(row.get("idFactura"));
			Integer idProducto = Integer.parseInt(row.get("idProducto"));
			Integer cantidad = Integer.parseInt(row.get("cantidad"));
			FacturaProducto f = new FacturaProducto(id, idProducto, cantidad);
			DAOFactory.getFacturaProductoDAO(type).agregar(f);
		}
	}
}
