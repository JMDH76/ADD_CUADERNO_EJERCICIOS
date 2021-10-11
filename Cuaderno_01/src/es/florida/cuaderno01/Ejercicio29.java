package es.florida.cuaderno01;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio29 {

	public static void main(String[] args) {

		System.out.println("29. Modifica el programa anterior para que el programa admita una "
				+ "lista de longitud indeterminada de vehículos.");

		Scanner teclado = new Scanner(System.in);
		String tipo, marca, modelo;

		ArrayList<Vehiculo> listVehiculos = new ArrayList<Vehiculo>();
		String finalizar = "1";
		int cont = 0;
		while (!finalizar.equals("0")) {

			System.out.println("\nIndica las características del vehículo " + (cont + 1));

			System.out.print(" TIPO de vehiculo: ");
			tipo = teclado.nextLine();
			System.out.print(" MARCA del vehículo: ");
			marca = teclado.nextLine();
			System.out.print(" MODELO del vehículo: ");
			modelo = teclado.nextLine();
			
			finalizar = tipo;		//Si ponemos un cero aquí es el que toma la condicion para salir
			if (!finalizar.equals("0")) {
				Vehiculo nuevoVehiculo = new Vehiculo(tipo, marca, modelo);
				listVehiculos.add(nuevoVehiculo);
				cont++;
			} else
				finalizar = "0";
		}

		System.out.print("\nLista de vehículos:\n-------------------");
		for (Vehiculo vehiculo : listVehiculos) {
			System.out.print(vehiculo.toString());
			System.out.print("-------------------");
		}
		teclado.close();
	}
}
