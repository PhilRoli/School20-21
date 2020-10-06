import java.util.Scanner;

public class Racemouse_cmd {

    // String Linebreak used to give out empty line
    private static String LineBreak = "\r\n";
    // Turns the console output red
    private static String redOutput = "\033[1;31m";
    // Turns the console output back to normal
    private static String resetOutput = "\u001B[0m";
    // number of participants, defined here for use in 2 functions
    private static int nParticipants;
    // Race Class Pre defined to use in main & other functions
    private static Race Race01;
    // Rennmaus CLass Pre defined to use in main & other functions
    // ! Looking for a way to do this better !
    private static Rennmaus mouse01;
    private static Rennmaus mouse02;
    private static Rennmaus mouse03;
    private static Rennmaus mouse04;
    private static Rennmaus mouse05;
    private static Rennmaus mouse06;
    private static Rennmaus mouse07;
    private static Rennmaus mouse08;
    private static Rennmaus mouse09;
    private static Rennmaus mouse10;
    // ! Looking for a way to do this better !

    public static void main(String[] args) {

        // Greeting of the user
        greeting();

        // setting the race info
        setRaceInfo();

        // add mice Function
        addMice(nParticipants);

        // output race info & mice
        System.out.println(LineBreak + Race01.toString());

        // Race
        startRace();

    }

    private static void greeting() {
        // Greets the User with the Version and a short explanation what he can do with
        // this Programm
        System.out.println(LineBreak + "Welcome to Racemouse v1.0");
        System.out.println("In this Programm you can simulate a race between Mice" + LineBreak);
    }

    private static void selectParticipants() {
        boolean input = false;
        Scanner participantsScanner = new Scanner(System.in);
        while (input == false) {
            // Asks the User how many Mice he wants to add to the Race
            System.out.println(LineBreak + "How many mice do you want to add? Min: 2, Max: 10");
            String sParticipants = participantsScanner.nextLine();
            // If the given input is not a Integar, it outpus a error Message and starts
            // again
            try {
                nParticipants = Integer.parseInt(sParticipants);
                // If the given number is smaller then 2, or bigger then 10, it outputs a error
                // Message and starts again
                if (nParticipants < 2 || nParticipants > 10) {
                    System.out.println(LineBreak + redOutput
                            + "The given number has to be bigger then 1 and smaller then 11" + resetOutput + LineBreak);
                    continue;
                }
                input = true;
            } catch (NumberFormatException ex) {
                System.out.println(
                        redOutput + "The given input has to be a whole number bigger then 1 and smaller then 11"
                                + resetOutput + LineBreak);
                continue;
            }
        }
    }

    public static void setRaceInfo() {
        boolean nameInput = false;
        boolean lengthInput = false;
        boolean okayInput = false;
        while (nameInput == false) {
            selectParticipants();
            // Sets the booleans to false because of line 138 & 139
            lengthInput = false;
            okayInput = false;
            Scanner raceInfo = new Scanner(System.in);
            // Asks the User how he wants to name his race
            System.out.println(LineBreak + "How do you want to name this Race?");
            String raceName = raceInfo.nextLine();
            while (lengthInput == false) {
                // Asks the User how long he wants his race to be
                System.out.println(LineBreak + "How long do you want your race to be? (in m)");
                String sRaceLength = raceInfo.nextLine();
                // If the given number wasnt a Double / Integar, it outputs a error Message and
                // starts again
                try {
                    double RaceLenght = Double.parseDouble(sRaceLength);
                    // If the lenght of the race is smaller then 1, it outputs a error Message and
                    // starts again
                    if (RaceLenght < 1) {
                        System.out.println(redOutput + LineBreak + "The given Race Lenght has to be bigger then 0"
                                + resetOutput + LineBreak);
                        continue;
                    }
                    while (okayInput == false) {
                        System.out.println(
                                LineBreak + "The Race will be named \"" + raceName + "\", and it will have a length of "
                                        + RaceLenght + "m and will have " + nParticipants + " Participants");
                        // Asks the User if the given informations are correct and if he wants to
                        // proceed
                        System.out.println(
                                LineBreak + "Are you okay with these infos? Enter Y for yes or N to start over again");
                        String sOkayChoice = raceInfo.nextLine();
                        char okayChoice = Character.toUpperCase(sOkayChoice.charAt(0));
                        if (okayChoice == 'Y') {
                            // Declaration of Race with user given variables
                            Race01 = new Race(raceName, nParticipants, RaceLenght);
                            nameInput = true;
                            lengthInput = true;
                            okayInput = true;
                            continue;
                        } else if (okayChoice != 'N') {
                            // If the given input was neither Y or N, it outputs a error Message and starts
                            // again
                            System.out.println(
                                    redOutput + LineBreak + "The given Input was incorrect. Please only Enter Y or N"
                                            + resetOutput + LineBreak);
                            continue;
                        }
                        // If the given input was N, it starts again
                        // sets booleans to true to start again at line 89
                        lengthInput = true;
                        okayInput = true;
                    }
                } catch (NumberFormatException ex) {
                    // If the given race length wasnt a number, it outputs a error Message and
                    // starts again
                    System.out.println(redOutput + LineBreak + "The given Race Lenght has to be a number bigger then 0"
                            + resetOutput + LineBreak);
                    continue;
                }
            }

        }
    }

