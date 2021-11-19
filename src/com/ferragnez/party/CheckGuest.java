package com.ferragnez.party;

import java.util.Scanner;

public class CheckGuest {

	public static void main(String[] args) {
		String[] invitati = { "Dua Lipa", "Paris Hilton", "Manuel Agnelli", "J-Ax", "Francesco Totti", "Ilary Blasi", 
			"Bebe Vio", "Luis", "Pardis Zarei", "Martina Maccherone", "Rachel Zeilic" };

		System.out.println("Mi dica il nome per favore: ");
		Scanner scanner = new Scanner(System.in);
		String nominativo = scanner.nextLine();
		System.out.println("Il suo nome è " + nominativo);

		boolean trovato = false;

		for (int i = 0; i < invitati.length; i++) {

			if (nominativo.equals(invitati[i])) {

				trovato = true;
				System.out.println("Prego, entri pure");

				break;
			}

		}

		if (!trovato) {
			System.out.println("Non può entrare!");
			// break;
		}

		scanner.close();

	}

}
