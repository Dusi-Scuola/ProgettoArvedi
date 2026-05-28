package com.arvedi.csv_manager;

import com.arvedi.model.Cabina;
import com.arvedi.model.Quadro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvCabineManager {

    private static final String FILE_PATH = "csv/cabine.csv";

    public static void salvaCabine(List<Cabina> cabine) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH));

        writer.write("codice;posizione;quadri");
        writer.newLine();

        for (Cabina c : cabine) {
            String quadri = "";

            for (int i = 0; i < c.getQuadri().size(); i++) {
                quadri += c.getQuadri().get(i).getCodiceQuadro();

                if (i < c.getQuadri().size() - 1) {
                    quadri += "|";
                }
            }

            writer.write(c.getCodiceCabina() + ";" + c.getPosizione() + ";" + quadri);
            writer.newLine();
        }

        writer.close();
    }

    public static List<Cabina> caricaCabine(List<Quadro> quadriSelezionabili) throws IOException {
        List<Cabina> cabine = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return cabine;
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

            if (campi.length >= 3) {
                String codiceCabina = campi[0];
                String posizione = campi[1];
                String codiciQuadri = campi[2];

                ArrayList<Quadro> quadri = trovaQuadri(quadriSelezionabili, codiciQuadri);

                Cabina c = new Cabina(codiceCabina, posizione, quadri);
                cabine.add(c);
            }
        }

        reader.close();

        return cabine;
    }

    private static ArrayList<Quadro> trovaQuadri(List<Quadro> quadriSelezionabili, String codiciQuadri) {
        ArrayList<Quadro> quadri = new ArrayList<>();

        if (codiciQuadri == null || codiciQuadri.isBlank()) {
            return quadri;
        }

        String[] codici = codiciQuadri.split("\\|");

        for (String codice : codici) {
            for (Quadro q : quadriSelezionabili) {
                if (q.getCodiceQuadro().equals(codice)) {
                    quadri.add(q);
                    break;
                }
            }
        }

        return quadri;
    }
}
