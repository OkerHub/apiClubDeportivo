package com.mx.apiClubDeportivo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.apiClubDeportivo.dao.JugadoresDao;
import com.mx.apiClubDeportivo.model.Jugadores;

//Agredar este o anotacion
@Service // Con esto le indicamos que vamos a realizar un servicio

public class JugadoresImp implements JugadoresServ {

	// La inyeccion de dependencia
	// @autowires me permite tener un mejor control de los objetos
	// incializan

	@Autowired
	JugadoresDao jugadorDao;

	// @Trasactional ---Para realizar los cambios de manera efectiva

	@Transactional(readOnly = true)
	@Override
	public List<Jugadores> Listar() {
		// TODO Auto-generated method stub
		List<Jugadores> registrosBd = jugadorDao.findAll();

		return registrosBd;

	}

	@Override
	public void guardar(Jugadores jugador) {
		// TODO Auto-generated method stub

		jugadorDao.save(jugador);
	}

	@Transactional(readOnly = true)
	@Override
	public Jugadores buscar(Integer id) {
		// TODO Auto-generated method stub

		Jugadores jugadorEnct = jugadorDao.findById(id).orElse(null);

		return jugadorEnct;

	}

	@Transactional
	@Override
	public void editar(Jugadores jugador) {
		// TODO Auto-generated method stub
		jugadorDao.save(jugador);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

	@Transactional(readOnly = true)
	@Override
	public Jugadores buscarXnumJugador(Integer numJugador) {
		// TODO Auto-generated method stub
		return jugadorDao.findByNumJugador(numJugador);
	}

	// Realizar esta busqueda
	@Transactional(readOnly = true)
	public List<Jugadores> buscarXNombre(String nombre) {
		// Obtener todos los registros de jugadores
		List<Jugadores> registrosBd = jugadorDao.findAll();
		List<Jugadores> jugadoresFiltrados = new ArrayList<>();

		// Ciclo para iterar sobre cada jugador en la lista
		for (Jugadores jugador : registrosBd) {
			// Condicional para filtrar jugadores cuyo nombre es exactamente igual al nombre
			// buscado
			if (jugador.getNombre().equalsIgnoreCase(nombre)) {
				jugadoresFiltrados.add(jugador);
			}
		}

		// Retornar la lista de jugadores que cumplen la condición exacta de nombre
		return jugadoresFiltrados;
	}

	

	// Peticion para buscar x cualquier atributo, realizar la logica
		@Transactional(readOnly =  true)
		public List<Jugadores> buscarXVariosAtributos(Jugadores jugador) {
			// obtener los regsitros bd
			// ciclo
			// condicion
			// lista nueva
			List<Jugadores> listaNueva = new ArrayList<Jugadores>();

			// == lo van a utilizar para comparar tipos de datos primitivos que no estan
			// parceados
			// equals lo van a utilizar para comparar cadenas y tabien tipos de datos
			// primitivos parseados

			for (Jugadores j : jugadorDao.findAll()) {

				if (j.getNumJugador().equals(jugador.getNumJugador()))
					listaNueva.add(j);
				if (j.getNombre().equals(jugador.getNombre()))
					listaNueva.add(j);
				if (j.getApp().equals(jugador.getApp()))
					listaNueva.add(j);
			}

			return listaNueva;

		}
	

}
