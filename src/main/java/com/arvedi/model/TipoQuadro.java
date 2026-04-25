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
public class TipoQuadro{
	//DICHIARAZIONE ATTRIBUTI
    private String nome;
    private String descrizione;
    
//COSTRUTTORE E METODI GETTER E SETTER
    public TipoQuadro(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        }

        public String getnome() {
        	return nome;
        }

        public void setnome(String nome) {
        	this.nome = nome;
        }
        
        public String getdescrizione() {
        	return descrizione;
        }

        public void setdescrizione(String descrizione) {
        	this.descrizione = descrizione;
        }    
}

