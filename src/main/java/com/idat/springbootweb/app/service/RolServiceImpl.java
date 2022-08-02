package com.idat.springbootweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.idat.springbootweb.app.dao.IRolDao;
import com.idat.springbootweb.app.entity.Rol;


@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolDao rolDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Rol> listarRol() {
		return (List<Rol>) rolDao.findAll();
	}
	
	@Override
	@Transactional
	public Rol editarRol(Long id) {		
		return rolDao.findById(id).orElse(null);
	}



}
