package Dao;

import modelo.Cliente;

public interface ClienteDAO {
	public void crear_tabla();

	public void agregar(Cliente c);
	
	//4) Clientes ordenados por facturación
	public void listarClientes();
}
