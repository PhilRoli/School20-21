# RolP_250920_Rennmaus

[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/PhilRoli/School20-21/pulls)

Java Project where we had to make a class Race and class Rennmaus. These, in addition to a testeRennmaus test file, can simulate a race between mice.

Some are English or German only, some are mixed. If you have any questions you can send me a DM on [twitter](https://twitter.com/Phil_Roli).

_Rennmaus == Race Mouse / Rennmouse_

---

## Functions

---

### [Race.java][race]

- **[Race(String raceName, int nParticipants, double runDistance)][RaceCon]**: Constructer for the class Race, String raceName > Name of the Race / int nParticipants > Number of Participants / double runDistance > Distance the Race lasts for.

- **[public void addRaceMice (Rennmouse neueMaus)][addRaceMice]**: Adds a Rennmaus object to the ArrayList of the Race.

- **[public void removeRaceMice (String Name)][removeRaceMice]**: Goes trough the ArrayList and removes the first Rennmouse object in the List that shares the name Attribute with the given name.

- **[public String toString()][toString]**: Puts all info about the Race and the mice in it into a return String.

- **[private void letMouseRun()][letMouseRun]**: First checks if the int currentMouse is bigger / same then the number of participants. After the check, the currentMouse is allowed to run with the help of the Rennmousee.java mRun function.

- **[private Rennmousee getWinner()][getWinner]**: checks if the current mouse has run more distance then the race is long, if so sets the winner to true and returns said mouse. If not, adds +1 to currentMouse and the process starts from the start.

- **[public void raceRace()][raceRace]**: Starts the race, works with the help of the getWinner & letMouseRun functions. if Winner == true, ends the programm.

### [Rennmouse.java][rennmaus]

- **[public Rennmouse(String name, String mRace, double maxSpeed)][Rennmouse]**: Constructer for the class Rennmouse, String name > Name of the Owner, String mRace > Race of the Race Mouse, double maxSpeed > max Speed of the Mouse

- **[public double mRUn()][mRUn]**: if called, adds a rounded randome double to a varible disRan and then retruns said varible.

- **[public String toString()][toString]**: Returns all info about the current mouse as a String

- **[Getters & Setters][GetAndSet]**: Getters and Setters that are used
  - public String getName()
  - public String getmRace()
  - public double getMaxSpeed()
  - public double getDistanceRan()
  - public void setDistanceRan(double distanceRan)

<!-- Links Used, Ignore -->

[race]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Race.java
<!-- Links to race.java functions -->
[RaceCon]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Race.java#L21
[addRaceMice]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Race.java#L28
[removeRaceMice]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Race.java#L35
[toString]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Race.java#L51
[letMouseRun]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Race.java#L75
[getWinner]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Race.java#L91
[raceRace]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Race.java#L106

[rennmaus]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Rennmaus.java
<!-- Links to race.java functions -->
[Rennmouse]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Rennmaus.java#16
[mRUn]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Rennmaus.java#26
[toString]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Rennmaus.java#35
[GetAndSet]: https://github.com/PhilRoli/School20-21/blob/master/RolP_250920_Rennmaus/src/Rennmaus.java#40
