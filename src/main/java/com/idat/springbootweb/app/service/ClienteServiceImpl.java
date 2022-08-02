package com.idat.springbootweb.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.springbootweb.app.dao.IClienteDao;
import com.idat.springbootweb.app.entity.Cliente;


@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	

	@Override
	@Transactional 
	public Cliente crearCliente(Cliente cliente) {	
			return clienteDao.save(cliente);
	}



	@Override
	@Transactional
	public Cliente  buscar_x_dni(String dni) {
		return clienteDao.findByDni(dni);
	}


	@Override
	@Transactional
	public List<Cliente> listarCliente() {
		return (List<Cliente>) clienteDao.findAll();
	}


	@Override
	@Transactional
	public void eliminarCliente(Long id) {
		clienteDao.deleteById(id);
	}



	@Override
	@Transactional
	public Cliente  editarCliente(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}


}
