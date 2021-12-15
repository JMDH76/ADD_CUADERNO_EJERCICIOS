/*3. Para trabajar el env�o y recepci�n de objetos serializados, crea una clase que represente un 
objeto con algunos atributos, de manera an�loga a la clase Persona utilizada en el ejemplo 
de teor�a. Recuerda que debe implementar Serializable para que se pueda enviar a trav�s 
de una conexi�n de red.*/

package es.florida.ejercicio03;

import java.io.Serializable;

public class Productos implements Serializable {
	
	String producto;
	float precio;
	
	public Productos() {	//Constructor vacio
		super();
	}

	public Productos(String producto, float precio) {
		super();
		this.producto = producto;
		this.precio = precio;
	}


	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Productos [producto=" + producto + ", precio=" + precio + "]";
	}

}
