package com.arvedi.view.gui;

import com.arvedi.controller.AppController;

import java.time.LocalDate;

import com.arvedi.model.Cabina;
import com.arvedi.model.Controllo;
import com.arvedi.model.Esterno;
import com.arvedi.model.Intervento;
import com.arvedi.model.Quadro;
import com.arvedi.model.Tecnico;
import com.arvedi.model.TipoQuadro;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class viewController {
	
	private final AppController controller;
	
	public viewController(AppController controller) {
        this.controller = controller;
    }
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTipoQuadro;

    @FXML
    private Button btnLicenziaEsterno;

    @FXML
    private Button btnLicenziaInterno;
    
    @FXML
    private MenuButton listLicenziaEsterni;

    @FXML
    private MenuButton listLicenziaInterni;
    
    @FXML
    private TextField txtCodiceQuadro;

    @FXML
    private Button btnTecnicoEsterno;

    @FXML
    private MenuButton listQuadri;

    @FXML
    private TextField txtCodiceCabina;

    @FXML
    private TextField txtPosizione;

    @FXML
    private Button btnCabina;
    
    @FXML
    private DatePicker dateData;

    @FXML
    private TextField txtNomeTecnico;

    @FXML
    private TextField txtCognomeTecnico;

    @FXML
    private Button btnTecnicoInterno;

    @FXML
    private TextField txtNomeEsterno;

    @FXML
    private TextField txtCognomeEsterno;

    @FXML
    private TextField txtAziendaEsterno;

    @FXML
    private Button btnQuadro;

    @FXML
    private TextField txtNomeTipo;

    @FXML
    private TextField txtDescrizioneTipo;

    @FXML
    private Button btnTipologiaQuadro;

    @FXML
    private TextField txtDescrizioneControllo;

    @FXML
    private TextField txtNomeControllo;

    @FXML
    private Button btnControllo;

    @FXML
    private TextField txtPriorita;

    @FXML
    private TextField txtCodiceIntervento;

    @FXML
    private TextField txtNote;

    @FXML
    private MenuButton listCabina;

    @FXML
    private MenuButton listPersonale;

    @FXML
    private RadioButton radPositivo;

    @FXML
    private ToggleGroup esito;

    @FXML
    private RadioButton radNegativo;

    @FXML
    private Button btnIntervento;

    @FXML
    private TextArea txtVisualizzaQuadro;

    @FXML
    private Button btnVisualizzaEsterno;

    @FXML
    private TextArea txtVisualizzaCabina;

    @FXML
    private Button btnVisualizzaCabina;

    @FXML
    private TextArea txtVisualizzaTecnico;

    @FXML
    private Button btnVisualizzaTecnico;

    @FXML
    private TextArea txtVisualizzaEsterno;

    @FXML
    private Button btnVisualizzaQuadro;

    @FXML
    private TextArea txtVisualizzaTipoQuadro;

    @FXML
    private Button btnVisualizzaTipoQuadro;

    @FXML
    private Button btnVisualizzaControllo;

    @FXML
    private TextArea txtVisualizzaIntervento;

    @FXML
    private Button btnVisualizzaIntervento;

    @FXML
    private TextArea txtVisualizzaControllo;

    @FXML
    private MenuButton listQuadri1;

    @FXML
    private MenuButton listCabine1;

    @FXML
    private MenuButton listTecnici;

    @FXML
    private MenuButton listEsterni;

    @FXML
    private MenuButton listTipoQuadri;

    @FXML
    private MenuButton listControlli;

    @FXML
    private MenuButton listInterventi;
    
    private ArrayList<Quadro> quadriSelezionabili = new ArrayList<>();
    private ArrayList<Cabina> cabineSelezionabili = new ArrayList<>();
    private ArrayList<Controllo> controlliSelezionabili = new ArrayList<>();
    private ArrayList<Intervento> interventiSelezionabili = new ArrayList<>();
    private ArrayList<TipoQuadro> tipiquadriSelezionabili = new ArrayList<>();
    private ArrayList<Tecnico> tecniciSelezionabili = new ArrayList<>();
    private ArrayList<Esterno> esterniSelezionabili = new ArrayList<>();
    private ArrayList<Esterno> personaleSelezionabile = new ArrayList<>();
    
    
    private ArrayList<CheckMenuItem> checkItemsQuadri = new ArrayList<>();
    private ArrayList<CheckMenuItem> checkItemsQuadriView = new ArrayList<>();
    private ArrayList<CheckMenuItem> checkItemsCabine = new ArrayList<>();
    private ArrayList<CheckMenuItem> checkItemsCabineView = new ArrayList<>();
    private ArrayList<CheckMenuItem> checkItemsControlliView = new ArrayList<>();
    private ArrayList<CheckMenuItem> checkItemsInterventiView = new ArrayList<>();
    private ArrayList<CheckMenuItem> checkItemsTipiQuadriView = new ArrayList<>();
    private ArrayList<CheckMenuItem> checkItemsPersonale = new ArrayList<>();
    private ArrayList<CheckMenuItem> checkItemsTecniciView = new ArrayList<>();
    private ArrayList<CheckMenuItem> checkItemsEsterniView = new ArrayList<>();
    private ArrayList<CheckMenuItem> esterniLicenziabili = new ArrayList<>();
    private ArrayList<CheckMenuItem> interniLicenziabili = new ArrayList<>();
    
    @FXML
    void CreaCabina(ActionEvent event) {
    	boolean quadroSelezionato = false;
    	for(int i=0; i < checkItemsQuadri.size(); i++) {
    		if(checkItemsQuadri.get(i).isSelected()) {
    			quadroSelezionato = true;
    		}
    	}
    	if (quadroSelezionato && txtCodiceCabina.getText() != null && txtPosizione.getText() != null) {
    		String CC = txtCodiceCabina.getText();
            String P = txtPosizione.getText();
            
            ArrayList<Quadro> selezionati = new ArrayList<>();
            
            for(int i = 0; i < checkItemsQuadri.size(); i++) {
            	if(checkItemsQuadri.get(i).isSelected()) {
            		selezionati.add(quadriSelezionabili.get(i));
            	}
            }
            Cabina c = new Cabina(CC, P, selezionati);
            
            CheckMenuItem check = new CheckMenuItem(c.getCodiceCabina());
    		CheckMenuItem checkView = new CheckMenuItem(c.getCodiceCabina());
    		listCabina.getItems().add(check);
    		listCabine1.getItems().add(checkView);
    		checkItemsCabine.add(check);
    		checkItemsCabineView.add(checkView);
    		cabineSelezionabili.add(c);
        }
    }

    @FXML
    void CreaControllo(ActionEvent event) {
    	if(txtNomeTipo.getText() != null && txtDescrizioneTipo.getText() != null) {
    		String nome = txtNomeTipo.getText();
    		String descrizione = txtDescrizioneTipo.getText();
    		Controllo c = new Controllo(nome, descrizione);
    		
    		CheckMenuItem checkView = new CheckMenuItem(c.getNome());
    		listControlli.getItems().add(checkView);
    		checkItemsControlliView.add(checkView);
    		controlliSelezionabili.add(c);
    	}
    }

    @FXML
    void CreaEsterno(ActionEvent event) {
    	if(txtNomeEsterno.getText() != null && txtCognomeEsterno.getText() != null && txtAziendaEsterno.getText() != null) {
    		String nome = txtNomeEsterno.getText();
    		String cognome = txtCognomeEsterno.getText();
    		String azienda = txtAziendaEsterno.getText();
    		Esterno e = new Esterno(nome, cognome, azienda);
    		
    		CheckMenuItem check = new CheckMenuItem(e.getNome() + " " + e.getCognome());
    		CheckMenuItem checkView = new CheckMenuItem(e.getNome() + " " + e.getCognome());
    		CheckMenuItem checkLicenzia = new CheckMenuItem(e.getNome() + " " + e.getCognome());
    		listPersonale.getItems().add(check);
    		listEsterni.getItems().add(checkView);
    		listLicenziaEsterni.getItems().add(checkLicenzia);
    		checkItemsPersonale.add(check);
    		checkItemsEsterniView.add(checkView);
    		esterniSelezionabili.add(e);
    		personaleSelezionabile.add(e);
    		esterniLicenziabili.add(e);
    	}
    }

    @FXML
    void CreaIntervento(ActionEvent event) {
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
    	if (personaleSelezionato && cabineSelezionate == 1 && txtPriorita.getText() != null && txtCodiceIntervento.getText() != null && dateData.getValue() != null) {
    		int priorita = Integer.parseInt(txtPriorita.getText());
            String CI = txtCodiceIntervento.getText();
            String Note = txtNote.getText();
            Cabina cabinaSelezionata = null;
            ArrayList<Tecnico> personaleSelezionatoList = new ArrayList<>();
            LocalDate d = dateData.getValue();
            boolean esitoPositivo = radPositivo.isSelected();
            
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
            
    		CheckMenuItem checkView = new CheckMenuItem(I.getCodiceIntervento());
    		listInterventi.getItems().add(checkView);
    		checkItemsInterventiView.add(checkView);
    		interventiSelezionabili.add(I);
        }
    }

    @FXML
    void CreaQuadro(ActionEvent event) {
    	if(txtTipoQuadro.getText() != null && txtCodiceQuadro.getText() != null) {
    		String TQ = txtTipoQuadro.getText();
    		String CQ = txtCodiceQuadro.getText();
    		Quadro q = new Quadro(TQ, CQ);
    		
    		CheckMenuItem check = new CheckMenuItem(q.getCodiceQuadro());
    		CheckMenuItem checkView = new CheckMenuItem(q.getCodiceQuadro());
    		listQuadri.getItems().add(check);
    		listQuadri1.getItems().add(checkView);
    		checkItemsQuadri.add(check);
    		checkItemsQuadriView.add(checkView);
    		quadriSelezionabili.add(q);
    	}
    }

    @FXML
    void CreaTecnicoInterno(ActionEvent event) {
    	if(txtNomeTecnico.getText() != null && txtCognomeTecnico.getText() != null) {
    		String nome = txtNomeTecnico.getText();
    		String cognome = txtCognomeTecnico.getText();
    		Tecnico t = new Tecnico(nome, cognome);
    		
    		CheckMenuItem check = new CheckMenuItem(t.getNome() + " " + t.getCognome());
    		CheckMenuItem checkView = new CheckMenuItem(t.getNome() + " " + t.getCognome());
    		CheckMenuItem checkLicenzia = new CheckMenuItem(t.getNome() + " " + t.getCognome());
    		listPersonale.getItems().add(check);
    		listTecnici.getItems().add(checkView);
    		checkItemsPersonale.add(check);
    		checkItemsTecniciView.add(checkView);
    		tecniciSelezionabili.add(t);
    		interniLicenziabili.add(checkLicenzia);
    	}
    }

    @FXML
    void CreaTipoQuadro(ActionEvent event) {
    	if(txtNomeTipo.getText() != null && txtDescrizioneTipo.getText() != null) {
    		String nome = txtNomeTipo.getText();
    		String descrizione = txtDescrizioneTipo.getText();
    		TipoQuadro tq = new TipoQuadro(nome, descrizione);
    		
    		CheckMenuItem checkView = new CheckMenuItem(tq.getNome());
    		listTipoQuadri.getItems().add(checkView);
    		checkItemsTipiQuadriView.add(checkView);
    		tipiquadriSelezionabili.add(tq);
    	}
    }

    @FXML
    void VisualizzaCabina(ActionEvent event) {
    	int cabineSelezionate=0;
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
            		txtVisualizzaCabina.setText(cabinaTemporanea.toString());
            	}
            }
    	}
    }

    @FXML
    void VisualizzaControllo(ActionEvent event) {
    	int controlliSelezionati=0;
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
            		txtVisualizzaControllo.setText(controlloTemporaneo.toString());
            	}
            }
    	}
    }

    @FXML
    void VisualizzaEsterno(ActionEvent event) {
    	int esterniSelezionati=0;
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
            		txtVisualizzaEsterno.setText(esternoTemporaneo.toString());
            	}
            }
    	}
    }

    @FXML
    void VisualizzaIntervento(ActionEvent event) {
    	int interventiSelezionati=0;
    	Esterno interventoTemporaneo;
    	for(int i=0; i < checkItemsInterventiView.size(); i++) {
    		if(checkItemsInterventiView.get(i).isSelected()) {
    			interventiSelezionati++;
    		}
    	}
    	if(interventiSelezionati == 1) {
    		for(int i = 0; i < checkItemsInterventiView.size(); i++) {
            	if(checkItemsInterventiView.get(i).isSelected()) {
            		interventoTemporaneo = esterniSelezionabili.get(i);
            		txtVisualizzaIntervento.setText(interventoTemporaneo.toString());
            	}
            }
    	}
    }

    @FXML
    void VisualizzaQuadro(ActionEvent event) {
    	int quadriSelezionati=0;
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
            		txtVisualizzaQuadro.setText(quadroTemporaneo.toString());
            	}
            }
    	}
    }

    @FXML
    void VisualizzaTecnico(ActionEvent event) {
    	int tecniciSelezionati=0;
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
            		txtVisualizzaTecnico.setText(tecnicoTemporaneo.toString());
            	}
            }
    	}
    }

    @FXML
    void VisualizzaTipoQuadro(ActionEvent event) {
    	int tqSelezionati=0;
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
            		txtVisualizzaTipoQuadro.setText(tqTemporaneo.toString());
            	}
            }
    	}
    }
    
    @FXML
    void LicenziaEsterno(ActionEvent event) {

    }

    @FXML
    void LicenziaInterno(ActionEvent event) {

    }

    
    @FXML
    void initialize() {
        assert txtTipoQuadro != null : "fx:id=\"txtTipoQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCodiceQuadro != null : "fx:id=\"txtCodiceQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert btnTecnicoEsterno != null : "fx:id=\"btnTecnicoEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert listQuadri != null : "fx:id=\"listQuadri\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCodiceCabina != null : "fx:id=\"txtCodiceCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert txtPosizione != null : "fx:id=\"txtPosizione\" was not injected: check your FXML file 'view.fxml'.";
        assert btnCabina != null : "fx:id=\"btnCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNomeTecnico != null : "fx:id=\"txtNomeTecnico\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCognomeTecnico != null : "fx:id=\"txtCognomeTecnico\" was not injected: check your FXML file 'view.fxml'.";
        assert btnTecnicoInterno != null : "fx:id=\"btnTecnicoInterno\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNomeEsterno != null : "fx:id=\"txtNomeEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCognomeEsterno != null : "fx:id=\"txtCognomeEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert txtAziendaEsterno != null : "fx:id=\"txtAziendaEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert btnQuadro != null : "fx:id=\"btnQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNomeTipo != null : "fx:id=\"txtNomeTipo\" was not injected: check your FXML file 'view.fxml'.";
        assert txtDescrizioneTipo != null : "fx:id=\"txtDescrizioneTipo\" was not injected: check your FXML file 'view.fxml'.";
        assert btnTipologiaQuadro != null : "fx:id=\"btnTipologiaQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert txtDescrizioneControllo != null : "fx:id=\"txtDescrizioneControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNomeControllo != null : "fx:id=\"txtNomeControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert btnControllo != null : "fx:id=\"btnControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert dateData != null : "fx:id=\"dateData\" was not injected: check your FXML file 'view.fxml'.";
        assert txtPriorita != null : "fx:id=\"txtPriorita\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCodiceIntervento != null : "fx:id=\"txtCodiceIntervento\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNote != null : "fx:id=\"txtNote\" was not injected: check your FXML file 'view.fxml'.";
        assert listCabina != null : "fx:id=\"listCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert listPersonale != null : "fx:id=\"listPersonale\" was not injected: check your FXML file 'view.fxml'.";
        assert radPositivo != null : "fx:id=\"radPositivo\" was not injected: check your FXML file 'view.fxml'.";
        assert esito != null : "fx:id=\"esito\" was not injected: check your FXML file 'view.fxml'.";
        assert radNegativo != null : "fx:id=\"radNegativo\" was not injected: check your FXML file 'view.fxml'.";
        assert btnIntervento != null : "fx:id=\"btnIntervento\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaQuadro != null : "fx:id=\"txtVisualizzaQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaEsterno != null : "fx:id=\"btnVisualizzaEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaCabina != null : "fx:id=\"txtVisualizzaCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaCabina != null : "fx:id=\"btnVisualizzaCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaTecnico != null : "fx:id=\"txtVisualizzaTecnico\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaTecnico != null : "fx:id=\"btnVisualizzaTecnico\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaEsterno != null : "fx:id=\"txtVisualizzaEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaQuadro != null : "fx:id=\"btnVisualizzaQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaTipoQuadro != null : "fx:id=\"txtVisualizzaTipoQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaTipoQuadro != null : "fx:id=\"btnVisualizzaTipoQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaControllo != null : "fx:id=\"btnVisualizzaControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaIntervento != null : "fx:id=\"txtVisualizzaIntervento\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaIntervento != null : "fx:id=\"btnVisualizzaIntervento\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaControllo != null : "fx:id=\"txtVisualizzaControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert listQuadri1 != null : "fx:id=\"listQuadri1\" was not injected: check your FXML file 'view.fxml'.";
        assert listCabine1 != null : "fx:id=\"listCabine1\" was not injected: check your FXML file 'view.fxml'.";
        assert listTecnici != null : "fx:id=\"listTecnici\" was not injected: check your FXML file 'view.fxml'.";
        assert listEsterni != null : "fx:id=\"listEsterni\" was not injected: check your FXML file 'view.fxml'.";
        assert listTipoQuadri != null : "fx:id=\"listTipoQuadri\" was not injected: check your FXML file 'view.fxml'.";
        assert listControlli != null : "fx:id=\"listControlli\" was not injected: check your FXML file 'view.fxml'.";
        assert listInterventi != null : "fx:id=\"listInterventi\" was not injected: check your FXML file 'view.fxml'.";
        assert listLicenziaEsterni != null : "fx:id=\"listLicenziaEsterni\" was not injected: check your FXML file 'view.fxml'.";
        assert listLicenziaInterni != null : "fx:id=\"listLicenziaInterni\" was not injected: check your FXML file 'view.fxml'.";
        assert btnLicenziaEsterno != null : "fx:id=\"btnLicenziaEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert btnLicenziaInterno != null : "fx:id=\"btnLicenziaInterno\" was not injected: check your FXML file 'view.fxml'.";

    }
}
