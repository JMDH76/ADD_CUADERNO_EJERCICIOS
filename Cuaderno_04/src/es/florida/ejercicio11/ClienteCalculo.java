package es.florida.ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteCalculo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String nombreCliente = "Cliente";
		String[] operacion = {"*", "90", "15"};
		
		//No acepta * por parámetro así que hay que ponerlo con \ y despues debemos quitársela para calcular
		if (args.length > 0) {
			nombreCliente = args[0];
			String tipoOperacion = args[1];
			if (tipoOperacion.length() > 1) {
				operacion[0] = tipoOperacion.substring(1);
			} else {
				operacion[0] = tipoOperacion;
			}
			operacion[1] = args[2];
			operacion[2] = args[3];
		}

		System.out.println(nombreCliente + " >>> Arranca cliente");
		System.out.println(nombreCliente + " >>> Conexión al servidor");
		//Otra forma de crear el socket:
		InetSocketAddress direccion = new InetSocketAddress("localhost", 5000);  //pasamos host y puerto
		Socket socket = new Socket();	//creamos socket vacio
		socket.connect(direccion);
		Thread.sleep(2000);
		
		System.out.println(nombreCliente + " >>> Envío datos cálculo: " + nombreCliente + " " + operacion[1] + " " + operacion[0] + " " + operacion[2]);
		PrintWriter pw = new PrintWriter(socket.getOutputStream());		//envío datos al servidor. Escribe en la salida
		//Escribimos las 3 lineas que está esperando el servidor
		pw.print(nombreCliente + "\n");
		pw.print(operacion[0] + "\n");  //importante el salto de linea para que el servidor lo lea por separado
		pw.print(operacion[1] + "\n");
		pw.print(operacion[2] + "\n");
		pw.flush(); //limpiamos el objeto pw
		
		Thread.sleep(2000);
		//recibimos y leemos desde el servidor
		System.out.println(nombreCliente + " >>> Preparado canal para recibir resultado");
		InputStream is = socket.getInputStream(); 
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader (isr);
		
		Thread.sleep(2000);
		String resultado = br.readLine();
		System.out.println(nombreCliente + " >>> Recibe resultado: " + resultado);
		socket.close();
	}
}
