import java.util.Scanner;

public class testRennmaus {

    public static void main(String[] args){
        String LineBreak = "\r\n";
        // Number of participants has to be right !!!
        Race Race01 = new Race("Race Test", 4, 100);
        Rennmaus mouse1 = new Rennmaus("Mouse1", "Mongolian ", 13);
        Rennmaus mouse2 = new Rennmaus("Mouse2", "Mexican   ", 13);
        Rennmaus mouse3 = new Rennmaus("Mouse3", "Australian", 13);
        Rennmaus mouse4 = new Rennmaus("Mouse4", "African   ", 13);

        Race01.addRaceMice(mouse1);
        Race01.addRaceMice(mouse2);
        Race01.addRaceMice(mouse3);
        Race01.addRaceMice(mouse4);

        Race01.removeRaceMice("Mouse1");

        Race01.addRaceMice(mouse1);

        System.out.println(LineBreak + Race01.toString());

        Race01.raceRace(0);

        // Used if system.exit in raceRace is commented out
        System.out.println(" ");
        Scanner scan = new Scanner(System.in);
        System.out.print("Press ENTER to continue . . . ");
        scan.nextLine();
        scan.close();
    }
    
}
