/*5. El delegado de clase ha comprado un bote extra grande de alitas de pollo en el KFC (100 
alitas) y los va a repartir entre los 30 compa�eros de clase. Para ello crea una clase que 
implementa Runnable y que tiene un m�todo �consumirAlita� que mientras queden alitas 
permite consumir el n�mero que pida cada compa�ero (entre 1 y 10 alitas, de forma 
aleatoria), un m�todo �run� (obligado al implementar Runnable) que llama a 
�consumirAlita� y un �main� que crea un hilo por cada compa�ero. El �main� deber� mostrar 
al final de la ejecuci�n cu�ntas alitas se han comido entre todos. Realiza dos ejecuciones: sin 
y con sincronizaci�n del m�todo �consumirAlita� (problema similar al de las entradas). */

package es.florida.cuaderno03.Ejercicio05;

public class KFC implements Runnable{

	static int alitasDisponibles = 100;
	static int alitasConsumidas = 0;
	
	public static void main(String[] args) {
		KFC kfc = new KFC();
		Thread t;

		for (int i = 0; i < 30; i++) {
			t = new Thread(kfc);
			t.setName("Compa�ero_" + (i + 1));
			t.start();
			
			try {
				Thread.sleep(100); // ponemos un retardo para poder verlo por consola
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Han gorroneado " + alitasConsumidas + " alitas");
		System.out.println("Han sobrado " + alitasDisponibles + " alitas");
	}

	
	synchronized public void consumirAlitas(String nombre, int alitas){
		if(alitas <= alitasDisponibles) {
			alitasDisponibles -= alitas;
			alitasConsumidas += alitas;
			
			System.out.println(nombre  + "	-->	" +  alitas + " alitas. Quedan " + alitasDisponibles);
		}
		else System.err.println("No quedan suficientes alitas");
	}

	
	@Override
	public void run() {
		String nombre = Thread.currentThread().getName();
		int alitas = (int) (Math.random() * 10 + 1);
		consumirAlitas(nombre, alitas);
	}

}
