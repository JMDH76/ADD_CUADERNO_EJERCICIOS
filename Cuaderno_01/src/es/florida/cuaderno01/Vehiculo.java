package es.florida.cuaderno01;

public class Vehiculo {

	String tipo, marca, modelo; // Tipo atributos

	Vehiculo() {
	} // Constructor vacio

	Vehiculo(String tipo, String marca, String modelo) { // Constructor

		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String toString() {
		return ("\n Tipo: " + getTipo() + "\n Marca: " + getMarca() + "\n Modelo: " + getModelo() + "\n");
	}
}
