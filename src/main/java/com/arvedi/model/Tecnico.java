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
public class Tecnico{
	//DICHIARAZIONE ATTRIBUTI
		protected String cognome;
		protected String nome;
		
	//COSTRUTTORE E METODI GETTER E SETTER
		public Tecnico(String nome, String cognome) {
			this.nome = nome;
			this.cognome = cognome;
			}
		
		public String getCognome() {
			return cognome;
		}
		
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
	 //TOSTRING
		@Override
		public String toString() {
			return "Tecnico [cognome=" + cognome + ", nome=" + nome + "]";
		}
}