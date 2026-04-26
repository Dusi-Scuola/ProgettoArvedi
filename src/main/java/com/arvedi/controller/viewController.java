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

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCabina;

    @FXML
    private Button btnControllo;

    @FXML
    private Button btnIntervento;

    @FXML
    private Button btnQuadro;

    @FXML
    private Button btnTecnicoEsterno;

    @FXML
    private Button btnTecnicoInterno;

    @FXML
    private Button btnTipologiaQuadro;

    @FXML
    private Button btnVisualizzaCabina;

    @FXML
    private Button btnVisualizzaControllo;

    @FXML
    private Button btnVisualizzaEsterno;

    @FXML
    private Button btnVisualizzaIntervento;

    @FXML
    private Button btnVisualizzaQuadro;

    @FXML
    private Button btnVisualizzaTecnico;

    @FXML
    private Button btnVisualizzaTipoQuadro;

    @FXML
    private ToggleGroup esito;

    @FXML
    private MenuButton listCabina;

    @FXML
    private MenuButton listPersonale;

    @FXML
    private MenuButton listQuadri;

    @FXML
    private RadioButton radNegativo;

    @FXML
    private RadioButton radPositivo;

    @FXML
    private TextField txtAziendaEsterno;

    @FXML
    private TextField txtCodiceCabina;

    @FXML
    private TextField txtCodiceIntervento;

    @FXML
    private TextField txtCodiceQuadro;

    @FXML
    private TextField txtCognomeEsterno;

    @FXML
    private TextField txtCognomeTecnico;

    @FXML
    private TextField txtDescrizioneControllo;

    @FXML
    private TextField txtDescrizioneTipo;

    @FXML
    private TextField txtNomeControllo;

    @FXML
    private TextField txtNomeEsterno;

    @FXML
    private TextField txtNomeTecnico;

    @FXML
    private TextField txtNomeTipo;

    @FXML
    private TextField txtNote;

    @FXML
    private TextField txtPosizione;

    @FXML
    private TextField txtPriorita;

    @FXML
    private TextField txtTipoQuadro;

    @FXML
    private TextField txtVisualizzaCabina;

    @FXML
    private TextField txtVisualizzaControllo;

    @FXML
    private TextField txtVisualizzaEsterno;

    @FXML
    private TextField txtVisualizzaIntervento;

    @FXML
    private TextField txtVisualizzaQuadro;

    @FXML
    private TextField txtVisualizzaTecnico;

    @FXML
    private TextField txtVisualizzaTipoQuadro;

    @FXML
    void CreaCabina(ActionEvent event) {

    }

    @FXML
    void CreaControllo(ActionEvent event) {

    }

    @FXML
    void CreaEsterno(ActionEvent event) {

    }

    @FXML
    void CreaIntervento(ActionEvent event) {

    }

    @FXML
    void CreaQuadro(ActionEvent event) {

    }

    @FXML
    void CreaTecnicoInterno(ActionEvent event) {

    }

    @FXML
    void CreaTipoQuadro(ActionEvent event) {

    }

    @FXML
    void VisualizzaCabina(ActionEvent event) {

    }

    @FXML
    void VisualizzaControllo(ActionEvent event) {

    }

    @FXML
    void VisualizzaEsterno(ActionEvent event) {

    }

    @FXML
    void VisualizzaIntervento(ActionEvent event) {

    }

    @FXML
    void VisualizzaQuadro(ActionEvent event) {

    }

    @FXML
    void VisualizzaTecnico(ActionEvent event) {

    }

    @FXML
    void VisualizzaTipoQuadro(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCabina != null : "fx:id=\"btnCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert btnControllo != null : "fx:id=\"btnControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert btnIntervento != null : "fx:id=\"btnIntervento\" was not injected: check your FXML file 'view.fxml'.";
        assert btnQuadro != null : "fx:id=\"btnQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert btnTecnicoEsterno != null : "fx:id=\"btnTecnicoEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert btnTecnicoInterno != null : "fx:id=\"btnTecnicoInterno\" was not injected: check your FXML file 'view.fxml'.";
        assert btnTipologiaQuadro != null : "fx:id=\"btnTipologiaQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaCabina != null : "fx:id=\"btnVisualizzaCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaControllo != null : "fx:id=\"btnVisualizzaControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaEsterno != null : "fx:id=\"btnVisualizzaEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaIntervento != null : "fx:id=\"btnVisualizzaIntervento\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaQuadro != null : "fx:id=\"btnVisualizzaQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaTecnico != null : "fx:id=\"btnVisualizzaTecnico\" was not injected: check your FXML file 'view.fxml'.";
        assert btnVisualizzaTipoQuadro != null : "fx:id=\"btnVisualizzaTipoQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert esito != null : "fx:id=\"esito\" was not injected: check your FXML file 'view.fxml'.";
        assert listCabina != null : "fx:id=\"listCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert listPersonale != null : "fx:id=\"listPersonale\" was not injected: check your FXML file 'view.fxml'.";
        assert listQuadri != null : "fx:id=\"listQuadri\" was not injected: check your FXML file 'view.fxml'.";
        assert radNegativo != null : "fx:id=\"radNegativo\" was not injected: check your FXML file 'view.fxml'.";
        assert radPositivo != null : "fx:id=\"radPositivo\" was not injected: check your FXML file 'view.fxml'.";
        assert txtAziendaEsterno != null : "fx:id=\"txtAziendaEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCodiceCabina != null : "fx:id=\"txtCodiceCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCodiceIntervento != null : "fx:id=\"txtCodiceIntervento\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCodiceQuadro != null : "fx:id=\"txtCodiceQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCognomeEsterno != null : "fx:id=\"txtCognomeEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert txtCognomeTecnico != null : "fx:id=\"txtCognomeTecnico\" was not injected: check your FXML file 'view.fxml'.";
        assert txtDescrizioneControllo != null : "fx:id=\"txtDescrizioneControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert txtDescrizioneTipo != null : "fx:id=\"txtDescrizioneTipo\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNomeControllo != null : "fx:id=\"txtNomeControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNomeEsterno != null : "fx:id=\"txtNomeEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNomeTecnico != null : "fx:id=\"txtNomeTecnico\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNomeTipo != null : "fx:id=\"txtNomeTipo\" was not injected: check your FXML file 'view.fxml'.";
        assert txtNote != null : "fx:id=\"txtNote\" was not injected: check your FXML file 'view.fxml'.";
        assert txtPosizione != null : "fx:id=\"txtPosizione\" was not injected: check your FXML file 'view.fxml'.";
        assert txtPriorita != null : "fx:id=\"txtPriorita\" was not injected: check your FXML file 'view.fxml'.";
        assert txtTipoQuadro != null : "fx:id=\"txtTipoQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaCabina != null : "fx:id=\"txtVisualizzaCabina\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaControllo != null : "fx:id=\"txtVisualizzaControllo\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaEsterno != null : "fx:id=\"txtVisualizzaEsterno\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaIntervento != null : "fx:id=\"txtVisualizzaIntervento\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaQuadro != null : "fx:id=\"txtVisualizzaQuadro\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaTecnico != null : "fx:id=\"txtVisualizzaTecnico\" was not injected: check your FXML file 'view.fxml'.";
        assert txtVisualizzaTipoQuadro != null : "fx:id=\"txtVisualizzaTipoQuadro\" was not injected: check your FXML file 'view.fxml'.";

    }

}
