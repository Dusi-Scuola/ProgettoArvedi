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
public class Quadro{
	//DICHIARAZIONE ATTRIBUTI
	private String tipologia;
	private String codiceQuadro;
	
//COSTRUTTORE E METODI GETTER E SETTER
	public Quadro(String tipologia, String codiceQuadro) {
		this.tipologia = tipologia;
		this.codiceQuadro = codiceQuadro;
		}

		public String getTipologia() {
			return tipologia;
		}
		
		public void setTipologia(String tipologia) {
			this.tipologia = tipologia;
		}

		public String getCodiceQuadro() {
			return codiceQuadro;
		}
		
		public void setCodiceQuadro(String codiceQuadro) {
			this.codiceQuadro = codiceQuadro;
		}
//TOSTRING		
		@Override
		public String toString() {
			return "Quadro [tipologia=" + tipologia + ", codiceQuadro=" + codiceQuadro + "]";
		}
}
