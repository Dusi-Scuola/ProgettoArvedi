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
	private TipoQuadro tipologia;
	private String codiceQuadro;
	
//COSTRUTTORE E METODI GETTER E SETTER
	public Quadro(TipoQuadro tipologia, String codiceQuadro) {
		this.tipologia = tipologia;
		this.codiceQuadro = codiceQuadro;
		}

		public TipoQuadro getTipologia() {
			return tipologia;
		}
		
		public void setTipologia(TipoQuadro tipologia) {
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
