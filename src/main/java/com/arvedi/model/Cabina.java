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
	private String CodiceCabina;
	private String Posizione;
	private ArrayList<Quadro> Quadri = new ArrayList<Quadro>();
	
	 public Cabina(String CodiceCabina, String Posizione, ArrayList<Quadro>) {
	        this.CodiceCabina = CodiceCabina;
	        this.Posizione = Posizione;
	        this.Quadri = ArrayList<Quadro>;
	        }
	 
	 public String getCodiceCabina() {
			return CodiceCabina;
		}
	 
	 public void CodiceCabina(String CodiceCabina) {
			this.CodiceCabina = CodiceCabina;
		}
	 
	 public String getPosizione() {
			return Posizione;
		}
	 
	 public void setPosizione(String Posizione) {
			this.Posizione = Posizione;
		}
	 
	 public Quadro Quadri () {
			return Quadri;
		}
	 
	 public void addQuadri(Quadro a) {
			Quadri.add(Quadro);
		}
}