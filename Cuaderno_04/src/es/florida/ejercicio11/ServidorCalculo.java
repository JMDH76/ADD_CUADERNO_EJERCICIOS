/*11. Modifica el programa servidor para que sea multihilo, es decir, que para cada conexión de 
un cliente cree un nuevo hilo. Realiza las pruebas que has hecho en el ejercicio 10 para ver 
el funcionamiento. Para facilitar la traza de cada hilo, haz que en los mensajes que se 
muestran del servidor aparezca reflejado el nombre del hilo. */

package es.florida.ejercicio11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculo{


	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.err.println("SERVIDOR >>> Arranca el servidor. En espera de petición");
		ServerSocket socketEscucha = new ServerSocket(5000);
		
		while(true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> ¡Conexión recibida! --> Lanzando hilo clase Peticion");
	
			ServidorCalculo_Hilo sc = new ServidorCalculo_Hilo(conexion);
			Thread hilo = new Thread (sc);
			hilo.start();
			
		}	
	}
	
}
