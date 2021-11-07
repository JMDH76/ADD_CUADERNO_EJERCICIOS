/*1. Crea una clase llamada “MostrarASCII” que implemente Runnable y que tenga como 
atributo un número entero denominado “tipo”. Si el tipo es 1, la clase mostrará los 
caracteres ASCII impares y si es 2, los pares. La aplicación (método main) deberá crear dos 
hilos, uno para mostrar los impares y otro para los pares.*/

package es.florida.cuaderno03.Ejercicio01;

public class MostrarASCII implements Runnable{
	
	private int tipo;

	public MostrarASCII(int tipo) {
		this.tipo = tipo;
	}
	
	
	int a = 0;

	@Override
	public void run() {
		if (tipo == 1) a = 1;
		else a = 2;
		for (int i = a; i < 256; i += 2) {
			System.out.println("H" + tipo + " --> Caracter ASCII " + i + " = " + ((char) (i * 2)));
		}
		System.out.println("Hilo" + tipo + ": FINALIZADO");
	}

	
	public static void main(String[] args) {

		int hilos = 2;
		MostrarASCII op;

		for (int i = 0; i < hilos; i++) {
			op = new MostrarASCII(i + 1);
			Thread hilo = new Thread(op);
			hilo.start();
		}
		
	}
}
