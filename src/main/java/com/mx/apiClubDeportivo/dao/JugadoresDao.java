package com.mx.apiClubDeportivo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiClubDeportivo.model.Jugadores;

//JpaRepository(Contiene los metodos Crud incluso mas cosas) --- 
//Extiende/ viene  de Spring data
public interface JugadoresDao extends JpaRepository<Jugadores, Integer> {
	
	//Trabajar utilizando los resortes de los repositorios
	//findBy Atributo(debe estar igual al mapeo
	public Jugadores findByNumJugador(Integer numjuga);
	
	//Realizar la logica de nosotros
	

}
