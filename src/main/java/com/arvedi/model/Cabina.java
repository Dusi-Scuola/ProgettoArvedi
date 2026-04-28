package com.arvedi.model;
import java.util.ArrayList;

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
public class Cabina{
	
	private String codiceCabina;
	private String posizione;
	private ArrayList<Quadro> quadri;
	
	public Cabina(String codiceCabina, String posizione, ArrayList<Quadro> quadri) {
		this.codiceCabina = codiceCabina;
		this.posizione = posizione;
		this.quadri = quadri;
	}

	public String getCodiceCabina() {
		return codiceCabina;
	}

	public void setCodiceCabina(String codiceCabina) {
		this.codiceCabina = codiceCabina;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public ArrayList<Quadro> getQuadri() {
		return quadri;
	}

	public void setQuadri(ArrayList<Quadro> quadri) {
		this.quadri = quadri;
	}
	
	@Override
	public String toString() {
		return "Cabina [codiceCabina=" + codiceCabina + ", posizione=" + posizione + ", quadri=" + quadri + "]";
	}
	
}