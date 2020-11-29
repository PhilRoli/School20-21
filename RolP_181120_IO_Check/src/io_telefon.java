import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class io_telefon {
    public static void main(String[] args) {
        // TODO 1
        // ${Vorname} ${Nachname} mit Tel.Nr. ${telefonnr} hat um ${betrag} telefoniert.
        // Beispiel Datenspeicherung:
        // nachname;vorname;adresse;telnr;betrag
        // Bauer;Walter;5020 Salzburg;0662410000;123.45

        // TODO 2
        // Am ende gesamt Statisk anzeigen
        // Gesamt Telefonate
        // Gesamt Betrag

        // split()

        System.out.print("\n");

        ArrayList<String[]> phoneData = new ArrayList<String[]>();

        String fileName = getDateiString();
        checkFile(fileName);
        phoneData = getDataArray(fileName);
        dataToOutString(phoneData);
        statistik(phoneData);
    }

    public static String getDateiString() {
        return "data.csv";
    }

    public static void checkFile(String fileName) {
        // ! Check if File existst
        File file = new File(fileName);

        if (!file.canRead()) {
            System.out.println("Datei kann nicht gelesen werden");
            System.exit(0);
        }

        if (!file.isFile()) {
            System.out.println("Datei ist nicht existend");
            System.exit(0);
        }
    }

    public static ArrayList<String[]> getDataArray(String fileName) {
        ArrayList<String[]> dataLines = new ArrayList<String[]>();

        // ! reading of file content
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                dataLines.add(zeile.split(","));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }

        return dataLines;
    }

    public static void dataToOutString(ArrayList<String[]> dataArrays) {
        for (int i = 1; i < dataArrays.size(); i++) {
            String[] dataArrayLine = dataArrays.get(i);

            // ${Vorname} ${Nachname} mit Tel.Nr. ${telefonnr} hat um ${betrag} telefoniert.
            // Nachname,Vorname,Adresse,Telefon Nummer,Betrag
            System.out.println(dataArrayLine[1] + " " + dataArrayLine[0] + " mit Tel nr. " + dataArrayLine[3]
                    + " hat um € " + dataArrayLine[4] + " telefoniert.");
        }
    }

    public static void statistik(ArrayList<String[]> dataArrays) {
        int telephonateAnzahl = dataArrays.size() - 1;
        double gesamtBetrag = 0.00;

        for (int i = 1; i < dataArrays.size(); i++) {
            try {
                gesamtBetrag += Double.parseDouble(dataArrays.get(i)[4]);
            } catch (NumberFormatException e) {
                System.out.println("Error on Line " + (i + 1) + " : " + dataArrays.get(i)[4] + " =/= double value");
            }

        }

        System.out.println("\nAnzahl Telephonate: " + telephonateAnzahl);
        System.out.println("Gesamter Betrag: " + Math.round(gesamtBetrag * 100.00) / 100.00);
    }
}
