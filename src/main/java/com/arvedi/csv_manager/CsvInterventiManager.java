package com.arvedi.csv_manager;

import com.arvedi.model.Intervento;
import com.arvedi.model.Tecnico;
import com.arvedi.model.Esterno;
import com.arvedi.model.Cabina;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvInterventiManager {

    private static final String FILE_PATH = "csv/interventi.csv";

    public static void salvaInterventi(List<Intervento> interventi) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH));

        writer.write("codiceIntervento;codiceCabina;personale;data;note;esito;priorita");
        writer.newLine();

        for (Intervento i : interventi) {
            String personale = "";

            for (int j = 0; j < i.getPersonale().size(); j++) {
                Tecnico t = i.getPersonale().get(j);

                personale += t.getNome() + " " + t.getCognome();

                if (j < i.getPersonale().size() - 1) {
                    personale += "|";
                }
            }

            writer.write(
                i.getCodiceIntervento() + ";" +
                i.getCabinaSelezionata().getCodiceCabina() + ";" +
                personale + ";" +
                i.getData().toString() + ";" +
                pulisci(i.getNote()) + ";" +
                i.isEsitoPositivo() + ";" +
                i.getPriorita()
            );

            writer.newLine();
        }

        writer.close();
    }

    public static List<Intervento> caricaInterventi(
            List<Cabina> cabineSelezionabili,
            List<Tecnico> personaleSelezionabile
    ) throws IOException {

        List<Intervento> interventi = new ArrayList<>();
        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return interventi;
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

            if (campi.length >= 7) {
                String codiceIntervento = campi[0];
                String codiceCabina = campi[1];
                String personaleCsv = campi[2];
                LocalDate data = LocalDate.parse(campi[3]);
                String note = campi[4];
                boolean esito = Boolean.parseBoolean(campi[5]);
                int priorita = Integer.parseInt(campi[6]);

                Cabina cabina = trovaCabina(cabineSelezionabili, codiceCabina);
                ArrayList<Tecnico> personale = trovaPersonale(personaleSelezionabile, personaleCsv);

                if (cabina != null) {
                    Intervento i = new Intervento(
                        cabina,
                        codiceIntervento,
                        personale,
                        data,
                        note,
                        esito,
                        priorita
                    );

                    interventi.add(i);
                }
            }
        }

        reader.close();

        return interventi;
    }

    private static Cabina trovaCabina(List<Cabina> cabineSelezionabili, String codiceCabina) {
        for (Cabina c : cabineSelezionabili) {
            if (c.getCodiceCabina().equals(codiceCabina)) {
                return c;
            }
        }

        return null;
    }

    private static ArrayList<Tecnico> trovaPersonale(List<Tecnico> personaleSelezionabile, String personaleCsv) {
        ArrayList<Tecnico> personale = new ArrayList<>();

        if (personaleCsv == null || personaleCsv.isBlank()) {
            return personale;
        }

        String[] persone = personaleCsv.split("\\|");

        for (String nomeCompleto : persone) {
            for (Tecnico t : personaleSelezionabile) {
                String nomeTecnico = t.getNome() + " " + t.getCognome();

                if (nomeTecnico.equals(nomeCompleto)) {
                    personale.add(t);
                    break;
                }
            }
        }

        return personale;
    }

    private static String pulisci(String value) {
        if (value == null) {
            return "";
        }

        return value.replace(";", ",").replace("\n", " ");
    }
}
