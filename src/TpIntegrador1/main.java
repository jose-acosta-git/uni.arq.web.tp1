package TpIntegrador1;

import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Dao.DAOFactory;
import modelo.Cliente;
import modelo.Factura;
import modelo.Producto;
import utils.ConnectionFactory;

public class main {

	public static void main(String[] args) {
		// DAOFactory.getClienteDAO(ConnectionFactory.MYSQL).crear_tabla();
		// DAOFactory.getProductoDAO(ConnectionFactory.MYSQL).crear_tabla();
		// DAOFactory.getFacturaDAO(ConnectionFactory.MYSQL).crear_tabla();
		//DAOFactory.getFacturaProductoDAO(ConnectionFactory.MYSQL).crear_tabla();
		cargaCSVProductos();
		cargaCSVClientes();
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
		//terminar
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/datos/facturas.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CSVRecord row : parser) {
			Integer id = Integer.parseInt(row.get("id"));
			Integer idCliente = Integer.parseInt(row.get("idCliente"));
			//Factura f = new Factura(id,idCliente);
			//DAOFactory.getClienteDAO(ConnectionFactory.MYSQL).agregarF(f);
		}
	}
}
