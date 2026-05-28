package com.arvedi.csv_manager;

import com.arvedi.model.Tecnico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvTecniciManager {

    private static final String FILE_PATH = "csv/tecnici.csv";

    public static void salvaTecnici(List<Tecnico> tecnici) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH));

        writer.write("nome;cognome");
        writer.newLine();

        for (Tecnico t : tecnici) {
            writer.write(t.getNome() + ";" + t.getCognome());
            writer.newLine();
        }

        writer.close();
    }

    public static List<Tecnico> caricaTecnici() throws IOException {
        List<Tecnico> tecnici = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return tecnici;
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
                Tecnico t = new Tecnico(campi[0], campi[1]);
                tecnici.add(t);
            }
        }

        reader.close();

        return tecnici;
    }
}
