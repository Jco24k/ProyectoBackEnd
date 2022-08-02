package com.idat.springbootweb.app.service;
import java.util.List;

import com.idat.springbootweb.app.entity.Cliente;




public interface IClienteService {
		public List<Cliente> listarCliente();
		public Cliente  crearCliente(Cliente  cliente);
		public Cliente  editarCliente(Long id);
		public Cliente buscar_x_dni(String dni);
		public void eliminarCliente (Long id);
}
