package es.florida.ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorCalculo_Hilo implements Runnable{

	BufferedReader br;
	PrintWriter pw;
	Socket socket;

	public ServidorCalculo_Hilo(Socket socket) {
		this.socket = socket;
	}

	
	public static double calcular(String op, String n1, String n2) {

		double resultado = 0;
		char simbolo = op.charAt(0);
		double num1 = Double.parseDouble(n1);
		double num2 = Double.parseDouble(n2);
		if (simbolo == '+')
			resultado = num1 + num2;
		if (simbolo == '-')
			resultado = num1 - num2;
		if (simbolo == '*')
			resultado = num1 * num2;
		if (simbolo == '/')
			resultado = num1 / num2;

		return resultado;
	}

	@Override
	public void run() {

		InputStream is;
		try {
			is = socket.getInputStream();

			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(os);

			System.err
					.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Lee datos para la operación");
			String nomCliente = br.readLine();
			String signo = br.readLine();
			String num1 = br.readLine();
			String num2 = br.readLine();

			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " Cliente " + nomCliente + " >>> Realiza la operacion");
			Double result = calcular(signo, num1, num2);
			
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " Cliente " + nomCliente + " >>> Devuelve resultado");
			pw.write(nomCliente + " >>> " + result.toString() + "\n");
			pw.flush();
			System.err.println("\nSERVIDOR >>> Espera una nueva petición");
			
		} catch (IOException e) {
			System.err.println("SERVIDOR Hilo "+ Thread.currentThread().getName() + " >>> Error");
			e.printStackTrace();
		}
	}

}
