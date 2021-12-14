/*2. Modifica el programa anterior para que puedas descargar también imágenes y otros tipos 
de archivos que no sean ficheros de texto. Ten en cuenta que tendrás que manejar los datos 
como bytes, ya no valdrá utilizar objetos de tipo Reader que leen líneas o caracteres. */

package es.florida.ejercicio02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class GestorDescargas {

	public static void main(String[] args) {

		String[] ficheros = new String[] { "image01.jpg", "virtualbox.pdf", "license.txt" };
		GestorDescargas gd = new GestorDescargas(); // Creamos objeto GestorDescargas

		//Bucle para comprobar que se copian ficheros con distintas extensiones
		for (int i = 0; i < ficheros.length; i++) {
			String url = "http://localhost:80/PSP/C4_Ej01/" + ficheros[i]; 	
			String fichero = ficheros[i]; 							
			gd.descargarArchivo(url, fichero);
		}
	}

	
	public void descargarArchivo(String urlDescarga, String nombreFichero) {

		System.out.print("Descargando desde: " + urlDescarga + " >>> ");
		
		try {
			URL url = new URL(urlDescarga); 			// Creamos objeto URL para pasar la ubicación del archivo
			InputStream is = url.openStream(); 			// Abrimos la conexión

			byte[] todo = is.readAllBytes();
			FileOutputStream fos = new FileOutputStream("./src/es/florida/ejercicio02/" + nombreFichero);
			fos.write(todo);
			fos.close();

			System.out.println("Fichero copiado correctamente\n");

		} catch (MalformedURLException e) {
			System.out.println("URL mal escrita!");

		} catch (IOException e) {
			System.out.println("Fallo en la lectura del fichero");
		}
	}
}
