package com.arvedi.csv_manager;

import com.arvedi.model.Esterno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvEsterniManager {

    private static final String FILE_PATH = "csv/esterni.csv";

    public static void salvaEsterni(List<Esterno> esterni) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH));

        writer.write("nome;cognome;azienda");
        writer.newLine();

        for (Esterno e : esterni) {
            writer.write(e.getNome() + ";" + e.getCognome() + ";" + e.getAzienda());
            writer.newLine();
        }

        writer.close();
    }

    public static List<Esterno> caricaEsterni() throws IOException {
        List<Esterno> esterni = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return esterni;
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
                Esterno e = new Esterno(campi[0], campi[1], campi[2]);
                esterni.add(e);
            }
        }

        reader.close();

        return esterni;
    }
}