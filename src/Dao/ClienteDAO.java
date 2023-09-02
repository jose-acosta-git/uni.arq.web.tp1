package Dao;

import java.util.List;

import modelo.Cliente;

public interface ClienteDAO {
	public void crear_tabla();

	public void agregar(Cliente c);
	
	//punto 4
	public void listarClientes();

	public List<Cliente> listar();
}
