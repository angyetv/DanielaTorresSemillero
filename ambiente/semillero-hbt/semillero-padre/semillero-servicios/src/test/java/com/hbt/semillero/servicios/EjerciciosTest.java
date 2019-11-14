package com.hbt.semillero.servicios;

import java.time.LocalDate;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class EjerciciosTest {

	@Test(enabled = false)
	public void verificarSiEsPrimo() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		int numero1 = 5;
		int numero2 = 222;
		int numero3 = 0;
		Assert.assertTrue(ejerciciosPOJO.esPrimo(numero1));// Es primo
		Assert.assertTrue(ejerciciosPOJO.esPrimo(numero2));// No es primo
		Assert.assertTrue(ejerciciosPOJO.esPrimo(numero3));// No es primo
	}

	/**
	 * Dada la fecha de naciemiento de cada persona, validar que sea igual a la
	 * fecha de hoy, se deben usar tipos de datos LocalDate, sólo verifica el año.
	 */
	@Test(enabled = false)
	public void ejercicioAnios() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		LocalDate miFechaNacimiento = LocalDate.of(1997, 12, 20);
		int miEdadEnAnios = 21;
		LocalDate fechaValidacion = ejerciciosPOJO.validarMiEdad(miFechaNacimiento, miEdadEnAnios);
		LocalDate fechaActual = LocalDate.now();
		Assert.assertEquals(fechaValidacion.getYear(), fechaActual.getYear());
	}

	/**
	 * Ordenar Numeros.
	 */
	@Test(enabled = true)
	public void ordenarNumeros() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		ejerciciosPOJO.ingresarValores(50);
		ejerciciosPOJO.ingresarValores(1);
		ejerciciosPOJO.ingresarValores(249);
		ejerciciosPOJO.ingresarValores(-2);
		ejerciciosPOJO.organizarLista();
		ArrayList<Double> listaOrdenada = ejerciciosPOJO.getListaNumeros();
		Double num1 = new Double(-2);
		Assert.assertEquals(listaOrdenada.get(0), new Double(-2));
		Assert.assertEquals(listaOrdenada.get(listaOrdenada.size() - 1), new Double(249));
		Assert.assertEquals(listaOrdenada.size(), 4);
	}
}
