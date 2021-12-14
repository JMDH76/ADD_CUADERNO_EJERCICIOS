/*1. Implementa para que funcione en tu equipo un gestor de descargas de ficheros de texto 
como el visto en el ejemplo de teoría. Necesitarás tener los recursos a descargar en el 
directorio correspondiente de XAMPP. -> 'c:\xammp\htdocs' */

package es.florida.ejercicio01;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GestorDescargas {

	public static void main(String[] args) {
		
		GestorDescargas gd = new GestorDescargas();							//Creamos objeto GestorDescargas
		String url = "http://localhost:80" + "/PSP/C4_Ej01/license.txt";	//localhost = c:\xammp\htdocs
		String fichero = "license.txt";  									//nombre con que se va a guardar en cliente
		gd.descargarArchivo(url, fichero);
	}

	public void descargarArchivo(String urlDescarga, String nombreFichero) {

		System.out.println("Descargando desde: " + urlDescarga);

		try {
			
			URL urlcon = new URL(urlDescarga);  		//Creamos objeto URL para pasar la ubicación del archivo
			InputStream is = urlcon.openStream();		//Accedemos a la ubicación, copiamos y metemos en el Buffer
			InputStreamReader ir = new InputStreamReader(is);	
			BufferedReader br = new BufferedReader(ir);
			FileWriter escribeFichero = new FileWriter("./src/es/florida/ejercicio01/" + nombreFichero);	//Accedemos para escribir

			String linea;
			System.err.println("Escribiendo fichero...");
			while ((linea = br.readLine()) != null) {	//mientras haya líneas, escribimos en el nuevo fichero	
				escribeFichero.write(linea + "\n");
			}
			
			escribeFichero.close();		//cerramos todos Streamers
			br.close();
			is.close();
			ir.close();

			System.out.print("\nFichero copiado correctamente");
			
		} catch (MalformedURLException e) {
			System.out.println("URL mal escrita!");

		} catch (IOException e) {
			System.out.println("Fallo en la lectura del fichero");
		}
	}
}
