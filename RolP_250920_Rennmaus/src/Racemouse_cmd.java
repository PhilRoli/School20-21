import java.util.Scanner;

import javax.sound.sampled.Line;

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

        // gets the number of participants
        // selectParticipants();

        // setting the race info
        setRaceInfo();

        // add mice Function
        addMice(nParticipants);

        // TODO output race info & mice
        // outputWholeInfo();

        // TODO Race

    }

    private static void greeting() {
        System.out.println(LineBreak + "Welcome to Racemouse v1.0");
        System.out.println("In this Programm you can simulate a race between Mice" + LineBreak);
    }

    private static void selectParticipants() {
        boolean input = false;
        Scanner participantsScanner = new Scanner(System.in);
        while (input == false) {
            System.out.println(LineBreak + "How many mice do you want to add? Min: 2, Max: 10");
            String sParticipants = participantsScanner.nextLine();
            try {
                nParticipants = Integer.parseInt(sParticipants);
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
        // participantsScanner.close();

    }

    public static void setRaceInfo() {
        boolean nameInput = false;
        boolean lengthInput = false;
        boolean okayInput = false;
        while (nameInput == false) {
            selectParticipants();
            // sets the booleans back to false bc of lines 91 - 93
            lengthInput = false;
            okayInput = false;
            Scanner raceInfo = new Scanner(System.in);
            System.out.println(LineBreak + "How do you want to name this Race?");
            String raceName = raceInfo.next();
            while (lengthInput == false) {
                System.out.println(LineBreak + "How long do you want your race to be? (in m)");
                String sRaceLength = raceInfo.next();
                try {
                    double RaceLenght = Double.parseDouble(sRaceLength);
                    if (RaceLenght < 1) {
                        System.out.println(redOutput + LineBreak + "The given Race Lenght has to be bigger then 0"
                                + resetOutput + LineBreak);
                        continue;
                    }
                    while (okayInput == false) {
                        System.out.println(
                                LineBreak + "The Race will be named \"" + raceName + "\", and it will have a length of "
                                        + RaceLenght + "m and will have " + nParticipants + " Participants");
                        System.out.println(
                                LineBreak + "Are you okay with these infos? Enter Y for yes or N to start over again");
                        String sOkayChoice = raceInfo.next();
                        char okayChoice = Character.toUpperCase(sOkayChoice.charAt(0));
                        if (okayChoice == 'Y') {
                            // Declaration of Race with user given variables
                            Race01 = new Race(raceName, nParticipants, RaceLenght);
                            nameInput = true;
                            lengthInput = true;
                            okayInput = true;
                            // * End of Function
                            // raceInfo.close();
                            continue;
                        } else if (okayChoice != 'N') {
                            System.out.println(
                                    redOutput + LineBreak + "The given Input was incorrect. Please only Enter Y or N"
                                            + resetOutput + LineBreak);
                            continue;
                        }
                        // sets booleans to true to start again at line 56
                        lengthInput = true;
                        okayInput = true;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println(redOutput + LineBreak + "The given Race Lenght has to be a number bigger then 0"
                            + resetOutput + LineBreak);
                    continue;
                }
            }

        }
    }

    private static void addMice(int nParticipants) {
        Scanner miceInfo = new Scanner(System.in);
        int currentMouse = 1;
        boolean correctInput = false;
        boolean speedInput = false;
        while (currentMouse <= nParticipants) {
            speedInput = false;
            System.out.println(LineBreak + "Who is th Owner of Mouse nr." + currentMouse);
            String mouseName = miceInfo.next();
            System.out.println(LineBreak + "Where does the Mouse come from?");
            String mouseRace = miceInfo.next();
            while (speedInput == false) {
                System.out.println(LineBreak + "What is the Max Speed of the Mouse? (in km/h)");
                String sMouseSpeed = miceInfo.next();
                try {
                    double mouseSpeed = Double.parseDouble(sMouseSpeed);
                    System.out.println("");
                    System.out.println("The mouse is owned by \"" + mouseName + "\", comes from \"" + mouseRace
                            + "\" and has a maxspeed of " + mouseSpeed + "km/h");
                    System.out.println(
                            LineBreak + "Are you okay with these infos? Enter Y for yes or N to start over again");
                    String sOkayChoice = miceInfo.next();
                    char okayChoice = Character.toUpperCase(sOkayChoice.charAt(0));
                    if (okayChoice == 'Y') {
                        // ! Looking for a way to do this better !
                        if (currentMouse == 1) {
                            mouse01 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        } else if (currentMouse == 2) {
                            mouse02 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        } else if (currentMouse == 3) {
                            mouse03 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        } else if (currentMouse == 4) {
                            mouse04 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        } else if (currentMouse == 5) {
                            mouse05 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        } else if (currentMouse == 6) {
                            mouse06 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        } else if (currentMouse == 7) {
                            mouse07 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        } else if (currentMouse == 8) {
                            mouse08 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        } else if (currentMouse == 9) {
                            mouse09 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        } else if (currentMouse == 10) {
                            mouse10 = new Rennmaus(mouseName, mouseRace, mouseSpeed);
                        }
                        // ! Looking for a way to do this better !
                        currentMouse++;
                        speedInput = true;
                        continue;
                    } else if (okayChoice != 'N') {
                        System.out.println(redOutput + LineBreak
                                + "The given Input was incorrect. Please only Enter Y or N" + resetOutput + LineBreak);
                        continue;
                    }
                    continue;
                } catch (NumberFormatException ex) {
                    System.out.println(LineBreak + redOutput + "The given max speed has to be a number bigger then 0"
                            + resetOutput + LineBreak);
                    continue;
                }
            }

        }
    }

}
