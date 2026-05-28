package com.arvedi.csv_manager;

import com.arvedi.model.Quadro;

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
            writer.write(q.getTipologia() + ";" + q.getCodiceQuadro());
            writer.newLine();
        }

        writer.close();
    }

    public static List<Quadro> caricaQuadri() throws IOException {
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
                Quadro q = new Quadro(campi[0], campi[1]);
                quadri.add(q);
            }
        }

        reader.close();

        return quadri;
    }
}
