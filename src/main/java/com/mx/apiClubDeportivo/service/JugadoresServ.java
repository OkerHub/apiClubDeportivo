package com.mx.apiClubDeportivo.service;

import java.util.List;

import com.mx.apiClubDeportivo.model.Jugadores;

public interface JugadoresServ {
	public List<Jugadores> Listar();

	public void guardar(Jugadores jugador);

	public Jugadores buscar(Integer id);

	public void editar(Jugadores jugador);

	public void eliminar(Integer id);
	
	public Jugadores buscarXnumJugador(Integer numJugador);

}
