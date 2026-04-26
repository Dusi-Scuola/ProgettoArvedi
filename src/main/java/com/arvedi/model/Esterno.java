package com.arvedi.model;

/**
 * This class is the MODEL in the MVC architecture.
 *
 * The Model contains:
 *  - the data (state)
 *  - the basic logic that manipulates the data
 *
 * IMPORTANT:
 *  The Model does NOT know anything about the GUI or CLI.
 *  It is completely independent.
 */
public class Esterno extends Tecnico{
	//DICHIARAZIONE ATTRIBUTI
		private String azienda;
	//COSTRUTTORE E METODI GETTER E SETTER
		public Esterno(String azienda) {
			super();
			this.azienda = azienda;
			}
		
		public String getAzienda() {
			return azienda;
		}
		
		public void setAzienda(String azienda) {
			this.azienda = azienda;
		}
		
	//TOSTRING
			@Override
			public String toString() {
				return "Esterno [azienda=" + azienda + "]";
				}
}