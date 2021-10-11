/*	12. Realiza un programa en Java que dadas 10 notas introducidas por teclado (valores de 0 a 10), */

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio12b {

	public static void main(String[] args) {

		double[] notas = new double[10];
		double nota;

		int contSuspensos = 0;
		int contAprobados = 0;
		int contNotables = 0;
		int contSobresalientes = 0;
		int contMatriculas = 0;

		for (int i = 0; i < 10; i++) {
			nota = Double.parseDouble(JOptionPane.showInputDialog("inserte nota"));

			if (nota > 10 || nota < 0) {
				JOptionPane.showMessageDialog(null, "La nota debe tener un valor entre 0 y 10");
				i = i - 1;
			} else {
				notas[i] = nota;
				
				if (nota < 5)
					contSuspensos++;
				else if (nota >= 5 && nota < 7)
					contAprobados++;
				else if (nota >= 7 && nota < 9)
					contNotables++;
				else if (nota >= 9 && nota < 10)
					contSobresalientes++;
				else if (nota == 10)
					contMatriculas++;
			}
		}
		
		System.out.print(contSuspensos + " Suspensos\n" + +contAprobados + " Aprobados\n" + contNotables
				+ " Notables\n" + contSobresalientes + " Sobresalientes\n" + contMatriculas + " Matriculas\nLas notas introducidas son: ");
		for (double note :notas) {
			System.out.print(note + "  ");
		}
	}

}
