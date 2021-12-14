package es.florida.cuaderno03.Ejercicio07;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Caracol implements Runnable{
	
	static String rutaFichero = "src\\es\\florida\\cuaderno03\\Ejercicio07\\Carrera_caracoles\\campeon.txt";
	
	double distancia = 1;
	String nombre;
	double velocidad;
	
	public Caracol(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}

	
	public static void main(String[] args) {
		
		File f = new File(rutaFichero);
		if (f.exists())	f.delete();
		
		int caracoles = 5;
		Caracol caracol;
		double[] velocidad = {0.012, 0.015, 0.0099, 0.00999, 0.0105};
		
		for (int i = 1; i <= caracoles; i++) {
			caracol = new Caracol(("Caracol_" + i), velocidad[i - 1]);
			Thread hilo = new Thread(caracol);
			hilo.start();
		}

		FileReader fr;
		while (!f.exists()) {
			try {
				fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String nombre = br.readLine();
				System.err.println(nombre + " ¡¡HA GANADO LA CARRERA!!" );
				br.close();
				fr.close();
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}

	
	@Override
	public void run() {

		double avance = 0;
		double porcentaje = 0;
		File f = new File(rutaFichero);
		
		while (avance < distancia) {
			
			for (int i = 0; i < 1e7; i++) {
				double resultadoTonto = Math.sqrt((double)(i));
				}
			
			if (f.exists()) {
				System.out.println(
						nombre + " Abandona la carrera. Ha recorrido el " + String.format("%.1f", porcentaje) + "% ");
				avance = distancia;
			} else {
				avance += velocidad * 1;
				porcentaje = 100 * avance / distancia;
				System.out.println(nombre + " --> " + String.format("%.1f", porcentaje) + "%");
			}
		}
		
		if (!f.exists()) {
			FileWriter fw;
			try {
				fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(nombre);
				bw.close();
				fw.close();
				//System.out.println(nombre + "¡¡¡Campeón!!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("El " + nombre + " ha ganado la carrera ");
		}
	}
}