package com.arvedi.csv_manager;

import com.arvedi.model.TipoQuadro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvTipoQuadriManager {

    private static final String FILE_PATH = "csv/tipiquadri.csv";

    public static void salvaTipoQuadri(List<TipoQuadro> tipiquadri) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH));

        writer.write("nome;descrizione");
        writer.newLine();

        for (TipoQuadro tq : tipiquadri) {
            writer.write(tq.getNome() + ";" + tq.getDescrizione());
            writer.newLine();
        }

        writer.close();
    }

    public static List<TipoQuadro> caricaTipoQuadri() throws IOException {
        List<TipoQuadro> tipiquadri = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return tipiquadri;
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
                TipoQuadro tq = new TipoQuadro(campi[0], campi[1]);
                tipiquadri.add(tq);
            }
        }

        reader.close();

        return tipiquadri;
    }
}
