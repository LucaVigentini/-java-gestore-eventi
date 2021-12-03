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
	public Evento(String titolo, LocalDate date, int totalSeats) throws IllegalArgumentException {
		this.titolo = titolo;

		if (isValidData(true)) {
			this.date = date;
		} else {
			throw new IllegalArgumentException("Questo evento è già avvenuto");
		}
		if (isValidSeats(true)) {
			this.totalSeats = totalSeats;
		} else {
			throw new IllegalArgumentException("Questo evento è già al completo");
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

	public int prenota() {
		if (totalSeats >= prenotedSeats) {
			prenotedSeats++;
			return prenotedSeats;
		} else {
			return prenotedSeats;
		}
	}

	public int disdici() {
		if (prenotedSeats > 0) {
			prenotedSeats--;
			return prenotedSeats;
		} else {
			return prenotedSeats;
		}

	}

	public String dataFormattata() {
		String dataFormattata;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = date.format(df);
		return dataFormattata;
	}

	public String getDateEvento() {
		return dataFormattata() + titolo;
	}

	// metodi private
	private boolean isValidData(boolean validData) {
		LocalDate dataLocale = LocalDate.now();
		if (date.isAfter(dataLocale)) {
			return validData = true;
		} else {
			return validData = false;
		}

	}

	private boolean isValidSeats(boolean validSeats) {
		if (totalSeats == prenotedSeats) {
			return validSeats = false;
		} else {
			return validSeats = true;
		}

	}

}
