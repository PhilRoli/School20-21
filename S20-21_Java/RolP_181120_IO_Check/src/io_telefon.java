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

        // TODO 3
        // Erweiterung
        // Tabelle in Datei schreiben

        System.out.print("\n");

        ArrayList<String[]> phoneData = new ArrayList<String[]>();

        String fileName = getDateiString();
        checkFile(fileName);
        phoneData = getDataArray(fileName);
        // dataToOutString(phoneData);
        // statistik(phoneData);
        dataTable(phoneData);
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

    // public static void statistik(ArrayList<String[]> dataArrays) {
    // System.out.println("\nAnzahl Telephonate: " + telAnzahl(dataArrays));
    // System.out.println("Gesamter Betrag: " + gesBetrag(dataArrays));
    // }

    public static int telAnzahl(ArrayList<String[]> dataArrays) {
        return dataArrays.size() - 1;
    }

    public static double gesBetrag(ArrayList<String[]> dataArrays) {
        double gesamtBetrag = 0.00;

        for (int i = 1; i < dataArrays.size(); i++) {
            try {
                gesamtBetrag += Double.parseDouble(dataArrays.get(i)[4]);
            } catch (NumberFormatException e) {
                System.out.println("Error on Line " + (i + 1) + " : " + dataArrays.get(i)[4] + " =/= double value");
            }
        }

        return Math.round(gesamtBetrag * 100.00) / 100.00;
    }

    public static void dataTable(ArrayList<String[]> dataArrays) {
        // |---Nachname---|---Vorname---|---POST---|---Telefon---|---Betrag---|
        // |--------------|-------------|----------|-------------|------------|
        // |Rolinek-------|Philipp------|---5071---|0680 2407079-|14.90-------|

        ArrayList<String> dataList = new ArrayList<String>();
        dataList.add(
                "Anzahl Telephonate: " + telAnzahl(dataArrays) + "\nGesamt Betrag: " + gesBetrag(dataArrays) + "\n\n");
        dataList.add("|   Nachname   |   Vorname   |   POST   |   Telefon   |   Betrag   |");
        dataList.add("|              |             |          |             |            |");

        String nachname;
        String vorname;
        String post;
        String telefon;
        String betrag;
        char trenner = '|';

        for (int i = 1; i < dataArrays.size(); i++) {
            nachname = rightPad(dataArrays.get(i)[0], 14);
            vorname = rightPad(dataArrays.get(i)[1], 13);
            post = rightPad(dataArrays.get(i)[2].substring(0, 4), 10);
            telefon = rightPad(dataArrays.get(i)[3], 13);
            betrag = rightPad(dataArrays.get(i)[4], 12);

            String tempString = (trenner + nachname + trenner + vorname + trenner + post + trenner + telefon + trenner
                    + betrag + trenner);

            dataList.add(tempString);

        }

        tableToFile(dataList, "telefonDataTable.txt");
    }

    public static void tableToFile(ArrayList<String> list, String newFileName) {
        createFile(newFileName);
        String currentLine;
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(newFileName));
            try {
                for (int lineCounter = 0; lineCounter < list.size(); lineCounter += 1) {
                    currentLine = list.get(lineCounter);
                    bWriter.write(currentLine + "\n");
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (bWriter != null) {
                    bWriter.close();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static StringBuilder rightPad(StringBuilder pStringBuilder, int pLength, char pChar) {
        while (pStringBuilder.length() < pLength) {
            pStringBuilder.append(pChar);
        }

        return pStringBuilder;
    }

    public static String rightPad(String pString, int pLength) {
        return rightPad(new StringBuilder(pString), pLength, ' ').toString();
    }

    public static void createFile(String filename) {
        try {
            File newFile = new File(filename);
            newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("An Error occured");
            e.printStackTrace();
        }
    }
}
