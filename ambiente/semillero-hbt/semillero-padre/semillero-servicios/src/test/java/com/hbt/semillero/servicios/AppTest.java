package com.hbt.semillero.servicios;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.EstadoEnum;

public class AppTest {

	@Test(enabled = false)
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}

	/**
	 * Método que inverte una cadena string.
	 * 
	 * @param cadena
	 * @return
	 */
	private static String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}

	/**
	 * Método que hace test sobre el metodo invertir cadena.
	 */
	@Test(enabled = false)
	public void probarInvertirCadena() {
		String cadena = "El hijo de rana, Rinrín renacuajo salió esta mañana muy tieso, muy majo.";
		String resultado = ".ojam yum ,oseit yum anañam atse óilas ojaucaner nírniR ,anar ed ojih lE";
		Assert.assertEquals(invertirCadena(cadena), resultado); // Validado con una cadena larga que tiene espacios.
		resultado = ".ojam yum,oseit yum anañam atse óilas ojaucaner nírniR ,anar ed ojih lE";
		Assert.assertNotEquals(invertirCadena(cadena), resultado); // Validado con una cadena que tiene un espacio de
																	// diferencia.
		cadena = " ";
		resultado = " ";
		Assert.assertEquals(invertirCadena(cadena), resultado); // Validado con dos cadenas con espacio.
		resultado = "";
		Assert.assertNotEquals(invertirCadena(cadena), resultado); // Validado con una cadena con espacio y otra vacia.
	}

	/**
	 * 
	 * Metodo encargado de realizar las pruebas concernientes al enumerado
	 * EstadoEnum <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 *
	 */
	@Test(enabled = false)
	public void pruebaEstadoEnum() {
		EstadoEnum estadoActivo = EstadoEnum.ACTIVO;// Instanciar un enum de la clase EstadoEnum (estado activo)
		EstadoEnum estadoInactivo = EstadoEnum.INACTIVO;// Otra instancia del estado inactivo (para fines de pruebas)
		String estadoActivoNombre = estadoActivo.name(); // nombre del estado activo
		String estadoInactivoNombre = estadoInactivo.name();// nombr del estado inactivo
		Assert.assertNotEquals(estadoActivoNombre, estadoInactivoNombre);
		int posEstadoActivo = estadoActivo.ordinal();// posicion del estado activo
		int posEstadoInactivo = estadoInactivo.ordinal();// posicion de estado inactivo
		int posicionEsperadaEstodoActivo = 0;// posicion esperada del estado activo
		int posicionEsperadaEstodoInactivo = 1;// posicion esperada del estado inactivo
		// Prueba en la que se comprueba que sean iguales las posiciones actuales y
		// esperada del estado activo
		Assert.assertEquals(posEstadoActivo, posicionEsperadaEstodoActivo);
		// Prueba en la que se comprueba que sean iguales las posiciones actuales y
		// esperada del estado inactivo
		Assert.assertEquals(posEstadoInactivo, posicionEsperadaEstodoInactivo);
		// Array que contiene todos los enum
		EstadoEnum[] estados = EstadoEnum.values();
		Arrays.asList(estados).forEach(System.out::println);
	}

	// TODO
	/**
	 * Pediente hacer un método que use el método ToString de la entidad COMIC
	 */
}