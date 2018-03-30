/**
 * Class that creates an object Station, which trains will stop at
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class Station {
	private PassengerQueue firstClass = new PassengerQueue();
	private PassengerQueue secondClass = new PassengerQueue();
	private BooleanSource firstArrival; // set by user
	private BooleanSource secondArrival; // set by user
	private int idNum = 1;
	private int currentTime = 0;
	private boolean happened1;
	private boolean happened2;
	private String name;
	//private int firstServed; private int firstAvgTime;
	//private int secondServed; private int secondAvgTime;
	PassengerQueue servedFirst = new PassengerQueue();
	PassengerQueue servedSecond = new PassengerQueue();
	
	/**
	 * Constructor that creates a station and assigns it a name
	 * @param s
	 * Name of the station to be assigned
	 */
	public Station(String s) {
		name = s;
	}

	// Each station will have a probability for a first class and a second pass
	// passenger arrival at any given minute.
	/**
	 * Method that simulates 1 time unit that passes for the Station
	 */
	public void simulateTimeStep() { // Handles the arrival of passengers
		happened1 = false;
		happened2 = false;
		if (firstArrival.occurs()) {
			Passenger p = new Passenger();
			p.setId(idNum);
			p.setIsFirstClass(true);
			p.setArrivalTime(currentTime);
			firstClass.enqueue(p);
			idNum++;
			happened1 = true;
			//totalFirst++;
		}
		if (secondArrival.occurs()) {
			// Passenger p = new Passenger(idNum, currentTime, false);
			Passenger p = new Passenger();
			p.setId(idNum);
			p.setIsFirstClass(false);
			p.setArrivalTime(currentTime);
			secondClass.enqueue(p);
			idNum++;
			happened2 = true;
			//totalSecond++;
		}
		currentTime++;
	}
	
	/**
	 * Method that simulates 1 time unit that passes for the Station
	 * @param stationList
	 * Takes in a stationList, the StationQueue the Station is in
	 */
	public void simulateTimeStep(StationQueue stationList) { // Handles the arrival of passengers
		happened1 = false;
		happened2 = false;
		if (firstArrival.occurs()) {
			idNum = stationList.getId();
			Passenger p = new Passenger();
			p.setId(idNum);
			p.setIsFirstClass(true);
			p.setArrivalTime(currentTime);
			firstClass.enqueue(p);
			//idNum++;
			stationList.setId(idNum+1);
			happened1 = true;
			//totalFirst++;
		}
		if (secondArrival.occurs()) {
			idNum = stationList.getId();
			// Passenger p = new Passenger(idNum, currentTime, false);
			Passenger p = new Passenger();
			p.setId(idNum);
			p.setIsFirstClass(false);
			p.setArrivalTime(currentTime);
			secondClass.enqueue(p);
			//idNum++;
			stationList.setId(idNum+1);
			happened2 = true;
			//totalSecond++;
		}
		currentTime++;
	}

	// getters
	public PassengerQueue getFirstClass() {
		return firstClass;
	}

	public PassengerQueue getSecondClass() {
		return secondClass;
	}

	// setters
	public void setFirstArrival(double p) throws IllegalArgumentException {
		firstArrival = new BooleanSource(p);
	}

	public void setSecondArrival(double p) throws IllegalArgumentException {
		secondArrival = new BooleanSource(p);
	}

	/**
	 * String that describes the station with Passengers that arrive and list of first and second class passengers on the station
	 * @return
	 * String that describes the Station
	 */
	public String toString() {
		String s = "";
		/*
		if (happened1 == true) {
			s += "First class passenger ID " + (idNum - 2) + "arrives"; // peekLast()
			if (happened2 == true) {
				s += "Second class passenger ID" + (idNum - 1) + "arrives";
			} else {
				s += "No second class passenger arrives";
			}
		} else { // happened1 is false
			s += "No first class passenger arrives\n";
			if (happened2 == true) {
				s += "Second class passenger ID" + (idNum - 1) + "arrives";
			} else {
				s += "No second class passenger arrives";
			}
		}
		*/
		if (happened1 == true) {
			s += "First class passenger ID " + firstClass.peekLast().getId() + " arrives\n"; // peekLast()
		} else {
			s += "No first class passenger arrives\n";
		}
		if (happened2 == true) {
			s += "Second class passenger ID " + secondClass.peekLast().getId() + " arrives\n";
		} else {
			s += "No second class passenger arrives\n";
		}
		s += "Queues:\nFirst " + firstClass.toString() + "\nSecond " + secondClass.toString() + "\n";
		return s;
	}
	
	//setter and getters
	public void setId(int i) {
		idNum = i;
	}
	
	public int getId() {
		return idNum;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getHappened1() {
		return happened1;
	}
	
	public boolean getHappened2() {
		return happened2;
	}
	
	//public void setFirstServed(int i) {
	//	firstServed = i;
	//}
	
	//public void setSecondServed(int i) {
	//	secondServed = i;
	//}
	
	public PassengerQueue getServedFirst() {
		return servedFirst;
	}
		
	public PassengerQueue getServedSecond() {
		return servedSecond;
	}
}
