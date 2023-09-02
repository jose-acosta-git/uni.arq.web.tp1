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
		// DAOFactory.getClienteDAO(ConnectionFactory.MYSQL).crear_tabla();
		// DAOFactory.getProductoDAO(ConnectionFactory.MYSQL).crear_tabla();
		// DAOFactory.getFacturaDAO(ConnectionFactory.MYSQL).crear_tabla();
		// DAOFactory.getFacturaProductoDAO(ConnectionFactory.MYSQL).crear_tabla();
		// cargaCSV();
		
		DAOFactory.getClienteDAO(ConnectionFactory.MYSQL).listarClientes();

	}

	public static void cargaCSV() {
		cargaCSVProductos();
		cargaCSVClientes();
		cargaCSVFacturas();
		cargaCSVFacturasProducto();
	}

	public static void cargaCSVProductos() {
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
			DAOFactory.getProductoDAO(ConnectionFactory.MYSQL).agregar(p);
		}
	}

	public static void cargaCSVClientes() {
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
			DAOFactory.getClienteDAO(ConnectionFactory.MYSQL).agregar(c);
		}
	}

	public static void cargaCSVFacturas() {
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
			DAOFactory.getFacturaDAO(ConnectionFactory.MYSQL).agregar(f);
		}
	}

	public static void cargaCSVFacturasProducto() {
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
			DAOFactory.getFacturaProductoDAO(ConnectionFactory.MYSQL).agregar(f);
		}
	}
}
