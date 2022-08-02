package com.idat.springbootweb.app.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombres;
	
	private String dni;
	
	@Column(name = "ap_paterno")
	private String app;
	
	
	@Column(name = "ap_materno")
	private String apm;
	
	
	@Column(name = "fecha_nac")
	private String fecha;
	
	@Column(name = "telefono")
	private String tel;
	
	private String foto;

	private String correo;
	
	private String username;
	
	private String password;
	
	private String estado;
	
	
	private String genero;
	@OneToOne
	@JoinColumn(name="id_rol")
	private Rol rol;
	
	
}
