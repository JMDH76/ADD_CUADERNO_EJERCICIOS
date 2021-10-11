package es.florida.cuaderno01;

import java.util.Scanner;

public class Ejercicio28 {

	public static void main(String[] args) {

		System.out.println(
				"28. Crea un programa que permita generar 5 objetos de clase “Vehículo”. Cada vehículo tendrá \r\n"
						+ "tres atributos: tipo (coche, motocicleta,…), marca y modelo. Una vez creados, el programa \r\n"
						+ "los mostrará por pantalla.");
		Scanner teclado = new Scanner(System.in);

		String tipo, marca, modelo;

		Vehiculo[] arrayVehiculos = new Vehiculo[5];

		for (int i = 0; i < 5; i++) {
			System.out.println("\nIndica las características del vehículo " + (i + 1));

			System.out.print(" TIPO de vehiculo: ");
			tipo = teclado.nextLine();
			System.out.print(" MARCA del vehículo: ");
			marca = teclado.nextLine();
			System.out.print(" MODELO del vehículo: ");
			modelo = teclado.nextLine();

			Vehiculo nuevoVehiculo = new Vehiculo(tipo, marca, modelo);
			arrayVehiculos[i] = nuevoVehiculo;
		}

		System.out.print("\nLista de vehículos:\n-------------------");
		for (Vehiculo vehiculo : arrayVehiculos) {
			System.out.print(vehiculo.toString());
			System.out.print("-------------------");
		}
		teclado.close();
	}

}
