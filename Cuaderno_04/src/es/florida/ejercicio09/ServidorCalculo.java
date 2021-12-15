package es.florida.ejercicio09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.err.println("SERVIDOR >>> Arranca el servidor. En espera de petición");
		ServerSocket socketEscucha = new ServerSocket(5000);
		
		//Le ponemos el bucle infinito para que esté siempre en escucha
		while(true) {
			Socket conexion = socketEscucha.accept();
			
			//Recibimos 3 líneas desde clinete que leeremos y extraeremos los datos
			System.err.println("SERVIDOR >>> ¡Conexión recibida!");
			InputStream is = conexion.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			System.err.println("SERVIDOR >>> Datos de la operación");
			String nomCliente = br.readLine();
			String signo = br.readLine();
			String num1 = br.readLine();
			String num2 = br.readLine();
			Thread.sleep(2000);
			
			System.err.println("SERVIDOR >>> Realiza operación");
			Double result = calcular(signo, num1, num2);
			
			Thread.sleep(2000);
			System.err.println("SERVIDOR >>> Devuelve resultado");
			//Devolvemos el resultado al cliente en un string
			OutputStream os = conexion.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write(nomCliente + " >>> " + result.toString() + "\n");
			pw.flush();		//Se limpia
			System.err.println("\nSERVIDOR >>> Espera una nueva petición");			
		}	
	}
	

	
	
	public static double calcular(String op, String n1, String n2) {
		
		double resultado = 0;
		char simbolo = op.charAt(0);
		double num1 = Double.parseDouble(n1);
		double num2 = Double.parseDouble(n2);
		if (simbolo == '+') resultado = num1 + num2;
		if (simbolo == '-') resultado = num1 - num2;
		if (simbolo == '*') resultado = num1 * num2;
		if (simbolo == '/') resultado = num1 / num2;
		
		return resultado;
	}
}
