package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

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
		Assert.assertNotEquals(invertirCadena(cadena), resultado); // Validado con una cadena que tiene un espacio de diferencia.
		cadena = " ";
		resultado = " ";
		Assert.assertEquals(invertirCadena(cadena), resultado); // Validado con dos cadenas con espacio.
		resultado = "";
		Assert.assertNotEquals(invertirCadena(cadena), resultado); //Validado con una cadena con espacio y otra vacia.
	}
}
