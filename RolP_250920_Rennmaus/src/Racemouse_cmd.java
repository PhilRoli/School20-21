import java.util.Scanner;

import javax.sound.sampled.Line;

public class Racemouse_cmd {

    // String Linebreak used to give out empty line
    private static String LineBreak = "\r\n";
    // Turns the console output red
    private static String redOutput = "\033[1;31m";
    // Turns the console output back to normal
    private static String resetOutput = "\u001B[0m";
    private static int nParticipants;
    public static void main(String[] args) {
        
        // Greeting of the user
        greeting();

        // gets the number of participants
        selectParticipants();
        
    }

    private static void greeting() {
        System.out.println(LineBreak + "Welcome to Racemouse v1.0");
        System.out.println("In this Programm you can simulate a race between Mice" + LineBreak);
    }

    private static void selectParticipants() {
        boolean input = false;
        while(input == false) {
            System.out.println("How many mice do you want to add?");
            Scanner participantsScanner = new Scanner(System.in);
            String sParticipants = participantsScanner.nextLine();
            try{
                nParticipants = Integer.parseInt(sParticipants);
                if(nParticipants < 2) {
                    System.out.println(redOutput + LineBreak + "The given number has to be bigger then 1" + resetOutput + LineBreak);
                    continue;
                }
                participantsScanner.close();
                input = true;
            }catch (NumberFormatException ex) {
                System.out.println(redOutput + LineBreak + "The given input has to be a whole number bigger then 1" + resetOutput + LineBreak);
                continue;
            }
        }
    }

    private static void setRaceInfo(int nParticipants) {
        boolean input = false;
        while(input == false) {
            Scanner raceInfo = new Scanner(System.in);
            System.out.println("How do you want to name this Race?");
            String raceName = raceInfo.nextLine();
            System.out.println(LineBreak + "How long do you want your race to be? (in m)");
            String sRaceLength = raceInfo.nextLine();
            try{

            }catch (NumberFormatException ex) {
                
            }
        }
    }

}
