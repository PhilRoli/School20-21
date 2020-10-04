// import used for math.random + math.round in mRun function
import java.lang.Math;

public class Rennmaus {

	// Name eg: Mongolian racing rat
	private String name;
	// Race eg: Racing Rat
	private String mRace;
	// Max Speed in km/h
	private double maxSpeed;
	// Distance Ran
	private double distanceRan;

	// Rennmaus: String Owner Name, String Race of Mouse, double maxSpeed of mouse
	public Rennmaus(String name, String mRace, double maxSpeed) {

		this.name = name;
		this.mRace = mRace;
		this.maxSpeed = maxSpeed;
		this.distanceRan = 0.0;

	}

	// calculates the distance a moue ran trough math.random and rounds + returns result 
	public double mRun() {
		double disBefor = this.getDistanceRan();
		double distanceRan = this.getDistanceRan() + (Math.random() * this.maxSpeed);
		distanceRan = Math.round(distanceRan * 100) / 100;
		double disRan = distanceRan - disBefor;
		return disRan;
	}

	// puts name, race and max speed into return string
	public String toString() {
		String mouseData = ("Name: " + this.name + " | Race: " + this.mRace + " | Max Speed: " + this.maxSpeed + " km/h");
		return mouseData;
	}

	// Getters & Setters for variables
	public String getName() {
		return name;
	}

	public String getmRace() {
		return mRace;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public double getDistanceRan() {
		return distanceRan;
	}

	public void setDistanceRan(double distanceRan) {
		this.distanceRan = distanceRan;
	}
	
}
