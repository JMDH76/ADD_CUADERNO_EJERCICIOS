package es.florida.ejercicio05;

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
		return "Producto: " + producto + "\nPrecio: " + precio + "€";
	}

}
