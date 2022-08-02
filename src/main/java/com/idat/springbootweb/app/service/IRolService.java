package com.idat.springbootweb.app.service;
import java.util.List;
import com.idat.springbootweb.app.entity.Rol;




public interface IRolService {
		public List<Rol> listarRol();
		//public void crearRol(Rol rol);
		public Rol editarRol(Long id);
		//public void eliminarRol(Long id);
}
