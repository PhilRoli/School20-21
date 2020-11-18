import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class io_checks {

    public static void main(String[] args) {
        // TODO
        // Lies von einer Datei die erste Zeile ein
        // Dort steht der Name einer Datei (name.txt)
        // Anhand dieser zeile wird dann die angegebne datei eingelesen
        // Gib von dieser datei den ganzen inhalt aus
        String vonDatei = getDateiString();
        String FileName = readDateiName(vonDatei);
        System.out.println(FileName);

    }

    public static String getDateiString() {
        return "rolp_test1.txt";
    }

    public static String readDateiName(String vonDatei) {
        String readFileName = null;

        // Check if File existst
        File file = new File(vonDatei);

        if (!file.canRead() || !file.isFile()) {
            System.out.println("Datei kann nicht gelesen werden oder ist nicht existend");
            System.exit(0);
        }

        // reading of file content
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

}
