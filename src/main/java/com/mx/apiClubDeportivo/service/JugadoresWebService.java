package com.mx.apiClubDeportivo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiClubDeportivo.model.Jugadores;

//@RestController ---Nps permite marcar como controlador de solicitudes y se utiliza
//para crear servicios web restfull....web service de tipo rest JSON

//@RequestMapping ---Se utiliza para asignar solicitudes web a los entornos de Spring
//RestController

//@CrossOrigin ---Es por seguridad para que nuestra aplicacion no sea bloquedo por el navegador 
//con esto nuestra api es segura o confiable

//Agregar estos 3 esteotipos
@RestController
@RequestMapping(path = "JugadoresWebService")
@CrossOrigin

public class JugadoresWebService {

	// Inyeccion de dependencia
	@Autowired
	JugadoresImp jugadorImp;

	// Peticiones(get, post, put, view...) ----para probar nuestra peticiones vamos
	// a utilizar internet
	// con el protocolo http
	// Necesitamos formar nuestro recurso o url:
	// urlServidorLocal/patchClase/PatchMetodo

	// URL http:localhost:9000/JugadoresWebService/listar
	// http://localhost:9000/JugadoresWebService/Listar
	@GetMapping(path = "listar")
	public List<Jugadores> listar() {
		return jugadorImp.Listar();
	}

	// RequestBody ---- conviete un json a objeto
	// http://localhost:9000/JugadoresWebService/guardar
	@PostMapping(path = "guardar")
	public void guardar(@RequestBody Jugadores jugador) {
		jugadorImp.guardar(jugador);
	}

	// URL: http://localhost:9000/JugadoresWebService/buscar
	@PostMapping(path = "buscar")
	public Jugadores buscar(@RequestBody Jugadores jugador) {
		return jugadorImp.buscar(jugador.getIdJugador());

	}

	// http://localhost:9000/JugadoresWebService/editar
	@PostMapping(path = "editar")
	public void editar(@RequestBody Jugadores jugador) {
		jugadorImp.editar(jugador);
	}

	// http://localhost:9000/JugadoresWebService/eliminar
	@PostMapping(path = "eliminar")
	public void eliminar(@RequestBody Jugadores jugador) {
		jugadorImp.eliminar(jugador.getIdJugador());
	}

	// http://localhost:9000/JugadoresWebService/buscarXJugador
	@PostMapping(path = "buscarXJugador")
	public Jugadores buscarxJugadores(@RequestBody Jugadores jugador) {
		return jugadorImp.buscarXnumJugador(jugador.getNumJugador());
	}

	// http://localhost:9000/JugadoresWebService/buscarXNombre
	@PostMapping(path = "buscarXNombre")
	public List<Jugadores> buscarxNombre(@RequestBody Jugadores jugador) {
		return jugadorImp.buscarXNombre(jugador.getNombre());
	}

	//URL:  http://localhost:9000/JugadoresWebService/buscarXAtributo
		@PostMapping(path = "buscarXAtributo")
		public List<Jugadores> buscarXAtributo(@RequestBody Jugadores jugador){
			return jugadorImp.buscarXVariosAtributos(jugador);
		}
}
