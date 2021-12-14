/*2. Modifica el programa anterior para que puedas descargar también imágenes y otros tipos 
de archivos que no sean ficheros de texto. Ten en cuenta que tendrás que manejar los datos 
como bytes, ya no valdrá utilizar objetos de tipo Reader que leen líneas o caracteres. */

package es.florida.ejercicio02;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GestorDescargas_Reader {

	public static void main(String[] args) {

		String[] ficheros = new String[] { "image01.jpg", "virtualbox.pdf", "license.txt" };
		GestorDescargas_Reader gd = new GestorDescargas_Reader(); // Creamos objeto GestorDescargas

		for (int i = 0; i < ficheros.length; i++) {
			String url = "http://localhost:80/PSP/C4_Ej01/" + ficheros[i]; 	// localhost = c:\xammp\htdocs
			String fichero = "b_" + ficheros[i]; 							// nombre con que se va a guardar en cliente
			gd.descargarArchivo(url, fichero);
		}
	}

	public void descargarArchivo(String urlDescarga, String nombreFichero) {

		int index = nombreFichero.indexOf(".");
		String extension = nombreFichero.substring(index);

		System.out.print("Descargando desde: " + urlDescarga + " >>> ");

		try {

			URL urlcon = new URL(urlDescarga); 		// Creamos objeto URL para pasar la ubicación del archivo
			InputStream is = urlcon.openStream(); 	// Abrimos la conexión

			if (extension.equals("txt")) {

				InputStreamReader ir = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(ir);
				FileWriter escribeFichero = new FileWriter("./src/es/florida/ejercicio02/" + nombreFichero);

				String linea;
				System.err.println("Escribiendo fichero...");
				while ((linea = br.readLine()) != null) { // mientras haya líneas, escribimos en el nuevo fichero
					escribeFichero.write(linea + "\n");
				}

				escribeFichero.close(); // cerramos todos Streamers
				br.close();
				is.close();
				ir.close();

			} else {
				byte[] todo = is.readAllBytes();
				FileOutputStream fos = new FileOutputStream("./src/es/florida/ejercicio02/" + nombreFichero);
				fos.write(todo);
				fos.close();
			}

			System.out.println("Fichero copiado correctamente\n");

		} catch (MalformedURLException e) {
			System.out.println("URL mal escrita!");

		} catch (IOException e) {
			System.out.println("Fallo en la lectura del fichero");
		}
	}
}
