/*
    Fragen:
    1. Wenn Java ein problem findet wirft es einen Fehler und schließt das Progrm -> Exepction
    2. Man versucht ein Array[x] zu rufen, wo x keine gültige position im array ist -> ArrayIndexOutOfBoundsException
       Wenn man veruscht einen Buchstaben in ein int zu parsen -> NumberFormatException
    3. 
    4. Der Code denn man laufen will, bei dem man vermutet das es fehler gibt
    5. Was zu tun ist wenn ein fehler im try block passiert
    
*/

public class RolP_04112020 {
    public static void main(String[] args) {

        try {
            int[] array = { 0, 1, 2, 3, 4, 5 };
            //!                !
            for (int i = 0; i < array.length; i++) {
                System.out.println(i + 1 + ": " + array[i]);
                /*
                 * 1: 0
                 * 2: 1
                 * 3: 2
                 * 4: 3
                 * 5: 4
                 * 6: 5
                 * 7: //! -> Catch error
                 */
            }
        }
            catch (Exception arrayException) {
            System.out.println("Die for schleife hat den array index überstiegen\n");
        }

        try {
            int zahl;
            //!               !
            String string = "eeeeeeeeeeeeeeeeeeee";

            zahl = Integer.parseInt(string);

            System.out.println(zahl);
        } catch (Exception numException) {
            System.out.println("Der gegebene wert ist keine integar");
        }

    }
}