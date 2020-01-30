package com.restFullWebService.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController {

	/*
	 * Creamos dos variables
	 * "template" de timpo String y "counter" de tipo AtomicLong que nos permite incremetnar, reducir, actualizar y añadir un valor
	 */
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/*
	 * Creamos un metodo que devuelve un objeto d etipo "Greeting"
	 * A este metodo le pasamos un String el cual lo iniciamos con un valor por defecto
	 * En este caso lo iniciamos con el valor "world"
	 * Y por ultimo regresa el objeto "Greeting" al cual se le pasa "counter" que se incrementara en uno por cada llamada que se haga al metodo y un String formateado
	 * con el valor que se le pasa (world) y el String antes creado "template"
	 */
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
