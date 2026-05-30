package com.arvedi.csv_manager;

import com.arvedi.model.Cabina;
import com.arvedi.model.Quadro;
import com.arvedi.model.TipoQuadro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvQuadriManager {

    private static final String FILE_PATH = "csv/quadri.csv";

    public static void salvaQuadri(List<Quadro> quadri) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH));

        writer.write("tipo;codice");
        writer.newLine();

        for (Quadro q : quadri) {
            writer.write(q.getTipologia().getNome() + ";" + q.getCodiceQuadro());
            writer.newLine();
        }

        writer.close();
    }

    public static List<Quadro> caricaQuadri(List<TipoQuadro> tipiquadriSelezionabili) throws IOException {
        List<Quadro> quadri = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return quadri;
        }

        BufferedReader reader = Files.newBufferedReader(path);

        String line;
        boolean primaRiga = true;

        while ((line = reader.readLine()) != null) {
            if (primaRiga) {
                primaRiga = false;
                continue;
            }

            String[] campi = line.split(";", -1);

            if (campi.length >= 2) {
            	String codice = campi[1];
            	String nomeTipoQuadro = campi[2];
                TipoQuadro TQ = trovaTQ(tipiquadriSelezionabili, nomeTipoQuadro);
                
                if(TQ != null) {
                	Quadro q = new Quadro(TQ, codice);
                	quadri.add(q);
                }
            }
        }

        reader.close();

        return quadri;
    }
    
    private static TipoQuadro trovaTQ(List<TipoQuadro> tipiquadriSelezionabili, String nomeTipoQuadro) {
        for (TipoQuadro t : tipiquadriSelezionabili) {
            if (t.getNome().equals(nomeTipoQuadro)) {
                return t;
            }
        }

        return null;
    }
    
}
