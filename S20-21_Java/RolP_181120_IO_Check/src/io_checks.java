import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class io_checks {

    public static void main(String[] args) {
        // TODO 1
        // Lies von einer Datei die erste Zeile ein
        // Dort steht der Name einer Datei (name.txt)

        // TODO 2
        // Mit dem name aus T0DO 1 ließ eine weitere datei ein
        // Gib jede einzelne zeile der 2. datei in ein Array
        // Gib das gesamte array aus

        // TODO 3
        // Schreibe jede zweite zeile aus dem T0DO 2 Array in eine neue Datei
        // Fange mit zeile 1 an (1,3,5 ...)

        String vonDatei = getDateiString();
        String fileName = readDateiName(vonDatei);
        System.out.println("\n" + fileName + "\n");
        // System.out.println(readSecondFile(fileName));
        ArrayList<String> secondFileLines = new ArrayList<String>();
        secondFileLines = readSecondFile(fileName);
        System.out.println(listToString(secondFileLines));
        secondLineToFile(secondFileLines, "kopie.txt");

    }

    public static String getDateiString() {
        return "rolp_test1.txt";
    }

    public static String readDateiName(String vonDatei) {
        String readFileName = null;

        // ! Check if File existst
        File file = new File(vonDatei);

        if (!file.canRead() || !file.isFile()) {
            System.out.println("Datei kann nicht gelesen werden oder ist nicht existend");
            System.exit(0);
        }

        // ! reading of file content
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(vonDatei));
            readFileName = in.readLine();
            return readFileName;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }

        return readFileName;
    }

    public static ArrayList<String> readSecondFile(String fileName) {
        ArrayList<String> secondLines = new ArrayList<String>();

        // ! Check if File existst
        File file = new File(fileName);

        if (!file.canRead() || !file.isFile()) {
            System.out.println("Datei kann nicht gelesen werden oder ist nicht existend");
            System.exit(0);
        }

        // ! reading of file content
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                secondLines.add(zeile);
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

        // fileContent = fileContent.substring(1);
        return secondLines;

    }

    public static String listToString(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append("\n");
        }

        return (sb.toString());
    }

    public static void secondLineToFile(ArrayList<String> list, String newFileName) {
        createFile(newFileName);
        String currentLine;
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(newFileName));
            try {
                for (int lineCounter = 0; lineCounter < list.size(); lineCounter += 2) {
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
