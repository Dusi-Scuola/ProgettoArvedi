package com.arvedi.model;
import java.util.ArrayList;
import java.time.LocalDate;

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
public class Intervento{
	
	private Cabina cabinaSelezionata;
	private String codiceIntervento;
	private ArrayList<Tecnico> personale;
	private LocalDate data;
	private String note;
	private boolean esito;
	private int priorita;
	
	public Intervento(Cabina cabinaSelezionata, String codiceIntervento, LocalDate data, String note, boolean esito, int priorita) {
        this.cabinaSelezionata = cabinaSelezionata;
        this.codiceIntervento = codiceIntervento;
        this.data = data;
        this.note = note;
        this.esito = esito;
        this.priorita = priorita;
        ArrayList<Tecnico> personale = new ArrayList<Tecnico>();
        }

	public String getCodiceIntervento() {
		return codiceIntervento;
	}
 
	public void setCodiceIntervento(String codiceIntervento) {
		this.codiceIntervento = codiceIntervento;
	}
 
	public String getNote() {
		return note;
	}
 
	public void setNote(String note) {
		this.note = note;
	}
	
	public LocalDate getData() {
		return data;
	}
 
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public boolean getEsito() {
		return esito;
	}
 
	public void setEsito(boolean esito) {
		this.esito = esito;
	}
	
	public int getPriorita() {
		return priorita;
	}
 
	public void setPriorita(int priorita) {
		this.priorita = priorita;
	}
 
	public Cabina getCabina () {
		return cabinaSelezionata;
	}
 
	public void addTecnico(Tecnico a) {
		personale.add(a);
	}
}