package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	// attributi

	private String titolo;
	private LocalDate date;
	private int totalSeats;
	private int prenotedSeats;

	// costruttori
	public Evento(String titolo, int totalSeats, LocalDate date, int prenotedSeats) throws IllegalArgumentException {
		this.titolo = titolo;

		if (isValidData(date)) {
			this.date = date;
		} else {
			throw new IllegalArgumentException("Questo evento è già avvenuto");
		}
		
		if (isValidSeats(totalSeats)) {
			this.totalSeats = totalSeats;
		} else {
			throw new IllegalArgumentException("Non sono disponibili posti");
		}

		this.prenotedSeats = 0;

	}

	// getter e setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public int getPrenotedSeats() {
		return prenotedSeats;
	}

	// metodi public

	public int prenota() throws IllegalArgumentException {
		if (totalSeats >= prenotedSeats) {
			prenotedSeats++;
			return prenotedSeats;
		} else {
			throw new IllegalArgumentException("Non sono disponibili tutti questi posti!");
		}
	}

	public int disdici() throws IllegalArgumentException {
		if (prenotedSeats > 0) {
			prenotedSeats--;
			return prenotedSeats;
		} else {
			throw new IllegalArgumentException("Non ci sono tutte queste prenotazioni");
		}

	}

	public String dataFormattata() {
		String dataFormattata;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		dataFormattata = date.format(df);
		return dataFormattata;
	}

	public String getDateEvento() {
		return dataFormattata() + titolo;
	}

	// metodi private
	private boolean isValidData(LocalDate date) {
		LocalDate dataLocale = LocalDate.now();
		
		if (date.isAfter(dataLocale)) {
			return true;
		} else {
			return false;
		}

	}

	private boolean isValidSeats(int totalSeats) {
		if (totalSeats == 0) {
			return false;
		} else {
			return true;
		}

	}

}
