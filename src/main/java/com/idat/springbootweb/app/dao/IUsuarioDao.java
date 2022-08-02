package com.idat.springbootweb.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.idat.springbootweb.app.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario,Long> {
	public Usuario findByDni(String dni);
}
