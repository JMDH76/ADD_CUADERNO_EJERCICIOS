package es.florida.ejercicio06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		
//		Scanner teclado = new Scanner(System.in);
//		System.out.print("Introduce una IP: ");
//		String host = teclado.nextLine();
//		System.out.print("Introdce un puerto: " );
//		int puerto = Integer.parseInt(teclado.nextLine());
		
		
		String host = "localhost";
		int puerto = 5000;
		System.out.println("CLIENTE >>> Arranca cliente -> esperando mensaje del servidor...");
		
		Socket cliente = new Socket(host, puerto); //a partir de aquí se activa de nuevo el servidor
		
		//Primero recibimos porque en servidor hemos dicho que empezaba el servidor
		//Recibimos objeto del servidor para modificarlo
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Productos productoIn = (Productos) inObjeto.readObject();
		System.out.println("CLIENTE >>> Recibido del servidor: " + productoIn.getProducto() + " - " + productoIn.getPrecio());
		
		//Actualizamos la informacion y la sustituimos en el objeto con set
		//System.out.println("Actualizar información del objeto...");
		//System.out.print("Introduce el nombre del producto: ");
		//String producto = teclado.nextLine();
		//System.out.print("Introduce el precio del producto: ");
		//float precio = Float.parseFloat(teclado.nextLine());
		productoIn.setProducto("Zumo Naranja");
		productoIn.setPrecio(2.99);
		Thread.sleep(2000);
		
		System.out.println("CLIENTE >>> Envio al servidor:\n" + productoIn.toString());
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream()); //Enviamos objeto modifica al serviodor
		outObjeto.writeObject(productoIn);
		
		cliente.close();
		inObjeto.close();
		outObjeto.close();		
		//teclado.close();
	}

}
