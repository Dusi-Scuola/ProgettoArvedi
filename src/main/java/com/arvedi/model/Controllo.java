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
public class Controllo{
	 //DICHIARAZIONE ATTRIBUTI
    private String descrizione;
    
//COSTRUTTORE E METODI GETTER E SETTER
    public Controllo(String descrizione) {
        this.descrizione = descrizione;
        }

        public String getDescrizione() {
        	return descrizione;
        }

        public void setDescrizione(String descrizione) {
        	this.descrizione = descrizione;
        }
//TOSTRING       
      	@Override
      	public String toString() {
  			return "Controllo [descrizione=" + descrizione + "]";
}