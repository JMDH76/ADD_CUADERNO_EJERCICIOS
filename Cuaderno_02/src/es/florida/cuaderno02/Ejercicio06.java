package es.florida.cuaderno02;

	import java.io.File;
	import java.util.ArrayList;
	

public class Ejercicio06 {
		
		static String enunciado = "06. Crea una ampliación del programa 2 para que redirija la salida de la ejecución del programa 1\r\n"
				+ "    a su flujo de ejecución y lo muestre por consola (pista: utilizar inheritIO).\n";	
		
		
		/*
		 * Metodo lanzarSumador() 
		 * ACTION:	construye la llamada para el processBuilder, lo crea y lo inicia. 
		 * Pasa a la clase Ejercicio01 los parámetros del intervalo. Controla las posibles excepciones.
	 	 * INPUT: 	valores del intervalo a sumar (Integer).
		 * OUTPUT: 	la salida del Ejerccio01 por consola con "builder.inheritIO().start();"
		 */
		public static void lanzarSumador(Integer n1, Integer n2) {
				
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
				//System.out.println("\nComando que se pasa a ProcessBuilder: " + command+"\n");		
				//System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace("," , "") + "\n");

				ProcessBuilder builder = new ProcessBuilder(command);	
				
				builder.inheritIO().start();  //Para que la salida se presente dentro de la clase Ejercicio06 en vez de por le Ejercicio01

			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		
		public static void main(String[] args) {
			
			System.out.println(enunciado);
			int n1 = 1;
			int n2 = 100;
			lanzarSumador(n1,n2);
			System.out.println("Lanzado correctamente");
		}

	}

