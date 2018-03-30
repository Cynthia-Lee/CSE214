/**
 * Class that creates an object Passenger, a person who arrives at stations and
 * may board a train.
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class Passenger {
	private int id;
	private int arrivalTime;
	private boolean isFirstClass;
	private int waitTime = -1;
	// private Station pickedUp;
	/*
	 * public Passenger(int i, int a, boolean f) { id = i; arrivalTime = a;
	 * isFirstClass = f; }
	 */

	// getters and setters
	public int getId() {
		return id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public boolean getIsFirstClass() {
		return isFirstClass;
	}

	public void setId(int i) {
		id = i;
	}

	public void setArrivalTime(int i) {
		arrivalTime = i;
	}

	public void setIsFirstClass(boolean b) {
		isFirstClass = b;
	}

	public void setWaitTime(int i) {
		waitTime = i;
	}

	public int getWaitTime() {
		return waitTime;
	}

	/**
	 * Method describes Passenger in a string with id number and time arrived at station
	 * @return
	 * Passenger's description in a string
	 */
	public String toString() {
		return "P" + this.getId() + "@T" + this.getArrivalTime(); // P#@T#, ex: P3@T0
	}

	// public void setPickedUp(Station s) {
	// pickedUp = s;
	// }
}
