package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Come si chiama l'evento? ");
		String nome = scn.nextLine();
		System.out.println("Numero posti disponibili: ");
		int posti = scn.nextInt();

		int prenotazioni = 0;

		System.out.println("Inserire la data dell'evento");
		String dateInString = scn.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dateInString, formatter);

		Evento event = new Evento(nome, posti, date, prenotazioni);

		System.out.println("Vuoi fare delle prenotazioni? y o n");
		String scelta = scn.nextLine().toLowerCase();
		boolean risposta = false;
		if (scelta == "y") {
			risposta = true;

			System.out.println("Quante prenotazioni vuoi fare? ");
			prenotazioni = scn.nextInt();

			System.out.println(event.prenota() + " " + (posti - prenotazioni));
		}
		try {
			
			System.out.println("Stampa " + event.getTitolo());
			
			
		} catch (IllegalArgumentException e) {
			System.out.println("Impossibile creare l'evento!");
			System.out.println(e.getMessage());
			
		}
		
	
		
		System.out.println(nome + posti + date);
	

		
		
		
		
		
		
		
		scn.close();
	}

}
