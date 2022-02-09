package es.florida.cuaderno05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public class ServidorHTTP {

	public static void main(String[] args) throws IOException {
		
		// Creamos socket
		String host = "localhost"; 	//127.0.0.1
		int puerto = 5000;
		InetSocketAddress direccionTCPIP = new InetSocketAddress(host, puerto);

		int backlog = 0;  //Conexiones en cola, no lo vamos a usar se deja a cero
		HttpServer servidor = HttpServer.create(direccionTCPIP, backlog); //arrancamos el servidor
		
		GestorHTTP gestorHTTP = new GestorHTTP();  //handler que se encarga de procesar por detrás las peticiones
		String rutaRespuesta ="/test";
		servidor.createContext(rutaRespuesta, gestorHTTP); //Donde va a responder nuestro servidor: 127.0.0.1:5000/test
		
		//Opcion sin multihilo:
		//servidor.setExecutor(null);
		
		//Opcion lanzando multihilo con ThreadPoolExecutor
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
		servidor.setExecutor(threadPoolExecutor);
		
		servidor.start();
		System.out.println("Servidor HTTP arracado >> Puerto: " + puerto);
			
	}
}
