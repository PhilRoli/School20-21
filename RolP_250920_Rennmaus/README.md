# RolP_250920_Rennmaus
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/PhilRoli/School20-21/pulls) 

Java Project where we had to make a class Race and class Rennmaus. These, in addition to a testeRennmaus test file, can simulate a race between mice.

Some are English or German only, some are mixed. If you have any questions you can send me a DM on [twitter](https://twitter.com/Phil_Roli).

_Rennmouse == Race Mouse_

---

## Functions

---

### [Race.java](https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Race.java)

- **Race(String raceName, int nParticipants, double runDistance)**: Constructer for the class Race, String raceName > Name of the Race / int nParticipants > Number of Participants / double runDistance > Distance the Race lasts for.

- **public void addRaceMice (Rennmouse neueMaus)**: Adds a Rennmaus object to the ArrayList of the Race.

- **public void removeRaceMice (String Name)**: Goes trough the ArrayList and removes the first Rennmouse object in the List that shares the name Attribute with the given name.

- **public String toString()**: Puts all info about the Race and the mice in it into a return String.

- **private void letMouseRun()**: First checks if the int currentMouse is bigger / same then the number of participants. After the check, the currentMouse is allowed to run with the help of the Rennmousee.java mRun function.

- **private Rennmousee getWinner()**: checks if the current mouse has run more distance then the race is long, if so sets the winner to true and returns said mouse. If not, adds +1 to currentMouse and the process starts from the start.

- **public void raceRace()**: Starts the race, works with the help of the getWinner & letMouseRun functions. if Winner == true, ends the programm.

### [Rennmouse.java](https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Rennmaus.java)

- **public Rennmouse(String name, String mRace, double maxSpeed)**: Constructer for the class Rennmouse, String name > Name of the Owner, String mRace > Race of the Race Mouse, double maxSpeed > max Speed of the Mouse

- **public double mRUn()**: if called, adds a rounded randome double to a varible disRan and then retruns said varible.

- **public String toString()**: Returns all info about the current mouse as a String

- **All Functions below**: Getters and Setters that are used
    - public String getName()
    - public String getmRace()
    - public double getMaxSpeed()
    - public double getDistanceRan()
    - public void setDistanceRan(double distanceRan)