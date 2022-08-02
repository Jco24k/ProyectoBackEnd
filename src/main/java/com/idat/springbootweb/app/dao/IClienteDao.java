package com.idat.springbootweb.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.idat.springbootweb.app.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long> {
	public Cliente findByDni(String dni);
}
