/* 	24. Escribe un programa que tome como parámetro de entrada (en la llamada al programa) un 
		número entre 1 y 10, obtenga de forma aleatorio un número (también entre 1 y 10), 
		compare ambos números, los muestre por pantalla y de un premio (a elegir) si coinciden.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio24 {

	public static void main(String[] args) {

		String numerostring;
		//do {
			numerostring = String.valueOf((int) Math.round(Math.random() * 10 + 1));
			
		//} while (Integer.parseInt(numerostring)<1 || Integer.parseInt(numerostring)>10);
		
		//System.out.print(numerostring);
		
		String apuestastring = String.valueOf(Integer.parseInt(JOptionPane.showInputDialog("Introduce un número")));

		if (numerostring.equals(apuestastring)) {
			
			JOptionPane.showMessageDialog(null, "!Enhorabuena! Has acertado.\nEl número era el " + apuestastring);
			
			int premio;	
			do {
				
				premio = Integer.parseInt(JOptionPane.showInputDialog("Elige un premio:\n1. 1.00€\n2. Un viaje a Soria"));
			
				if (premio == 1)  JOptionPane.showMessageDialog(null, "Hemos hecho un ingreso por valor de 1€ en tu cuenta");
				else if (premio == 2)  JOptionPane.showMessageDialog(null, "Ya puedes recoger tus billetes de autobus para viajar a Soria");
				else { JOptionPane.showMessageDialog(null, "Vuelve a elegir");
				}	
			} while ( premio != 1 && premio != 2);
			
		} else {
			JOptionPane.showMessageDialog(null,"¡Ohhh! Has perdido.\nEl número era " + numerostring +" y has apostado por el " + apuestastring);
		}

	}

}
