package Dao;

import java.util.List;

import modelo.Cliente;

public interface clienteDAO {
	public void crear_tabla();

	public void insertar();

	public List<Cliente> listar();
}
