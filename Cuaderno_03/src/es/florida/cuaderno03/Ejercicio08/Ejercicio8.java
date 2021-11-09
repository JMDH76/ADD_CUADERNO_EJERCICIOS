//8.	Resuelve el problema de los NEOs de la NASA (Actividad Entregable 2) utilizando hilos 
//(multithreading) en vez de procesos (multiprocessing). Compara los tiempos de ejecución 
//entre resolverlo de una forma y de otra.

package es.florida.cuaderno03.Ejercicio08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio8 implements Runnable {  
	
	//Atributos de la clase: informacion necesaria para cada NEO
	String nombreNEO;
	double posicionNEO, velocidadNEO;
	
	/*
	Constructor
	Descripcion: constructor que se invoca para cada nuevo hilo
	Entradas: datos del NEO
	Salidas: no
	*/
	Ejercicio8(String nombreNEO, double posicionNEO, double velocidadNEO) {
		this.nombreNEO = nombreNEO;
		this.posicionNEO = posicionNEO;
		this.velocidadNEO = velocidadNEO;
	}
	
	/*
	getResultadoFichero
	Descripcion: devuelve el resultado que se ha escrito en un fichero, se llama desde getBloqueAnalisis
	Entradas: string nombre del fichero de un NEO
	Salidas: double con el resultado de la probabilidad para el NEO
	*/
	public static double getResultadoFichero(String nombreFichero) throws IOException {
		double probabilidad = 0;
		File fichero = new File(nombreFichero);
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		probabilidad = Double.parseDouble(linea);
		br.close();
		return probabilidad;
		
	}
	
	/*
	getBloqueAnalisis
	Descripcion: devuelve un array con todos los resultados de los NEOs, que lee de cada uno de los ficheros
	Entradas: array de strings con los nombres de los ficheros de los NEOs
	Salidas: array de double con los resultados de la probabilidad de cada NEO
	*/
	public static double[] getBloqueAnalisis(String[] arrayNombres) throws IOException {
		double[] arrayProbabilidades = new double[arrayNombres.length];
		for (int i = 0; i < arrayNombres.length; i++) {
			arrayProbabilidades[i] = getResultadoFichero(arrayNombres[i]);
		}
		return arrayProbabilidades;

	}
	
	/*
	main
	Descripcion: lee la informacion de los NEOs de un fichero hasta el numero de cores del equipo, 
	para cada NEO lanza un hilo de ejecucion, lee los resultados de la ejecucion, 
	muestra mensajes segun el resultado y muestra el tiempo de ejecucion
	Entradas: no
	Salidas: no
	*/
	public static void main(String[] args) throws IOException, InterruptedException {
		long tiempoInicio = System.nanoTime();  //Inicializo tiempo de ejecucion

		int cores = Runtime.getRuntime().availableProcessors();  //Calculo numero de cores del equipo
		System.out.println("NEOHelp! - Detectados " + cores + " cores\n");
		
		File archivoDatos = new File("NEOs.txt");
		FileReader fr = new FileReader(archivoDatos);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();

		//Inicializo arrays para mostrar todo posteriormente
		String[] arrayNombres = new String[cores];
		double[] arrayPosiciones = new double[cores];
		double[] arrayVelocidades = new double[cores];
		double[] arrayProbabilidades = new double[cores];
		
		Ejercicio8 neo;  //Declaro objeto de esta clase, que reutilizare en cada llamada a un nuevo hilo
		Thread hiloNEO;  //Declaro un hilo, que reutilizare en cada llamada a un nuevo hilo
		for (int i = 0; i < cores; i++) {
			String[] elementosLinea = linea.split(",");
			arrayNombres[i] = elementosLinea[0];  //Guardo la informacion en array para mostrarla posteriormente en bloque
			File archivoBorrar = new File(arrayNombres[i]);
			archivoBorrar.delete();  //Borrar archivo de una posible ejecucion anterior
			arrayPosiciones[i] = Double.parseDouble(elementosLinea[1]);
			arrayVelocidades[i] = Double.parseDouble(elementosLinea[2]);
			neo = new Ejercicio8(arrayNombres[i], arrayPosiciones[i], arrayVelocidades[i]);
			hiloNEO = new Thread(neo);
			hiloNEO.start();  //Llama al metodo run de esta clase (observar que no utilizo despues el metodo join para que no se detenga la ejecucion del hilo padre)
			System.out.println("Analisis " + (i + 1) + " lanzado... (NEO: " + arrayNombres[i] + ")");
			linea = br.readLine();
		}
		br.close();
		fr.close();
		
		//Bloque de espera del hilo principal: un vez lanzados todos los hilos intenta leer todos los resultados, 
		//si da excepcion es que aun falta alguno por escribirse y sigue intentandolo
		System.out.print("\n>>> Procesando");
		boolean comprobarFin = false;
		while (!comprobarFin) {
			try {
				arrayProbabilidades = getBloqueAnalisis(arrayNombres);
				comprobarFin = true;
			} catch (Exception e) {  //Si aun no se han escrito los resultados, el hilo principal espera y actualiza mensaje para indicar actividad
				Thread.sleep(500);
				System.out.print(".");
			}
		}
		System.out.println(". FIN PROCESO");
		
		//Mostrar los resultados a partir de los arrays
		for (int i = 0; i < cores; i++) {
			if (arrayProbabilidades[i] > 10) {
				System.err.println("¡¡¡ALERTA!!! El NEO " + arrayNombres[i] + " tiene una probilidad de colisión del " + String.format("%.2f", arrayProbabilidades[i]) + " %");
			} else {
				System.out.println("El NEO "+ arrayNombres[i] + " solo tiene una probilidad de colisión del " + String.format("%.2f", arrayProbabilidades[i]) + " %");
			}
		}
		
		//Tiempo de ejecucion
		long tiempoFin = System.nanoTime();
		long duracion = (tiempoFin - tiempoInicio)/1000000;  //milisegundos
		Thread.sleep(100);  //Pausa para asegurarse que los mensajes siguientes se muestran al final del todo
		System.out.println("\nFIN - Tiempo ejecución total: " + duracion + " ms");
		System.out.println("    - Tiempo medio de ejecución por NEO: " + duracion/cores + " ms");
	}


	/*
	run
	Descripcion: implementacion del metodo run de Runnable, calcula la probabilidad de un NEO y la escribe en un fichero con el nombre del NEO
	Entradas: no
	Salidas: no
	*/
	//CONSEJO: el metodo run debe ejecutar solo aquello que se deba "paralelizar", asi que cuanto mas sencillo mejor, 
	//que no llame a muchas funciones, cree objetos, etc. 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			posicionNEO = posicionNEO + velocidadNEO * i;
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() * Math.pow( ( (posicionNEO - posicionTierra) / (posicionNEO + posicionTierra) ) , 2);
		File ficheroNEO = new File(nombreNEO);
		FileWriter fw;
		try {
			fw = new FileWriter(ficheroNEO);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(String.valueOf(resultado));
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
