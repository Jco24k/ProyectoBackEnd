package com.idat.springbootweb.app.service;
import java.util.List;

import com.idat.springbootweb.app.entity.Usuario;




public interface IUsuarioService {
		public List<Usuario> listarUsuario();
		public Usuario crearUsuario(Usuario Usuario);
		public Usuario editarUsuario(Long id);
		public Usuario buscar_x_dni(String dni);
		public void eliminarUsuario(Long id);
}
