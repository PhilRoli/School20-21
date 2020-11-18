/*
    Fragen:
    1. 
    2. Man mus die \ mit einem weitern \ davor schrieben, da ein \ bedeutet das der nächste charakter 'escaped' word
    3. 
    4. 
    
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RolP_04112020_IO2 {
    private static void ladeDatei(String datName) {

        File file = new File(datName);

        if (!file.canRead() || !file.isFile())
            System.exit(0);

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(datName));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                System.out.println("Gelesene Zeile: " + zeile);
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
    }

    public static void main(String[] args) {
        String dateiName = "test.txt";
        ladeDatei(dateiName);
    }
}
