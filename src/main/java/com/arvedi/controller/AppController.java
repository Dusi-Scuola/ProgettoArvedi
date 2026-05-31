package com.arvedi.controller;

import com.arvedi.model.Cabina;
import com.arvedi.model.Controllo;
import com.arvedi.model.Esterno;
import com.arvedi.model.Intervento;
import com.arvedi.model.Quadro;
import com.arvedi.model.Tecnico;
import com.arvedi.model.TipoQuadro;

import javafx.fxml.FXML;
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
import java.io.IOException;
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

	 private final viewController viewController;
	 
     public AppController(viewController viewController) {
         this.viewController = viewController;
     }

     public void generaCabina(String CodiceCabina, String Posizione) throws IOException {
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
             
             viewController.aggiungiCabinaAllaGraficaCollegamento(c);
             CsvCabineManager.salvaCabine(cabineSelezionabili);
         }
     }
     
     public void generaControllo(String NomeControllo, String DescrizioneControllo) throws IOException {
    	if(NomeControllo != null && DescrizioneControllo != null) {
    		 
     		Controllo c = new Controllo(NomeControllo, DescrizioneControllo);
     		
     		viewController.aggiungiControlloAllaGraficaCollegamento(c);
            CsvControlliManager.salvaControlli(controlliSelezionabili);
     	}
     }
     
     public void generaEsterno(String nome, String cognome, String azienda) throws IOException {
    	 if(nome != null && cognome != null && azienda != null) {
   
     		Esterno e = new Esterno(nome, cognome, azienda);
     		
     		viewController.aggiungiEsternoAllaGraficaCollegamento(e);
            CsvEsterniManager.salvaEsterni(esterniSelezionabili);
     	}
     }
     
     public void generaIntervento(int priorita, String CI, String Note, LocalDate d, boolean esitoPositivo) throws IOException {
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
             
             viewController.aggiungiInterventoAllaGraficaCollegamento(I);
             CsvInterventiManager.salvaInterventi(interventiSelezionabili);
         }
     }
     
     public void generaQuadro(String CQ) throws IOException {
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
     		
     		viewController.aggiungiQuadroAllaGraficaCollegamento(q);
            CsvQuadriManager.salvaQuadri(quadriSelezionabili);
     	}
     }
     
     public void generaTecnicoInterno(String nome, String cognome) throws IOException {
    	 if(nome != null && cognome != null) {
     		Tecnico t = new Tecnico(nome, cognome);
     		
     		viewController.aggiungiTecnicoAllaGraficaCollegamento(t);
            CsvTecniciManager.salvaTecnici(tecniciSelezionabili);
     	}
     }
     
     public void generaTipoQuadro(String nome, String descrizione) throws IOException {
    	 if(nome != null && descrizione != null) {
     		TipoQuadro tq = new TipoQuadro(nome, descrizione);
     		
     		viewController.aggiungiTipoQuadroAllaGraficaCollegamento(tq);
            CsvTipoQuadriManager.salvaTipoQuadri(tipiquadriSelezionabili);
     	}
     }
     
     public String viewCabina() {
    	int cabineSelezionate=0;
    	String view = "Seleziona 1 cabina";
     	Cabina cabinaTemporanea;
     	for(int i=0; i < checkItemsCabineView.size(); i++) {
     		if(checkItemsCabineView.get(i).isSelected()) {
     			cabineSelezionate++;
     		}
     	}
     	if(cabineSelezionate == 1) {
     		for(int i = 0; i < checkItemsCabineView.size(); i++) {
             	if(checkItemsCabineView.get(i).isSelected()) {
             		cabinaTemporanea = cabineSelezionabili.get(i);
             		view = cabinaTemporanea.toString();             	
             	}
             }
     	}
     	return view;
     }
     
     public String viewControllo() {
    	int controlliSelezionati=0;
     	String view = "Seleziona 1 controllo";
    	Controllo controlloTemporaneo;
     	for(int i=0; i < checkItemsControlliView.size(); i++) {
     		if(checkItemsControlliView.get(i).isSelected()) {
     			controlliSelezionati++;
     		}
     	}
     	if(controlliSelezionati == 1) {
     		for(int i = 0; i < checkItemsControlliView.size(); i++) {
             	if(checkItemsControlliView.get(i).isSelected()) {
             		controlloTemporaneo = controlliSelezionabili.get(i);
             		view = controlloTemporaneo.toString();
             	}
             }
     	}
     	return view;
     }
     
     public String viewEsterno() {
    	int esterniSelezionati=0;
    	String view = "Seleziona 1 tecnico esterno";
     	Esterno esternoTemporaneo;
     	for(int i=0; i < checkItemsEsterniView.size(); i++) {
     		if(checkItemsEsterniView.get(i).isSelected()) {
     			esterniSelezionati++;
     		}
     	}
     	if(esterniSelezionati == 1) {
     		for(int i = 0; i < checkItemsEsterniView.size(); i++) {
             	if(checkItemsEsterniView.get(i).isSelected()) {
             		esternoTemporaneo = esterniSelezionabili.get(i);
             		view = esternoTemporaneo.toString();
             	}
             }
     	}
     	return view;
     }
     
     public String viewIntervento() {
    	int interventiSelezionati=0;
    	String view = "Seleziona 1 intervento";
     	Intervento interventoTemporaneo;
     	for(int i=0; i < checkItemsInterventiView.size(); i++) {
     		if(checkItemsInterventiView.get(i).isSelected()) {
     			interventiSelezionati++;
     		}
     	}
     	if(interventiSelezionati == 1) {
     		for(int i = 0; i < checkItemsInterventiView.size(); i++) {
             	if(checkItemsInterventiView.get(i).isSelected()) {
             		interventoTemporaneo = interventiSelezionabili.get(i);
             		view = interventoTemporaneo.toString();
             	}
             }
     	}
     	return view;
     }
     
     public String viewQuadro() {
    	int quadriSelezionati=0;
    	String view = "Seleziona 1 quadro";
     	Quadro quadroTemporaneo;
     	for(int i=0; i < checkItemsQuadriView.size(); i++) {
     		if(checkItemsQuadriView.get(i).isSelected()) {
     			quadriSelezionati++;
     		}
     	}
     	if(quadriSelezionati == 1) {
     		for(int i = 0; i < checkItemsQuadriView.size(); i++) {
             	if(checkItemsQuadriView.get(i).isSelected()) {
             		quadroTemporaneo = quadriSelezionabili.get(i);
             		view = quadroTemporaneo.toString();
             	}
             }
     	}
     	return view;
     }
     
     public String viewTecnico() {
    	int tecniciSelezionati=0;
    	String view = "seleziona 1 tecnico";
     	Tecnico tecnicoTemporaneo;
     	for(int i=0; i < checkItemsTecniciView.size(); i++) {
     		if(checkItemsTecniciView.get(i).isSelected()) {
     			tecniciSelezionati++;
     		}
     	}
     	if(tecniciSelezionati == 1) {
     		for(int i = 0; i < checkItemsTecniciView.size(); i++) {
             	if(checkItemsTecniciView.get(i).isSelected()) {
             		tecnicoTemporaneo = tecniciSelezionabili.get(i);
             		view = tecnicoTemporaneo.toString();
             	}
             }
     	}
     	return view;
     }
     
     public String viewTipoQuadro() {
    	int tqSelezionati=0;
    	String view = "Seleziona 1 tipologia di quadro";
     	TipoQuadro tqTemporaneo;
     	for(int i=0; i < checkItemsTecniciView.size(); i++) {
     		if(checkItemsTecniciView.get(i).isSelected()) {
     			tqSelezionati++;
     		}
     	}
     	if(tqSelezionati == 1) {
     		for(int i = 0; i < checkItemsTipiQuadriView.size(); i++) {
             	if(checkItemsTipiQuadriView.get(i).isSelected()) {
             		tqTemporaneo = tipiquadriSelezionabili.get(i);
             		view = tqTemporaneo.toString();
             	}
             }
     	}
     	return view;
     }
     
     public ArrayList<Integer> Licenzia() throws IOException {
    	ArrayList<Integer> index = new ArrayList<>();
    	for(int i = 0; i < checkItemsPersonaleLicenziabile.size(); i++) {

            if(checkItemsPersonaleLicenziabile.get(i).isSelected()) {

               Tecnico personaDaRimuovere = personaleSelezionabile.get(i);
               personaleSelezionabile.remove(personaDaRimuovere);
                 
               if(personaDaRimuovere.getClass() == Tecnico.class) {

                  tecniciSelezionabili.remove(personaDaRimuovere);
                  CsvTecniciManager.salvaTecnici(tecniciSelezionabili);
                     
               }

               if(personaDaRimuovere.getClass() == Esterno.class) {

                  esterniSelezionabili.remove(personaDaRimuovere);
                  CsvEsterniManager.salvaEsterni(esterniSelezionabili);
                     
               }
                 
               checkItemsPersonale.remove(i);
               checkItemsPersonaleLicenziabile.remove(i);
               index.add(i);
               i--;
                 
            }
        }
    	return index;
     }
     
     public void ricostruisciListePersonale() {
    	 
         checkItemsPersonale.clear();
         checkItemsTecniciView.clear();
         checkItemsEsterniView.clear();
         checkItemsPersonaleLicenziabile.clear();
         personaleSelezionabile.clear();
         
         ArrayList<Tecnico> tecSelTemp = new ArrayList<>(tecniciSelezionabili);
         ArrayList<Esterno> estSelTemp = new ArrayList<>(esterniSelezionabili);
         tecniciSelezionabili.clear();
         esterniSelezionabili.clear();

         for (Tecnico t : tecSelTemp) {
             aggiungiTecnicoAllaGrafica(t);
         }

         for (Esterno e : estSelTemp) {
             aggiungiEsternoAllaGrafica(e);
         }
     }
     
     public ArrayList<CheckMenuItem> aggiungiQuadroAllaGrafica(Quadro q) {
         CheckMenuItem check = new CheckMenuItem(q.getTipologia().getNome() + " " + q.getCodiceQuadro());
         CheckMenuItem checkView = new CheckMenuItem(q.getTipologia().getNome() + " " + q.getCodiceQuadro());

         ArrayList<CheckMenuItem> checks = new ArrayList<>();
         checks.add(check);
         checks.add(checkView);
         
         checkItemsQuadri.add(check);
         checkItemsQuadriView.add(checkView);

         quadriSelezionabili.add(q);
         return checks;
     }

     public ArrayList<CheckMenuItem> aggiungiCabinaAllaGrafica(Cabina c) {
         CheckMenuItem check = new CheckMenuItem(c.getCodiceCabina());
         CheckMenuItem checkView = new CheckMenuItem(c.getCodiceCabina());
         
         ArrayList<CheckMenuItem> checks = new ArrayList<>();
         checks.add(check);
         checks.add(checkView);

         checkItemsCabine.add(check);
         checkItemsCabineView.add(checkView);

         cabineSelezionabili.add(c);
         return checks;
     }

     public ArrayList<CheckMenuItem> aggiungiTecnicoAllaGrafica(Tecnico t) {
         CheckMenuItem check = new CheckMenuItem(t.getNome() + " " + t.getCognome() + " Arvedi");
         CheckMenuItem checkView = new CheckMenuItem(t.getNome() + " " + t.getCognome() + " Arvedi");
         CheckMenuItem checkLicenzia = new CheckMenuItem(t.getNome() + " " + t.getCognome() + " Arvedi");
         
         ArrayList<CheckMenuItem> checks = new ArrayList<>();
         checks.add(check);
         checks.add(checkView);
         checks.add(checkLicenzia);

         checkItemsPersonale.add(check);
         checkItemsTecniciView.add(checkView);
         checkItemsPersonaleLicenziabile.add(checkLicenzia);

         tecniciSelezionabili.add(t);
         personaleSelezionabile.add(t);
         return checks;
     }

     public ArrayList<CheckMenuItem> aggiungiEsternoAllaGrafica(Esterno e) {
         CheckMenuItem check = new CheckMenuItem(e.getNome() + " " + e.getCognome() + " " + e.getAzienda());
         CheckMenuItem checkView = new CheckMenuItem(e.getNome() + " " + e.getCognome() + " " + e.getAzienda());
         CheckMenuItem checkLicenzia = new CheckMenuItem(e.getNome() + " " + e.getCognome() + " " + e.getAzienda());
         
         ArrayList<CheckMenuItem> checks = new ArrayList<>();
         checks.add(check);
         checks.add(checkView);
         checks.add(checkLicenzia);

         checkItemsPersonale.add(check);
         checkItemsEsterniView.add(checkView);
         checkItemsPersonaleLicenziabile.add(checkLicenzia);

         esterniSelezionabili.add(e);
         personaleSelezionabile.add(e);
         return checks;
     }

     public CheckMenuItem aggiungiControlloAllaGrafica(Controllo c) {
         CheckMenuItem checkView = new CheckMenuItem(c.getNome());

         checkItemsControlliView.add(checkView);

         controlliSelezionabili.add(c);
         return checkView;
     }

     public ArrayList<CheckMenuItem> aggiungiTipoQuadroAllaGrafica(TipoQuadro tq) {
         CheckMenuItem checkView = new CheckMenuItem(tq.getNome());
         CheckMenuItem check = new CheckMenuItem(tq.getNome());
         
         ArrayList<CheckMenuItem> checks = new ArrayList<>();
         checks.add(checkView);
         checkItemsTipiQuadriView.add(checkView);
         checks.add(check);
         checkItemsTipiQuadri.add(check);

         tipiquadriSelezionabili.add(tq);
         return checks;
     }

     public CheckMenuItem aggiungiInterventoAllaGrafica(Intervento I) {
         CheckMenuItem checkView = new CheckMenuItem(I.getCodiceIntervento());

         checkItemsInterventiView.add(checkView);

         interventiSelezionabili.add(I);
         return checkView;
     }
     
}