    private static void addMice(int nParticipants) {
        // Asks the User for the information of every mouse he wants to add
        Scanner miceInfo = new Scanner(System.in);
        // Programm starts with mouse 1
        int currentMouse = 1;
        boolean speedInput = false;
        // Runs until every mouse was initialized
        while (currentMouse <= nParticipants) {
            speedInput = false;
            // Asks the User about the Owner Name and Race of the current mouse
            System.out.println(LineBreak + "Who is th Owner of Mouse nr." + currentMouse);
            String mouseName = miceInfo.nextLine();
            System.out.println(LineBreak + "Where does the Mouse come from?");
            String mouseRace = miceInfo.nextLine();
            while (speedInput == false) {
                // Asks the User about the max Speed of the current Mouse
                System.out.println(LineBreak + "What is the Max Speed of the Mouse? (in km/h)");
                String sMouseSpeed = miceInfo.nextLine();
                // If the given input wasnt a number, it outputs a error Message and starts
                // again
                try {
                    double mouseSpeed = Double.parseDouble(sMouseSpeed);
                    System.out.println("");
                    System.out.println("The mouse is owned by \"" + mouseName + "\", comes from \"" + mouseRace
                            + "\" and has a maxspeed of " + mouseSpeed + "km/h");
                    // Asks the User if the given Mouse Infos are correct
                    System.out.println(
                            LineBreak + "Are you okay with these infos? Enter Y for yes or N to start over again");
                    String sOkayChoice = miceInfo.nextLine();
                    char okayChoice = Character.toUpperCase(sOkayChoice.charAt(0));
                    if (okayChoice == 'Y') {
                        // Depending on what the current Mouse is, it initzialised a diffrent one with
                        // Switcher
                        switcher(currentMouse, mouseName, mouseRace, mouseSpeed);
                        // After succsefully intializing the current mouse, the tracker goes up 1
                        currentMouse++;
                        speedInput = true;
                        continue;
                    } else if (okayChoice != 'N') {
                        // If input was neither Y or N, it outputs a error Message and starts again
                        System.out.println(redOutput + LineBreak
                                + "The given Input was incorrect. Please only Enter Y or N" + resetOutput + LineBreak);
                        continue;
                    }
                    // If User inputs N, programm starts over for current mouse
                    continue;
                    // Error output for wrong Max Speed Format
                } catch (NumberFormatException ex) {
                    System.out.println(LineBreak + redOutput + "The given max speed has to be a number bigger then 0"
                            + resetOutput + LineBreak);
                    continue;
                }
            }

        }
    }

    private static void startRace() {
        // Asks the User if he wants to start the Race, if Y, starts it
        Scanner confirmRace = new Scanner(System.in);
        boolean confirm = false;
        while (confirm == false) {
            System.out.println("Do you want to start the Race? Y / N");
            String sConfirm = confirmRace.nextLine();
            char Confirm = Character.toUpperCase(sConfirm.charAt(0));
            if (Confirm == 'Y') {
                // If input was Y, it starts the race by calling Race.java raceRace function
                Race01.raceRace(0);
            } else if (Confirm != 'N') {
                // If input was neiter Y or N, it outputs a error Message and starts again
                System.out
                        .println(LineBreak + redOutput + "The input has to be either Y or N" + resetOutput + LineBreak);
                continue;
            }
            // If input was N, it exits the Programm
            System.exit(0);
        }

    }

    private static void switcher(int currentMouse, String mouseName, String mouseRace, double mouseSpeed) {
        // Switch Statement to initalize current Mouse
        switch (currentMouse) {
            case 1:
                mouse01 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse01);
                break;
            case 2:
                mouse02 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse02);
                break;
            case 3:
                mouse03 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse03);
                break;
            case 4:
                mouse04 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse04);
                break;
            case 5:
                mouse05 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse05);
                break;
            case 6:
                mouse06 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse06);
                break;
            case 7:
                mouse07 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse07);
                break;
            case 8:
                mouse08 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse08);
                break;
            case 9:
                mouse09 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse09);
                break;
            case 10:
                mouse10 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                Race01.addRaceMice(mouse10);
                break;
            default:
                System.out.println("Error in Switch Statement!");
        }

    }
}
