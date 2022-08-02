package com.idat.springbootweb.app.controller;
import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.idat.springbootweb.app.entity.Rol;
import com.idat.springbootweb.app.entity.Usuario;
import com.idat.springbootweb.app.service.IRolService;
import com.idat.springbootweb.app.service.IUsuarioService;

import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
@CrossOrigin(origins = {"http://localhost:4200"})
@Slf4j
@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	private IRolService rolDao;
	@Autowired
	private IUsuarioService usuarioDao;
	@GetMapping("/usuarios")
	public List<Usuario> index(){
		return usuarioDao.listarUsuario();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario buscar(@PathVariable Long id){
		log.info("IDENTIFICACION: "+id);
		return usuarioDao.editarUsuario(id);
	}
	@GetMapping("/usuarios/dni/{dni}")
	public Usuario buscar_dni(@PathVariable String dni){
		log.info("DNI: "+dni);
		return usuarioDao.buscar_x_dni(dni);
	}
	
	@PostMapping("/usuarios")
	public Usuario create(@RequestBody Usuario usuario  ){
		return usuarioDao.crearUsuario(usuario);
	}
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PutMapping("/usuarios/{id}")
	public Usuario actualizar(@RequestBody Usuario usuario,@PathVariable Long id){
		Usuario encontradoUsuario = usuarioDao.editarUsuario(id);
		encontradoUsuario.setApm(usuario.getApm());
		encontradoUsuario.setApp(usuario.getApp());
		encontradoUsuario.setNombres(usuario.getNombres());
		encontradoUsuario.setCorreo(usuario.getCorreo());
		encontradoUsuario.setFoto(usuario.getFoto());
		encontradoUsuario.setDni(usuario.getDni());
		encontradoUsuario.setFecha(usuario.getFecha());
		encontradoUsuario.setUsername(usuario.getUsername());
		encontradoUsuario.setPassword(usuario.getPassword());
		encontradoUsuario.setTel(usuario.getTel());
		encontradoUsuario.setRol(usuario.getRol());
		encontradoUsuario.setGenero(usuario.getGenero());
		encontradoUsuario.setEstado(usuario.getEstado());
		return usuarioDao.crearUsuario(encontradoUsuario);
	}
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@DeleteMapping("/usuarios/{id}")
	public void eliminar(@PathVariable Long id){
		Usuario usuario_encontrado = usuarioDao.editarUsuario(id);
		usuario_encontrado.setEstado("INACTIVO");
		usuarioDao.crearUsuario(usuario_encontrado);
	}
	
	@GetMapping("/roles")
	public List<Rol> listar_rol(){
		return rolDao.listarRol();
	}
	@GetMapping("/roles/{id}")
	public Rol buscar_rol(@PathVariable Long id){
		return rolDao.editarRol(id);
	}
	
	/*
	@GetMapping("/formulario/usuario")
	public String registrar_usuario(Model model) {
		model.addAttribute("titulo", "Registrar Usuario");
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("roles", rolDao.listarRol());
		return "usuario/formulario";
	}
	
	
	@PostMapping("/formulario/usuario")
	public String guardar_usuario(Model model,@Valid Usuario usuario,Errors errores,
			@RequestParam String rol,
			 @RequestParam("file") MultipartFile foto,BindingResult result) throws IOException {
		
		model.addAttribute("titulo", "Registrar Usuario");
		model.addAttribute("roles", rolDao.listarRol());
		if(usuarioDao.buscar_x_dni(usuario.getDni()) == null) {
			if(errores.hasErrors()) {
				model.addAttribute("titulo", "Registrar Usuario");
				return "usuario/formulario";
			}
			if(result.hasErrors()) {
				model.addAttribute("usuario",usuario);
				model.addAttribute("titulo", "Error Usuario");
				return "usuario/formulario";
			}
			if(!foto.isEmpty()) {

				if(foto.getContentType().toString().equalsIgnoreCase("image/png")|| 
						foto.getContentType().toString().equalsIgnoreCase("image/jpg") ||
						foto.getContentType().toString().equalsIgnoreCase("image/jpeg")) {
					Path directorioRecursos = Paths.get("src//main//resources//static/uploads");	
					String rootPath = directorioRecursos.toFile().getAbsolutePath();
					Path p = Paths.get(rootPath);
					Files.createDirectories(p.getParent());
					log.info(foto.getContentType());
					try {
						byte[] bytes = foto.getBytes();
						Path rutaCompleta=Paths.get(rootPath+"//"+foto.getOriginalFilename());
						Files.createDirectories(rutaCompleta.getParent());
						Files.write(rutaCompleta,bytes);
						usuario.setFoto(foto.getOriginalFilename());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					model.addAttribute("tipo_foto","La foto tiene que ser extension (png, jpg, jpeg)");
					return "usuario/formulario";
				}
			}
			var rol_encontrado = rolDao.editarRol(Long.valueOf(rol));
			usuario.setRol(rol_encontrado);
			if(usuarioDao.crearUsuario(usuario) == 1) {
				model.addAttribute("mensaje", "(Usuario Registro Correctamente)");
			}else {
				model.addAttribute("mensaje", "(Error al registrar)");
			}
			
			model.addAttribute("usuario",new Usuario());
			return "usuario/formulario";
		}
			
		else {
			model.addAttribute("dni_existente","DNI EXISTENTE, DIGITE OTRO DNI");
			model.addAttribute("usuario", usuario);
			return "usuario/formulario";
		}
		
	}
	
	
	*/
	
}
