package com.arvedi.csv_manager;

import com.arvedi.model.Controllo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvControlliManager {

    private static final String FILE_PATH = "csv/controlli.csv";

    public static void salvaControlli(List<Controllo> controlli) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH));

        writer.write("nome;descrizione");
        writer.newLine();

        for (Controllo c : controlli) {
            writer.write(c.getNome() + ";" + c.getDescrizione());
            writer.newLine();
        }

        writer.close();
    }

    public static List<Controllo> caricaControlli() throws IOException {
        List<Controllo> controlli = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return controlli;
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
                Controllo c = new Controllo(campi[0], campi[1]);
                controlli.add(c);
            }
        }

        reader.close();

        return controlli;
    }
}
