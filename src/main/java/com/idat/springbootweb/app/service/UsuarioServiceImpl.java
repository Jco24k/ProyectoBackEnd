package com.idat.springbootweb.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.springbootweb.app.dao.IUsuarioDao;
import com.idat.springbootweb.app.entity.Usuario;


@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	

	@Override
	@Transactional 
	public Usuario crearUsuario(Usuario usuario) {	
			return usuarioDao.save(usuario);
	}



	@Override
	@Transactional
	public Usuario buscar_x_dni(String dni) {
		return usuarioDao.findByDni(dni);
	}


	@Override
	@Transactional
	public List<Usuario> listarUsuario() {
		return (List<Usuario>) usuarioDao.findAll();
	}


	@Override
	@Transactional
	public void eliminarUsuario(Long id) {
		usuarioDao.deleteById(id);
	}



	@Override
	@Transactional
	public Usuario editarUsuario(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}


}
