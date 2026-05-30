package com.arvedi.controller;

import com.arvedi.model.Cabina;
import com.arvedi.model.Controllo;
import com.arvedi.model.Esterno;
import com.arvedi.model.Intervento;
import com.arvedi.model.Quadro;
import com.arvedi.model.Tecnico;
import com.arvedi.model.TipoQuadro;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import com.arvedi.csv_manager.CsvInterventiManager;
import com.arvedi.csv_manager.CsvQuadriManager;
import com.arvedi.csv_manager.CsvTipoQuadriManager;
import com.arvedi.csv_manager.CsvTecniciManager;
import com.arvedi.csv_manager.CsvEsterniManager;
import com.arvedi.csv_manager.CsvCabineManager;
import com.arvedi.csv_manager.CsvControlliManager;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import com.arvedi.view.gui.viewController;

/**
 * This class is the CONTROLLER in the MVC architecture.
 *
 * Responsibilities:
 *  - Receives commands from the Views (CLI or GUI)
 *  - Uses the Model (Counter) to apply the business logic
 *  - Returns updated values back to the View
 *
 * NOTE:
 *  The View must NEVER modify the Model directly.
 *  All interactions with the Model go through the Controller.
 */
public class AppController {
	
	 private ArrayList<Quadro> quadriSelezionabili = new ArrayList<>();
	 private ArrayList<Cabina> cabineSelezionabili = new ArrayList<>();
	 private ArrayList<Controllo> controlliSelezionabili = new ArrayList<>();
	 private ArrayList<Intervento> interventiSelezionabili = new ArrayList<>();
	 private ArrayList<TipoQuadro> tipiquadriSelezionabili = new ArrayList<>();
	 private ArrayList<Tecnico> tecniciSelezionabili = new ArrayList<>();
	 private ArrayList<Esterno> esterniSelezionabili = new ArrayList<>();
	 private ArrayList<Tecnico> personaleSelezionabile = new ArrayList<>();
	    
	    
	 private ArrayList<CheckMenuItem> checkItemsQuadri = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsQuadriView = new ArrayList<>();
     private ArrayList<CheckMenuItem> checkItemsCabine = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsCabineView = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsControlliView = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsInterventiView = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsTipiQuadriView = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsTipiQuadri = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsPersonale = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsTecniciView = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsEsterniView = new ArrayList<>();
	 private ArrayList<CheckMenuItem> checkItemsPersonaleLicenziabile = new ArrayList<>();

     private final Cabina cabina;
     private final Controllo controllo;
     private final Esterno esterno;
     private final Intervento intervento;
     private final Quadro quadro;
     private final Tecnico tecnico;
     private final TipoQuadro tipoquadro;
        

     public AppController(Cabina cabina, Controllo controllo, Esterno esterno, Intervento intervento, Quadro quadro, Tecnico tecnico, TipoQuadro tipoquadro) {
         this.cabina = cabina;
         this.controllo = controllo;
         this.esterno = esterno;
         this.intervento = intervento;
         this.quadro = quadro;
         this.tecnico = tecnico;
         this.tipoquadro = tipoquadro;
     }

     public void generaCabina(String CodiceCabina, String Posizione) {
    	boolean quadroSelezionato = false;
     	for(int i=0; i < checkItemsQuadri.size(); i++) {
     		if(checkItemsQuadri.get(i).isSelected()) {
     			quadroSelezionato = true;
     		}
     	}
     	if (quadroSelezionato && CodiceCabina != null && Posizione != null) {
             
             ArrayList<Quadro> selezionati = new ArrayList<>();
             
             for(int i = 0; i < checkItemsQuadri.size(); i++) {
             	if(checkItemsQuadri.get(i).isSelected()) {
             		selezionati.add(quadriSelezionabili.get(i));
             	}
             }
             Cabina c = new Cabina(CodiceCabina, Posizione, selezionati);
             
             aggiungiCabinaAllaGrafica(c);
             CsvCabineManager.salvaCabine(cabineSelezionabili);
         }
     }
     
