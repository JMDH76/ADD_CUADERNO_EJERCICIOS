/* 26. 	Realiza una modificación sobre el programa de las notas (ejercicio 12) implemente la 
		funcionalidad de determinar la calificación (suspenso, aprobado,…) en un método aparte 
		(fuera del método “main”).*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio26 {

		static int contSuspensos = 0;
		static int contAprobados = 0;
		static int contNotables = 0;
		static int contSobresalientes = 0;
		static int contMatriculas = 0;
	
	public static void main(String[] args) {

		double[] notas = new double[10];
		double nota;
		
		for (int i = 0; i < 10; i++) {
			
			nota = Double.parseDouble(JOptionPane.showInputDialog("inserte nota"));
			
			if (nota > 10 || nota < 0) {
				JOptionPane.showMessageDialog(null, "La nota debe tener un valor entre 0 y 10");
				i = i - 1;
			} else {
				notas[i] = nota;
				verificaNota(nota);
			}
		}
		System.out.print(contSuspensos + " Suspensos\n" + +contAprobados + " Aprobados\n" + contNotables
				+ " Notables\n" + contSobresalientes + " Sobresalientes\n" + contMatriculas + " Matriculas\nLas notas introducidas son: ");
		for (double note :notas) {
			System.out.print(note + "  ");
		}
	}

	public static void verificaNota(double nota) {
		
		if (nota < 5) contSuspensos++;
		else if (nota >= 5 && nota < 7) contAprobados++;
		else if (nota >= 7 && nota < 9) contNotables++;
		else if (nota >= 9 && nota < 10) contSobresalientes++;
		else if (nota == 10) contMatriculas++;
	}
}

