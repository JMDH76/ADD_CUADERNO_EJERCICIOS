package es.florida.ejercicio06;

import java.io.Serializable;

public class Productos implements Serializable {
	
	String producto;
	double precio;
	
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double d) {
		this.precio = d;
	}
	
	@Override
	public String toString() {
		return "Producto: " + producto + "\nPrecio: " + precio + "€";
	}

}
