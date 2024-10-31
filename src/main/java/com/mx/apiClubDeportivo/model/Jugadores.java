package com.mx.apiClubDeportivo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jugadores_club")

public class Jugadores {

	/*
	 * CREATE TABLE JUGADORES_CLUB( ID NUMBER PRIMARY KEY, NUM_JUGADOR NUMBER NOT
	 * NULL, NOMBRE VARCHAR2(80) NOT NULL, APP VARCHAR2(80) NOT NULL, APM
	 * VARCHAR2(80) NOT NULL, FECHA_NACIMIENTO DATE NOT NULL );
	 */

//Estereotipos o anotaciones

	@Id // Representa la llave primaria key
	@Column(name = "ID", columnDefinition = "NUMBER", nullable = false)
	private Integer idJugador; // Los tipos de datos primitivos de preferencia ponerlos
	// parseados ---- especialmente cuando acepten valores nulos
	@Column(name = "NUM_JUGADOR", columnDefinition = "NUMBER", nullable = false)
	private Integer numJugador;
	@Column(name = "NOMBRE", columnDefinition = "VARCHAR2(80)", nullable = false)
	private String nombre;
	@Column(name = "APP", columnDefinition = "VARCHAR2(80)", nullable = false)
	private String app;
	@Column(name = "APM", columnDefinition = "VARCHAR2(80)", nullable = true)
	private String apm;
	@Column(name = "FECHA_NACIMIENTO", columnDefinition = "DATE", nullable = false)
	private Date fechaNacimiento;

	// Contructor vacio
	public Jugadores() {
		super();
	}

	// Contructor Lleno
	public Jugadores(Integer idJugador, Integer numJugador, String nombre, String app, String apm,
			Date fechaNacimiento) {
		super();
		this.idJugador = idJugador;
		this.numJugador = numJugador;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.fechaNacimiento = fechaNacimiento;
	}

	// Encapsulamiento
	@Override
	public String toString() {
		return "Jugadores [idJugador=" + idJugador + ", numJugador=" + numJugador + ", nombre=" + nombre + ", app="
				+ app + ", apm=" + apm + ", fechaNacimiento=" + fechaNacimiento + "]\n";

	}

	// MEtodo toString

	public Integer getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	public Integer getNumJugador() {
		return numJugador;
	}

	public void setNumJugador(Integer numJugador) {
		this.numJugador = numJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
