package com.hbt.semillero.servicios;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.EstadoEnum;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	@Test
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}

	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}

	/**
	 * Método para validar el funcionamiento de invertir cadena.
	 */
	@Test
	public void probarInvierteCadena() {
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
	 * Test del Tercer Ejercicio.
	 */
	@Test
	public void tercerEjercicio() {
		// Instanciar un enum de la clase EstadoEnum
		EstadoEnum estadoEnum = EstadoEnum.ACTIVO;

		// Devolver un String con el nombre de la constante Activo
		String estadoAsString = estadoEnum.name();
		System.out.println(estadoAsString);

		// Devolver un entero con la posición del enum según está declarada
		int posEstado = estadoEnum.ordinal();

		// Comparar el enum con el parámetro según está declarado el enum
		int expectedPos = 0;

		// Assert para la posición de ACTIVO
		Assert.assertEquals(posEstado, expectedPos);

		// Assert para la posición de ACTIVO
		estadoEnum = EstadoEnum.INACTIVO;
		posEstado = estadoEnum.ordinal();
		expectedPos = 1;

		Assert.assertEquals(posEstado, expectedPos);
		// Devolver un array que contiene todos los enum
		EstadoEnum[] estados = EstadoEnum.values();

		Arrays.asList(estados).forEach(System.out::println);

	}

	// TODO
	/**
	 * Pediente hacer un método que use el método ToString de la entidad COMIC
	 */

}
