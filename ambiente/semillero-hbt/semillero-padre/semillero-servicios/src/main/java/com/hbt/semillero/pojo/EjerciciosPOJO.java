package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import sun.util.resources.LocaleData;

public class EjerciciosPOJO {

	private ArrayList<Double> listaNumeros;

	public EjerciciosPOJO() {
		this.listaNumeros = new ArrayList<Double>();
	}

	/**
	 * Valida si un numero es primo.
	 * 
	 * @param numero
	 * @return
	 */
	public boolean esPrimo(int numero) {
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != numero)) {
			if (numero % contador == 0)
				primo = false;
			contador++;
		}
		return primo;
	}

	/**
	 * Dada la fecha de naciemiento de cada persona, validar que sea igual a la
	 * fecha de hoy, se deben usar tipos de datos LocalDate, sólo verifica el año.
	 * 
	 * @return
	 */
	public LocalDate validarMiEdad(LocalDate fechaNacimiento, int anios) {
		return fechaNacimiento.plusYears(anios);
	}

	/**
	 * Agregar nuevo numero.
	 * 
	 * @param number
	 */
	public void ingresarValores(double number) {
		this.listaNumeros.add(number);
	}

	/**
	 * Organiza los numeros de menor a mayor.
	 */
	public void organizarLista() {
		Collections.sort(listaNumeros);
	}

	/**
	 * Obtener lista de Numeros
	 * 
	 * @return
	 */
	public ArrayList<Double> getListaNumeros() {
		return listaNumeros;
	}
}
