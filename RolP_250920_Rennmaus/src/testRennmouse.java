import java.util.Scanner;

public class testRennmouse {

    public static void main(String[] args){
        String LineBreak = "\r\n";
        // Number of participants has to be right !!!
        Race Race01 = new Race("Race Test", 4, 100);
        Rennmouse mouse1 = new Rennmouse("Mouse1", "Mongolian ", 40);
        Rennmouse mouse2 = new Rennmouse("Mouse2", "Mexican   ", 40);
        Rennmouse mouse3 = new Rennmouse("Mouse3", "Australian", 40);
        Rennmouse mouse4 = new Rennmouse("Mouse4", "African   ", 40);

        Race01.addRaceMice(mouse1);
        Race01.addRaceMice(mouse2);
        Race01.addRaceMice(mouse3);
        Race01.addRaceMice(mouse4);

        Race01.removeRaceMice("Mouse1");

        Race01.addRaceMice(mouse1);

        System.out.println(LineBreak + Race01.toString());

        Race01.raceRace();

        // Used if system.exit in raceRace is commented out
        System.out.println(" ");
        Scanner scan = new Scanner(System.in);
        System.out.print("Press ENTER to continue . . . ");
        scan.nextLine();
        scan.close();
    }
    
}
