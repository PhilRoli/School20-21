
// imports used in various functions
import java.util.ArrayList;
import java.util.*;

public class Race {

    // Name of the Race
    private String raceName;
    // Number of Participants
    private int nParticipants;
    // Participants
    private ArrayList<Rennmaus> participantList = new ArrayList<Rennmaus>();
    // Distance to run
    private double runDistance;
    // index of current mouse running
    private int currentMouse = 0;
    // boolean to check if there is a winner
    private boolean winner = false;

    // Race Constructor: Name of Race, Nr of Oarticipants, Distance to run
    public Race(String raceName, int nParticipants, double runDistance) {
        this.raceName = raceName;
        this.nParticipants = nParticipants;
        this.runDistance = runDistance;
    }

    // Adds Mice from the Rennmaus Class to the race into a arraylist
    public void addRaceMice(Rennmaus neueMaus) {
        participantList.add(neueMaus);
        // Output to indicate successful addition
        System.out.println(participantList.get(participantList.size() - 1).getName() + " has been added to the Race");
    }

    // Removes Mice with the same name as given with function call
    public void removeRaceMice(String Name) {
        for (Rennmaus participant : participantList) {
            // checks if given name equals any mice in arraylist
            if (participant.getName().equals(Name)) {
                // if yes, removes it
                participantList.remove(participant);
                // output to indicate successful removal of mice
                System.out.println("\"" + Name + "\" has been removed from the List!");
                return;
            }
        }
        // if no mice matches given name, output to indicate
        System.out.println("A Mouse with the Name of \"" + Name + "\" has not been found!");
    }

    // outputs race info and participant list
    public String toString() {
        String ReturnString;
        String HorizontalLine = "---------------------------------------------------------------------------";
        String LineBreak = "\r\n";
        String rData = "Race Name: " + this.raceName + " | Number of Participants: " + this.nParticipants
                + " | Distance to Run: " + this.runDistance + "m";
        // System.out.format("%16s%16s%8s", this.raceName, this.nParticipants,
        // this.runDistance);
        // System.out.println(HorizontalLine + LineBreak);

        // combines race data + line + linebreak in single string
        ReturnString = rData + LineBreak + HorizontalLine + LineBreak;

        Iterator<Rennmaus> itr = participantList.iterator();

        // calls all participants .toString functions and combines into single string
        while (itr.hasNext()) {
            Rennmaus mouse = (Rennmaus) itr.next();
            ReturnString = ReturnString + mouse.toString() + LineBreak;
        }

        return ReturnString;

    }

    // lets the mouse run
    private void letMouseRun(int output) {
        // checks if current mouse index is higher than number of participants, if yes,
        // set to 0
        if (this.currentMouse >= this.nParticipants) {
            this.currentMouse = 0;
            if (output == 1) {
                System.out.println(" ");
            }
        }

        // calculation for distance total, laid back and setting new total distance
        double disBefore = participantList.get(this.currentMouse).getDistanceRan();
        participantList.get(this.currentMouse).setDistanceRan(participantList.get(this.currentMouse).getDistanceRan()
                + participantList.get(this.currentMouse).mRun());
        double disRan = participantList.get(this.currentMouse).getDistanceRan() - disBefore;
        // output of distance + total distance ran
        if (output == 1) {
            System.out.println(participantList.get(this.currentMouse).getName() + " has ran " + disRan + " | T: "
                    + participantList.get(this.currentMouse).getDistanceRan());
        }

    }

    // checks if this.currentMouse has crossed the finish line
    private Rennmaus getWinner() {
        if (participantList.get(this.currentMouse).getDistanceRan() >= this.runDistance) {
            // sets winner to true and ends raceRace function
            winner = true;
            // returns winner mouse
            return participantList.get(this.currentMouse);
        } else {
            // adds +1 to currentMouse to call functions for next mouse in line
            this.currentMouse = this.currentMouse + 1;
            return null;
        }
    }

    // Race function, lets the mice run and gets the winner
    public void raceRace(int outputTF) {
        // Turns the console output green
        String greenOutput = "\033[0;32m";
        // Turns the console output back to normal
        String resetOutput = "\u001B[0m";

        // while no winner is present, lets mice run and checks for winner
        while (winner == false) {
            letMouseRun(outputTF);
            getWinner();
        }

        // when winner is present, outputs winner name and ends programm
        System.out.println(" ");
        System.out.println(greenOutput + "\"" + participantList.get(this.currentMouse).getName()
                + "\" has won the Race!!!" + resetOutput);
        System.exit(0);

    }

}
