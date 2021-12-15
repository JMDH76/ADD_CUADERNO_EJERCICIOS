/*9. Modifica el programa ClienteCalculo para que admita como parámetros de entrada 
(argumentos) los 3 parámetros que necesita para hacer una petición al servidor (tipo de 
operación (+ - * /), número 1 y número2) más un String con el nombre que se asignará al 
cliente.*/
package es.florida.ejercicio08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteCalculo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String[] operacion = {"/", "120", "60"};

		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexión al servidor");
		//Otra forma de crear el socket:
		InetSocketAddress direccion = new InetSocketAddress("localhost", 5000);  //pasamos host y puerto
		Socket socket = new Socket();	//creamos socket vacio
		socket.connect(direccion);
		Thread.sleep(2000);
		
		System.out.println("CLIENTE >>> Envío datos cálculo: " + operacion[1] + " " + operacion[0] + " " + operacion[2]);
		PrintWriter pw = new PrintWriter(socket.getOutputStream());		//envío datos al servidor. Escribe en la salida
		//Escribimos las 3 lineas que está esperando el servidor
		pw.print(operacion[0] + "\n");  //importante el salto de linea para que el servidor lo lea por separado
		pw.print(operacion[1] + "\n");
		pw.print(operacion[2] + "\n");
		pw.flush(); //limpiamos el objeto pw
		
		Thread.sleep(2000);
		//recibimos y leemos desde el servidor
		System.out.println("CLIENTE >>> Preparado canal para recibir resultado");
		InputStream is = socket.getInputStream(); 
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader (isr);
		
		Thread.sleep(2000);
		String resultado = br.readLine();
		System.out.println("CLIENTE >>> Recibe resultado: " + resultado);
		socket.close();
		
	}
}
