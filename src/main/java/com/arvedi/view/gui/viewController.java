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

import com.arvedi.csv_manager.CsvInterventiManager;
import com.arvedi.csv_manager.CsvQuadriManager;
import com.arvedi.csv_manager.CsvTipoQuadriManager;
import com.arvedi.csv_manager.CsvTecniciManager;
import com.arvedi.csv_manager.CsvEsterniManager;
import com.arvedi.csv_manager.CsvCabineManager;
import com.arvedi.csv_manager.CsvControlliManager;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;

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
    private BarChart chartInterventiNumero;
    
    @FXML
    private PieChart chartInterventiPercentuale;
    
    @FXML
    private TextArea txtVisualizzaPersonale;
    
    @FXML
    private Button btnVisualizzaAllPersonale;

    @FXML
    private MenuButton listTQ;

    @FXML
    private Button btnLicenzia;
    
    @FXML
    private MenuButton listLicenzia;
    
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
    
    @FXML
    void CreaCabina(ActionEvent event) throws IOException {
    	ArrayList<CheckMenuItem> checks = controller.aggiungiCabinaAllaGrafica(controller.generaCabina(txtCodiceCabina.getText(), txtPosizione.getText()));
        listCabina.getItems().add(checks.get(0));
        listCabine1.getItems().add(checks.get(1));
    }

    @FXML
    void CreaControllo(ActionEvent event) throws IOException {
    	CheckMenuItem checkView = controller.aggiungiControlloAllaGrafica(controller.generaControllo(txtNomeControllo.getText(), txtDescrizioneControllo.getText()));
        listControlli.getItems().add(checkView);
    }

    @FXML
    void CreaEsterno(ActionEvent event) throws IOException {
    	ArrayList<CheckMenuItem> checks = controller.aggiungiEsternoAllaGrafica(controller.generaEsterno(txtNomeEsterno.getText(), txtCognomeEsterno.getText(), txtAziendaEsterno.getText()));
        listPersonale.getItems().add(checks.get(0));
        listEsterni.getItems().add(checks.get(1));
        listLicenzia.getItems().add(checks.get(2));
    }

    @FXML
    void CreaIntervento(ActionEvent event) throws IOException {
    	CheckMenuItem checkView = controller.aggiungiInterventoAllaGrafica(controller.generaIntervento(Integer.parseInt(txtPriorita.getText()), txtCodiceIntervento.getText(), txtNote.getText(), dateData.getValue(), radPositivo.isSelected()));
        listInterventi.getItems().add(checkView);
    }

    @FXML
    void CreaQuadro(ActionEvent event) throws IOException {
    	ArrayList<CheckMenuItem> checks = controller.aggiungiQuadroAllaGrafica(controller.generaQuadro(txtCodiceQuadro.getText()));
        listQuadri.getItems().add(checks.get(0));
        listQuadri1.getItems().add(checks.get(1));
    }

    @FXML
    void CreaTecnicoInterno(ActionEvent event) throws IOException {
    	ArrayList<CheckMenuItem> checks = controller.aggiungiTecnicoAllaGrafica(controller.generaTecnicoInterno(txtNomeTecnico.getText(), txtCognomeTecnico.getText()));
        listPersonale.getItems().add(checks.get(0));
        listTecnici.getItems().add(checks.get(1));
        listLicenzia.getItems().add(checks.get(2));
    }

    @FXML
    void CreaTipoQuadro(ActionEvent event) throws IOException {
    	ArrayList<CheckMenuItem> checks = controller.aggiungiTipoQuadroAllaGrafica(controller.generaTipoQuadro(txtNomeTipo.getText(), txtDescrizioneTipo.getText()));
        listTipoQuadri.getItems().add(checks.get(0));
        listTQ.getItems().add(checks.get(1));
    }

    @FXML
    void VisualizzaAllPersonale(ActionEvent event) {
    	txtVisualizzaPersonale.setText(controller.viewPersonale());
    }
    
    @FXML
    void VisualizzaCabina(ActionEvent event) throws IOException {    	
    	txtVisualizzaCabina.setText(controller.viewCabina());    
    }

    @FXML
    void VisualizzaControllo(ActionEvent event) {
    	txtVisualizzaControllo.setText(controller.viewControllo());
    }

    @FXML
    void VisualizzaEsterno(ActionEvent event) {
    	txtVisualizzaEsterno.setText(controller.viewEsterno());
    }

    @FXML
    void VisualizzaIntervento(ActionEvent event) {
    	txtVisualizzaIntervento.setText(controller.viewIntervento());
    }

    @FXML
    void VisualizzaQuadro(ActionEvent event) {
    	txtVisualizzaQuadro.setText(controller.viewQuadro());
    }

    @FXML
    void VisualizzaTecnico(ActionEvent event) {
    	txtVisualizzaTecnico.setText(controller.viewTecnico());
    }

    @FXML
    void VisualizzaTipoQuadro(ActionEvent event) {
    	txtVisualizzaTipoQuadro.setText(controller.viewTipoQuadro());
    }
    
    @FXML
    void LicenziaTecnico(ActionEvent event) throws IOException {
    	controller.Licenzia();
    	ricostruisciListePersonaleCollegamento();
    }
    
    public void ricostruisciListePersonaleCollegamento() {
    	listPersonale.getItems().clear();
        listTecnici.getItems().clear();
        listEsterni.getItems().clear();
        listLicenzia.getItems().clear();
        
        ArrayList<Tecnico> tecnici = new ArrayList<>(controller.getTecniciSelezionabili());
        ArrayList<Esterno> esterni = new ArrayList<>(controller.getEsterniSelezionabili());
        
        controller.ricostruisciListePersonale();
        
        for (Tecnico t : tecnici) {
        	ArrayList<CheckMenuItem> checks = controller.aggiungiTecnicoAllaGrafica(t);
            listPersonale.getItems().add(checks.get(0));
            listTecnici.getItems().add(checks.get(1));
            listLicenzia.getItems().add(checks.get(2));
        }

        for (Esterno e : esterni) {
        	ArrayList<CheckMenuItem> checks = controller.aggiungiEsternoAllaGrafica(e);
            listPersonale.getItems().add(checks.get(0));
            listEsterni.getItems().add(checks.get(1));
            listLicenzia.getItems().add(checks.get(2));
        }
    }    
    
    
    @FXML
    void initialize() throws IOException {
    	
    	listInterventi.getItems().clear();
    	listTipoQuadri.getItems().clear();
    	listControlli.getItems().clear();
    	listPersonale.getItems().clear();
        listEsterni.getItems().clear();
        listLicenzia.getItems().clear();
        listTecnici.getItems().clear();
        listCabina.getItems().clear();
        listCabine1.getItems().clear();
        listQuadri.getItems().clear();
        listQuadri1.getItems().clear();
        listTQ.getItems().clear();

        for (Tecnico t : controller.tecniciCsv()) {
        	ArrayList<CheckMenuItem> checks = controller.aggiungiTecnicoAllaGrafica(t);
            listPersonale.getItems().add(checks.get(0));
            listTecnici.getItems().add(checks.get(1));
            listLicenzia.getItems().add(checks.get(2));
        }

        for (Esterno e : controller.esterniCsv()) {
        	ArrayList<CheckMenuItem> checks = controller.aggiungiEsternoAllaGrafica(e);
            listPersonale.getItems().add(checks.get(0));
            listEsterni.getItems().add(checks.get(1));
            listLicenzia.getItems().add(checks.get(2));
        }

        for (Quadro q : controller.quadriCsv()) {
        	ArrayList<CheckMenuItem> checks = controller.aggiungiQuadroAllaGrafica(q);
            listQuadri.getItems().add(checks.get(0));
            listQuadri1.getItems().add(checks.get(1));
        }
        
        for (Cabina c : controller.cabineCsv()) {
        	ArrayList<CheckMenuItem> checks = controller.aggiungiCabinaAllaGrafica(c);
            listCabina.getItems().add(checks.get(0));
            listCabine1.getItems().add(checks.get(1));
        }

        for (Controllo c : controller.controlliCsv()) {
        	CheckMenuItem checkView = controller.aggiungiControlloAllaGrafica(c);
            listControlli.getItems().add(checkView);
        }

        for (TipoQuadro tq : controller.tipoquadriCsv()) {
        	ArrayList<CheckMenuItem> checks = controller.aggiungiTipoQuadroAllaGrafica(tq);
            listTipoQuadri.getItems().add(checks.get(0));
            listTQ.getItems().add(checks.get(1));
        }

        for (Intervento I : controller.interventiCsv()) {
        	CheckMenuItem checkView = controller.aggiungiInterventoAllaGrafica(I);
            listInterventi.getItems().add(checkView);
        }
    	
        assert listTQ != null : "fx:id=\"listTQ\" was not injected: check your FXML file 'view.fxml'.";
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
        assert listLicenzia != null : "fx:id=\"listLicenziaInterni\" was not injected: check your FXML file 'view.fxml'.";
        assert btnLicenzia != null : "fx:id=\"btnLicenziaEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert chartInterventiNumero != null : "fx:id=\"chartInterventiNumero\" was not injected: check your FXML file 'view.fxml'.";
        assert chartInterventiPercentuale != null : "fx:id=\"chartInterventiPercentuale\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaPersonale != null : "fx:id=\"txtVisualizzaPersonale\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaAllPersonale != null : "fx:id=\"btnVisualizzaAllPersonale\" was not injected: check your FXML file 'view.fxml'.";
        
    }
}
