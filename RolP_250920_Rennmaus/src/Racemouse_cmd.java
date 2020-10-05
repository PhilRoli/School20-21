import java.util.Scanner;

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

        // setting the race info
        setRaceInfo(nParticipants);
        
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
                    System.out.println(redOutput + "The given number has to be bigger then 1" + resetOutput + LineBreak);
                    continue;
                }
                // ! Line 59 & 62 Crash if scanner is closed
                // ! participantsScanner.close();
                input = true;
            }catch (NumberFormatException ex) {
                System.out.println(redOutput + "The given input has to be a whole number bigger then 1" + resetOutput + LineBreak);
                continue;
            }
        }
    }

    private static void setRaceInfo(int nParticipants) {
        boolean nameInput = false;
        boolean lengthInput = false;
        boolean okayInput = false;
        while(nameInput == false) {
            Scanner raceInfo = new Scanner(System.in);
            System.out.println("How do you want to name this Race?");
            String raceName = raceInfo.next();
            while(lengthInput == false) {
                System.out.println(LineBreak + "How long do you want your race to be? (in m)");
                String sRaceLength = raceInfo.next();
                try{
                    double RaceLenght = Double.parseDouble(sRaceLength);
                    if(RaceLenght < 1) {
                        System.out.println(redOutput + LineBreak + "The given Race Lenght has to be bigger then 0" + resetOutput + LineBreak);
                        continue;
                    }
                    while(okayInput == false) {
                        System.out.println("The Race will be named \"" + raceName + "\", and it will have a length of " + RaceLenght + "m");
                        System.out.println("Are you okay with these infos? Enter Y for yes or N to start over again");
                        String sOkayChoice = raceInfo.next();
                        char okayChoice = Character.toUpperCase(sOkayChoice.charAt(0));
                        if(okayChoice == 'Y') {
                            // Declaration of Race with user given variables
                            Race Race01 = new Race(raceName, nParticipants, RaceLenght);
                            nameInput = true;
                            lengthInput = true;
                            okayInput = true;
                            // * End of Function
                            raceInfo.close();
                            continue;
                        }
                        else if(okayChoice != 'N') {
                            System.out.println("The given Input was incorrect. Please only Enter Y or N");
                            continue;
                        }
                        // continue;
                    }
                }catch (NumberFormatException ex) {
                    System.out.println(redOutput + LineBreak + "The given Race Lenght has to be a number bigger then 0" + resetOutput + LineBreak);
                    continue;
                }
            }
                
        }
    }

}
