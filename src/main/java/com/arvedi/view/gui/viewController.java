package com.arvedi.view.gui;
import com.arvedi.controller.AppController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class viewController {
	
	// MVC Controller (logic + model)
    private final AppController controller;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTipoQuadro;

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
    private TextField txtVisualizzaQuadro;

    @FXML
    private Button btnVisualizzaEsterno;

    @FXML
    private TextField txtVisualizzaCabina;

    @FXML
    private Button btnVisualizzaCabina;

    @FXML
    private TextField txtVisualizzaTecnico;

    @FXML
    private Button btnVisualizzaTecnico;

    @FXML
    private TextField txtVisualizzaEsterno;

    @FXML
    private Button btnVisualizzaQuadro;

    @FXML
    private TextField txtVisualizzaTipoQuadro;

    @FXML
    private Button btnVisualizzaTipoQuadro;

    @FXML
    private Button btnVisualizzaControllo;

    @FXML
    private TextField txtVisualizzaIntervento;

    @FXML
    private Button btnVisualizzaIntervento;

    @FXML
    private TextField txtVisualizzaControllo;

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

    @FXML
    void CreaCabina(ActionEvent event) {

    }

    /** The constructor receives the AppController */
    public GuiController(AppController controller) {
        this.controller = controller;
    }

    /**
     * This method is called automatically by JavaFX
     * after the FXML file has been loaded.
     *
     * Here we:
     *  - initialize the GUI
     *  - connect buttons to actions
     */
    @FXML
    public void initialize() {
        refresh();

        btnInc.setOnAction(e -> {
            controller.increment();
            refresh();
        });

        btnDec.setOnAction(e -> {
            controller.decrement();
            refresh();
        });

        btnReset.setOnAction(e -> {
            controller.reset();
            refresh();
        });
    }

    /** Updates the label showing the counter value */
    private void refresh() {
        lblCount.setText(Integer.toString(controller.getCount()));
    }
}