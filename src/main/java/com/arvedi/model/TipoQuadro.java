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

        public String getNome() {
        	return nome;
        }

        public void setNome(String nome) {
        	this.nome = nome;
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
			return "TipoQuadro [nome=" + nome + ", descrizione=" + descrizione + "]";
}