     public void generaControllo(String NomeControllo, String DescrizioneControllo) {
    	if(NomeControllo != null && DescrizioneControllo != null) {
    		 
     		Controllo c = new Controllo(NomeControllo, DescrizioneControllo);
     		
     		aggiungiControlloAllaGrafica(c);
             CsvControlliManager.salvaControlli(controlliSelezionabili);
     	}
     }
     
     public void generaEsterno(String nome, String cognome, String azienda) {
    	 if(nome != null && cognome != null && azienda != null) {
   
     		Esterno e = new Esterno(nome, cognome, azienda);
     		
     		aggiungiEsternoAllaGrafica(e);
             CsvEsterniManager.salvaEsterni(esterniSelezionabili);
     	}
     }
     
     public void generaIntervento(int priorita, String CI, String Note, LocalDate d, boolean esitoPositivo) {
    	boolean personaleSelezionato = false;
     	int cabineSelezionate = 0;
     	for(int i=0; i < checkItemsCabine.size(); i++) {
     		if(checkItemsCabine.get(i).isSelected()) {
     			cabineSelezionate++;
     		}
     	}
     	for(int i=0; i < checkItemsPersonale.size(); i++) {
         	if(checkItemsPersonale.get(i).isSelected()) {
         		personaleSelezionato = true;
         	}
     	}
     	if (personaleSelezionato && cabineSelezionate == 1 && priorita != 0 && CI != null && d != null) {
             Cabina cabinaSelezionata = null;
             ArrayList<Tecnico> personaleSelezionatoList = new ArrayList<>();
             
             for(int i = 0; i < checkItemsPersonale.size(); i++) {
             	if(checkItemsPersonale.get(i).isSelected()) {
             		personaleSelezionatoList.add(personaleSelezionabile.get(i));
             	}
             }
             for(int i = 0; i < checkItemsCabine.size(); i++) {
             	if(checkItemsCabine.get(i).isSelected()) {
             		cabinaSelezionata = cabineSelezionabili.get(i);
             	}
             }
             Intervento I = new Intervento(cabinaSelezionata, CI, personaleSelezionatoList, d, Note, esitoPositivo, priorita);
             
             aggiungiInterventoAllaGrafica(I);
             CsvInterventiManager.salvaInterventi(interventiSelezionabili);
         }
     }
     
     public void generaQuadro(String CQ) {
    	int TQselezionati = 0;
     	for(int i=0; i < checkItemsTipiQuadri.size(); i++) {
     		if(checkItemsTipiQuadri.get(i).isSelected()) {
     			TQselezionati++;
     		}
     	}
     	
     	if(TQselezionati == 1 && CQ != null) {
     		TipoQuadro TQ = null;
     		
     		for(int i = 0; i < checkItemsTipiQuadri.size(); i++) {
             	if(checkItemsTipiQuadri.get(i).isSelected()) {
             		TQ = tipiquadriSelezionabili.get(i);
             	}
             }
     		
     		Quadro q = new Quadro(TQ, CQ);
     		
     		aggiungiQuadroAllaGrafica(q);
             CsvQuadriManager.salvaQuadri(quadriSelezionabili);
     	}
     }
     
     public void generaTecnicoInterno(String nome, String cognome) {
    	 if(nome != null && cognome != null) {
     		Tecnico t = new Tecnico(nome, cognome);
     		
     		aggiungiTecnicoAllaGrafica(t);
             CsvTecniciManager.salvaTecnici(tecniciSelezionabili);
     	}
     }
     
     public void generaTipoQuadro(String nome, String descrizione) {
    	 if(nome != null && descrizione != null) {
     		TipoQuadro tq = new TipoQuadro(nome, descrizione);
     		
     		aggiungiTipoQuadroAllaGrafica(tq);
             CsvTipoQuadriManager.salvaTipoQuadri(tipiquadriSelezionabili);
     	}
     }
     
     
     
}