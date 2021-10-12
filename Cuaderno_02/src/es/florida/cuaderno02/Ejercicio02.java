//		
//				

//Clase Lanzador del ejemplo

package es.florida.cuaderno02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio02 {
	
	static String enunciado = "02. Realiza un programa en Java que llame al programa anterior a través de una llamada de \r\n"
				+ "    sistema, es decir, creando un proceso nuevo con ProcessBuilder.\n";	
	
	public void lanzarSumador(Integer n1, Integer n2) {
			
		try {
			String clase = "es.florida.cuaderno02.Ejercicio01"; // Definimos clase que vamos a llamar

			// Construccion de la llamada que vamos a pasar al ProcessBuilder "command"
			String javaHome = System.getProperty("java.home"); 			// donde está ubicado el java
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java"; 		// donde está el ejecutable
			String classpath = System.getProperty("java.class.path"); 	// Propieded de jdk

			//System.out.println(classpath);  //C:\Users\josem\eclipse-workspace\PSP\CUADERNO_EJERCICIOS\Cuaderno_02\bin

			String classname = clase; // clase que vamos a instanciar

			List<String> command = new ArrayList<>();
			command.add(javaBin);		// C:\Users\josem\.p2\pool\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_16.0.2.v20210721-1149\jre\bin\java
			command.add("-cp"); 		// parámetro para llamar a una clase
			command.add(classpath);		// C:\Users\josem\eclipse-workspace\PSP\CUADERNO_EJERCICIOS\Cuaderno_02\bin
			command.add(classname);		// es.florida.cuaderno02.Ejercicio01
			
			// parámetros de la clase que llamamos:
			command.add(n1.toString()); // 1
			command.add(n2.toString());	// 50
			
			System.out.println("\nComando que se pasa a ProcessBuilder: " + command+"\n");
			// C:\Users\josem\.p2\pool\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_16.0.2.v20210721-1149\jre\bin\java, 
			// -cp, C:\Users\josem\eclipse-workspace\PSP\CUADERNO_EJERCICIOS\Cuaderno_02\bin, es.florida.cuaderno02.Ejercicio01, 1, 50]
			
			System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace("," , "") + "\n");
			// C:\Users\josem\.p2\pool\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_16.0.2.v20210721-1149\jre\bin\java -cp 
			// C:\Users\josem\eclipse-workspace\PSP\CUADERNO_EJERCICIOS\Cuaderno_02\bin es.florida.cuaderno02.Ejercicio01 1 50

			ProcessBuilder builder = new ProcessBuilder(command);	//Construimos el processBuilder

			Process process = builder.inheritIO().start();  //Para que la salida la presente dentro de la clase Ejercicio02 en vez de por le Ejercicio01
			process.waitFor();  //Este proceso esperará hasta que termine
			System.out.println(process.exitValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	
	public static void main(String[] args) {
		
		System.out.println(enunciado);
		
		Ejercicio02 lanzador = new Ejercicio02();	//Creamos objeto de clase
		lanzador.lanzarSumador(1,100);
		System.out.println("Ok");
	}

}
