package com.hbt.semillero.pojo;

public class Maraton {

	private String brand;
	private boolean empty;

	public static boolean esPrimo(int numero) {
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != numero)) {
			if (numero % contador == 0)
				primo = false;
			contador++;
		}
		return primo;
	}

	public static void main(String[] args) {
		System.out.println(Maraton.esPrimo(5));
		System.out.println(Maraton.esPrimo(222));
		System.out.println(Maraton.esPrimo(0));

	}
}
