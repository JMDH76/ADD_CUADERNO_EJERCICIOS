/*  25. Ampliar el programa anterior para que permita apostar 3 números a la vez*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio25 {

	public static void main(String[] args) {

		String numerostring;
		//do {
			numerostring = String.valueOf((int) Math.round(Math.random() * 10 + 1));
		
		//} while (Integer.parseInt(numerostring)<1 || Integer.parseInt(numerostring)>10);
		
		//System.out.println(numerostring);

		String[] apuestas = new String[3];
		String apuestastring = "";

		JOptionPane.showMessageDialog(null, "Elige 3 números");
		for (int i = 0; i < 3; i++) {
			apuestastring = String.valueOf(Integer.parseInt(JOptionPane.showInputDialog("Introduce número")));
			if (Integer.parseInt(apuestastring) <= 10 && Integer.parseInt(apuestastring) >= 1) {
				apuestas[i] = apuestastring;
			} else {
				i = i - 1;
			}
		}
		
		boolean bandera = false;
		for (String apuesta : apuestas) {
			
			if (numerostring.equals(apuesta) == true) {
				bandera = true;
				JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has acertado.\nEl número era el " + numerostring);
				
				int premio;
				do {
					premio = Integer.parseInt(JOptionPane.showInputDialog("Elige un premio:\n1. 1.00€\n2. Un viaje a Soria"));

					if (premio == 1)
						JOptionPane.showMessageDialog(null, "Hemos hecho un ingreso por valor de 1€ en tu cuenta");
					else if (premio == 2)
						JOptionPane.showMessageDialog(null, "Ya puedes recoger tus billetes de autobus para viajar a Soria");
					else {
						JOptionPane.showMessageDialog(null, "Vuelve a elegir");
					}
					
				} while (premio != 1 && premio != 2);

			} 
			
		} if (bandera == false) JOptionPane.showMessageDialog(null, "¡Ohhh! Has perdido\nEl número era el " + numerostring);

	}

}
