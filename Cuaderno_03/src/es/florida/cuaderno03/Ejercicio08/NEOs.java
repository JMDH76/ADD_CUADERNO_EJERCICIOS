package es.florida.cuaderno03.Ejercicio08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NEOs implements Runnable {

	static String fichero = "src\\es\\florida\\cuaderno03\\Ejercicio08\\NEOs.txt";
	static String directorioSalida = "src\\es\\florida\\cuaderno03\\Ejercicio08\\FicherosNEOs\\";
	static ArrayList<Long> tiempomedioproceso = new ArrayList<Long>();
	
	
	String nombreNEO;
	double velNEO, posNEO;
	
	public NEOs (String nombreNEO, double velNEO, double posNEO) {
		
		this.nombreNEO = nombreNEO;
		this.velNEO = velNEO;
		this.posNEO = posNEO;
	}
	
	
	public static void main(String[] args) {

		long tiempoInicioEjecucion = System.nanoTime();

		try {
			File f = new File(fichero);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();

			while (linea != null) {
				int index = linea.indexOf(",");
				String nombreNEO = linea.substring(0, index);
				linea = linea.substring(index + 1);

				int index2 = linea.indexOf(",");
				double posNEO = Double.parseDouble(linea.substring(0, index2));
				double velNEO = Double.parseDouble(linea.substring(index2 + 1));

				linea = br.readLine();
				NEOs neo = new NEOs(nombreNEO, posNEO, velNEO);
				Thread t = new Thread(neo);
				t.start();
			}

			br.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long tiempoFinEjecucion = System.nanoTime();
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Long sumatiempo = (long) 0;
		for (Long tiempo : tiempomedioproceso) {
			sumatiempo += tiempo;
		}

		long tiempomedioNEO = (sumatiempo / tiempomedioproceso.size())/1000000;
		long tiempoEjecucion = ( tiempoFinEjecucion - tiempoInicioEjecucion)/1000000;
		
		System.out.println("Tiempo total de ejecución: " + tiempoEjecucion + "ms");
		System.out.println("Tiempo medio por NEO: " + tiempomedioNEO+ "ms");
	}


	
	@Override
	public void run() {
		
		long tiempoInicioNEO = System.nanoTime();
		String probabilidad = String.valueOf(calculoProbabilidad(posNEO, velNEO));
	
		try {
			File neoFile = new File(directorioSalida + nombreNEO + ".txt");
			//System.out.println(neoFile);
			FileWriter fw = new FileWriter(neoFile);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(probabilidad);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Double.parseDouble(probabilidad) < 10)
			System.out.println(
					"\"" + nombreNEO + "\"	" + probabilidad + "%	Baja probabilidad de colision. ¡No hay peligro!\n");
		else
			System.err.println("\"" + nombreNEO + "\"	" + probabilidad
					+ "% 	¡ALERTA! Alta probabilidad de colision... Iniciando protocolos de evacuación del planeta...\n");

		long tiempoFinNEO = System.nanoTime();
		long tiempoNEO = (tiempoFinNEO - tiempoInicioNEO);
		tiempomedioproceso.add(tiempoNEO);
	}

	
	
	
	public static double calculoProbabilidad(double posicionNEO, double velocidadNEO) {

		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double probabilidad = 100 * Math.random()
				* Math.pow((posicionNEO - posicionTierra) / (posicionNEO + posicionTierra), 2);
		double probabilidadFormat = Math.round(probabilidad * 100.0) / 100.0;

		return probabilidadFormat;
	}





	
}
