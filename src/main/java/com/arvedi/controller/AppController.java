package com.arvedi.controller;

import com.arvedi.model.Cabina;
import com.arvedi.model.Controllo;
import com.arvedi.model.Esterno;
import com.arvedi.model.Intervento;
import com.arvedi.model.Quadro;
import com.arvedi.model.Tecnico;
import com.arvedi.model.TipoQuadro;
import java.util.ArrayList;


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

      //CLASSE CABINA
        
        public String CabinaToString() {
        	return cabina.toString();
        }
        
        public String getCodiceCabina() {
            return cabina.getCodiceCabina();
        }

        public String getPosizione() {
            return cabina.getPosizione();
        }

        public ArrayList<Quadro> getQuadriCabina() {
            return cabina.getQuadri();
        }
        
    //CLASSE CONTROLLO
        
        public String ControlloToString() {
        	return controllo.toString();
        }

        public String getDescrizioneControllo() {
            return controllo.getDescrizione();
        }
    
        
    //CLASSE ESTERNO
        
        public String EsternoToString() {
        	return esterno.toString();
        }
        
        public String getAzienda() {
            return esterno.getAzienda();
        }
        
        public void licenziaEst() {
        	esterno.licenziaEsterno();
        }
        
     //CLASSE INTERVENTO
        
        public String InterventoToString() {
        	return intervento.toString();
        }

        public Cabina getCabinaSelezionata() {
            return intervento.getCabinaSelezionata();
        }

        public String getCodiceIntervento() {
            return intervento.getCodiceIntervento();
        }

        public ArrayList<Tecnico> getPersonaleIntervento() {
            return intervento.getPersonale();
        }
        
        
    //CLASSE QUADRO

        public String QuadroToString() {
        	return quadro.toString();
        }
        
        public String getTipologia() {
            return quadro.getTipologia();
        }

        public String getCodiceQuadro() {
            return quadro.getCodiceQuadro();
        }
        
        
    //CLASSE TECNICO
        
        public String TecnicoToString() {
        	return tecnico.toString();
        }

        public String getCognomeTecnico() {
            return tecnico.getCognome();
        }

        public String getNomeTecnico() {
            return tecnico.getNome();
        }
        
        public void licenziaInt() {
        	tecnico.licenziaTecnico();
        }
        
        
     //CLASSE TIPOQUADRO
        
        public String TipoQuadroToString() {
        	return tipoquadro.toString();
        }

        public String getNomeTQ() {
            return tipoquadro.getNome();
        }

        public String getDescrizione() {
            return tipoquadro.getDescrizione();
        }
     
}