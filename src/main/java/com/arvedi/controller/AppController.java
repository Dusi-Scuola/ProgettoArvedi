package com.arvedi.controller;

import com.arvedi.model.Counter;

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
        private final Cabina cabina;
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
        
        public String getCodiceCabina() {
            return cabina.getCodiceCabina();
        }

        public String getPosizione() {
            return cabina.getPosizione();
        }

        public ArrayList<Quadro> getQuadri(cabina) {
            return cabina.getQuadri();
        }
        
    //CLASSE CONTROLLO

        public String getDescrizione() {
            return controllo.getDescrizione();
        }
    
        
    //CLASSE ESTERNO
        
        public String getAzienda() {
            return esterno.getAzienda();
        }
    
        
     //CLASSE INTERVENTO

        public Cabina getCabinaSelezionata() {
            return intervento.getCabinaSelezionata();
        }

        public String getCodiceIntervento() {
            return intervento.getCodiceIntervento();
        }

        public ArrayList<Tecnico> getQuadri(cabina) {
            return intervento.getQuadri();
        }
        
        
    //CLASSE QUADRO

        public String getTipologia() {
            return quadro.getTipologia();
        }

        public String getCodiceQuadro() {
            return quadro.getCodiceQuadro();
        }
        
        
    //CLASSE TECNICO

        public String getCognomeT() {
            return tecnico.getCognomeT();
        }

        public String getNomeT() {
            return tecnico.getNomeT();
        }
        
        
     //CLASSE TIPOQUADRO

        public String getNomeTQ() {
            return tipoquadro.getNomeTQ();
        }

        public String getDescrizione() {
            return tipoquadro.getDescrizione();
        }
     
}