package es.florida.cuaderno02;

import java.io.File;

import java.util.ArrayList;	

public class Ejercicio07 {
		
		static String enunciado = "07. Crear otra ampliación del programa 2 para que redirija la salida de la \r\n"
				+ "    ejecución del programa 1 a su flujo de ejecución y lo escriba en un fichero "
				+ "(pista: utilizar redirectOutput).\n";	
		
		/*
		 * Metodo lanzarSumador() 
		 * ACTION:	construye la llamada para el processBuilder, lo crea y lo inicia. 
		 * Recibe los parámetros del intervalo y nombre fichero de salida, llama a la 
		 * clase Ejerccio01 pasándoselos. Redirecciona la salida de Ejercicio01 a un 
		 * fichero. Controla las posibles excepciones.
	 	 * INPUT: 	valores del intervalo a sumar (Integer) para pasarlos a la clase 
	 	 * Ejerccio01 y el nombre del fichero de salida para crearlo con "builder.redirectOutput(Salida);".
		 * OUTPUT: 	la salida del Ejerccio01 escrita en el fichero de salida.
		 * */
		public static void lanzarSumador(Integer n1, Integer n2, String ficherosalida) {
				
			File Salida = new File(ficherosalida);
			
			try {
				String clase = "es.florida.cuaderno02.Ejercicio01"; 
				String javaHome = System.getProperty("java.home"); 			
				String javaBin = javaHome + File.separator + "bin" + File.separator + "java"; 		
				String classpath = System.getProperty("java.class.path"); 	
				String classname = clase; 									
				ArrayList<String> command = new ArrayList<String>();
				command.add(javaBin);		
				command.add("-cp"); 		
				command.add(classpath);		
				command.add(classname);		
				command.add(n1.toString()); 
				command.add(n2.toString());	
				
				ProcessBuilder builder = new ProcessBuilder(command);	
		
				builder.redirectOutput(Salida); //Redirecciona la salida del ejercicio01 al fichero "salida.txt"
				builder.start();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	

		public static void main(String[] args) {

			System.out.println(enunciado);
			int n1 = 1;
			int n2 = 405;
			String ficherosalida = "salida.txt";
			lanzarSumador(n1, n2, ficherosalida );
			
			System.out.println("Lanzado correctamente");
		}

	}

