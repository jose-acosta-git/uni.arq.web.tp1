package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modelo.FacturaProducto;
import utils.ConnectionFactory;

public class FacturaProductoDAOimpDerby implements FacturaProductoDAO {
	private Connection connection;

	public FacturaProductoDAOimpDerby(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void crear_tabla() {
		try {
			Statement stmt = this.connection.createStatement();
			String createFacturaProducto = "CREATE TABLE Factura_Producto (idFactura INT, idProducto INT, cantidad INT, FOREIGN KEY (idFactura) REFERENCES Factura (idFactura), FOREIGN KEY (idProducto) REFERENCES Producto (idProducto) )";
			stmt.executeUpdate(createFacturaProducto);
			ConnectionFactory.getInstance().disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void agregar(FacturaProducto f) {
		try {
			// secuencia de crear la tabla
			String sql = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, f.getIdFactura());
			ps.setInt(2, f.getIdProducto());
			ps.setFloat(3, f.getCantidad());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FacturaProducto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void productoMasVendido() {
		// TODO Auto-generated method stub
		try {
			Statement stmt = this.connection.createStatement();
			// secuencia de crear la tabla
			String sql = "SELECT fp.idProducto, p.nombre, SUM(fp.cantidad * p.valor) AS recaudacion FROM factura_producto fp INNER JOIN producto p ON fp.idProducto = p.idProducto GROUP BY fp.idProducto, p.nombre ORDER BY recaudacion DESC FETCH FIRST ROW ONLY";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int idProducto = resultSet.getInt("idProducto");
				String nombreProducto = resultSet.getString("nombre");
				float recaudacion = resultSet.getFloat("recaudacion");

				System.out.println("el producto mas vendido fue:" + nombreProducto + " con el id:" + idProducto
						+ " y recaudo " + recaudacion + "$");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
