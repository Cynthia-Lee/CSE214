/**
 * Class that creates an object of a Train that will be able to hold Passengers and visit Stations
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class Train {
	private int firstCapacity; // set by user
	private int secondCapacity; // set by user
	private int timeUntilNextArrival;
	// it will contain a queue of stations
	// Station[] stations = new Station[4];
	private Station currentStop;
	private int currentTime = 0;
	private int stopIndex = 0;
	private int untilFirstStop = 0;
	private boolean noMoreStops = false;
	private PassengerQueue embarked1 = new PassengerQueue();
	private PassengerQueue embarked2 = new PassengerQueue();
	/*
	 * Passenger[] firstSeats = new Passenger[firstCapacity]; Passenger[]
	 * secondSeats = new Passenger[secondCapacity];
	 */
	private PassengerQueue firstSeats = new PassengerQueue();
	private PassengerQueue secondSeats = new PassengerQueue();
	String name = "";
	/*
	 * int countFirst = 0; int countSecond = 0;
	 */
	private StationQueue stations = new StationQueue();
	// Station currentStop = stations.dequeue(); // starting stop
	/*
	 * public Train(Station s1, Station s2, Station s3, Station s4) { stations[0] =
	 * s1; stations[1] = s2; stations[2] = s3; stations[3] = s4; }
	 */
	// private String embark1;
	// private String embark2;

	/**
	 * Constructor that creates a Train and assigns it a StationQueue (stations it will stop at)
	 * @param s
	 * StationQueue with stations the train will stop at
	 */
	public Train(StationQueue s) {
		stations = s;
		currentStop = s.peek();
	}

	/**
	 * Constructor that creates a Train and assigns it a StationQueue, name, and time until it reaches the first Station
	 * @param s
	 * StationQueue with stations the train will stop at
	 * @param n
	 * String assigning a name to the train
	 * @param t
	 * Integer time that respresents time until the train reaches the first station
	 */
	public Train(StationQueue s, String n, int t) {
		stations = s;
		name = n;
		untilFirstStop = t;
		currentStop = s.peek();
	}

	/**
	 * Method simulates 1 unit of time for the train
	 */
	public void simulateTimeStep() {
		// Simulates the passing of one time step, and dequeues passengers from stations
		// when appropriate
		// if (stationIndex < 4) {
		// System.out.println(timeUntilNextArrival);
		// if (stopIndex < 4 && timeUntilNextArrival >= 0) {
		// if (stopIndex < 4 && timeUntilNextArrival + 1 >= 0) {
		if (stopIndex < stations.size() && untilFirstStop >= 0) {
			// System.out.println(timeUntilNextArrival+"in");
			currentStop = stations.get(stopIndex);
			// System.out.println(timeUntilNextArrival + "in" + stopIndex);
			// if (!stations.isEmpty()) {
			// embark1 = "none";
			// embark2 = "none";
			// currentStop = stations[stationIndex]; // changing the head
			// currentStop = stations.dequeue();
			// currentStop = stations.peek();
			if (currentTime % 5 == 0) { // train at station = pick up people (first class)
				embarked1.clear();
				embarked2.clear();
				// System.out.println("inside a stop");
				// if (currentTime % 5 == 0)
				// System.out.println("take from here" + stations.get(stopIndex).getName());
				while (!(currentStop.getFirstClass().isEmpty()) && (firstSeats.size() < firstCapacity)) { // while
					// check if can take first class person
					// System.out.println("take from here" + stations.get(stopIndex).getName());
					// while ((firstSeats.size() < firstCapacity)) {
					// System.out.println("take from here" + stations.get(stopIndex).getName());
					// firstSeats.enqueue(currentStop.getFirstClass().dequeue());
					Passenger person = currentStop.getFirstClass().peek();
					firstSeats.enqueue(person);
					person.setWaitTime(currentTime - person.getArrivalTime());
					currentStop.getServedFirst().enqueue(person);
					embarked1.enqueue(person);
					// System.out.println(currentStop.getFirstClass());
					currentStop.getFirstClass().dequeue();
					// }
				}
				//System.out.println("Loop condition, station first class pass empty?" + 
				//currentStop.getFirstClass() + "first seats" + firstSeats.size() + firstCapacity + "2nd seats"
				//+ secondSeats.size() + secondCapacity);
				//firstSeats.size() > firstCapacity
				while (!(currentStop.getFirstClass().isEmpty()) && (firstSeats.size() >= firstCapacity) // while
						&& (secondSeats.size() < secondCapacity)) {
					// if there is a first class person, and second class empty
					// put first class person in second class seat
					// while (secondSeats.size() < secondCapacity) {
					// secondSeats.enqueue(currentStop.getFirstClass().dequeue());
					// }
					Passenger person = currentStop.getFirstClass().peek();
					secondSeats.enqueue(person);
					person.setWaitTime(currentTime - person.getArrivalTime());
					currentStop.getServedFirst().enqueue(person);
					embarked2.enqueue(person);
					//System.out.println("PassengerID Second " + person.getId());
					currentStop.getFirstClass().dequeue();
				}
				// after first is second class
				while (!(currentStop.getSecondClass().isEmpty()) && (secondSeats.size() < secondCapacity)) {
					Passenger person = currentStop.getSecondClass().peek();
					person.setWaitTime(currentTime - person.getArrivalTime());
					currentStop.getServedSecond().enqueue(person);
					embarked2.enqueue(person);
					secondSeats.enqueue(currentStop.getSecondClass().dequeue());
				}
				// stationIndex += 1;
				// currentStop = stations.dequeue();
				// stations.dequeue();
				stopIndex = stopIndex + 1;
			} else { // train not at station
				timeUntilNextArrival = 5 - (currentTime % 5);
			}
		} else if (untilFirstStop < 0) { // not at first stop yet
			timeUntilNextArrival = untilFirstStop;
			untilFirstStop++;
		} else if (stopIndex == stations.size()) { // after it hits the last stop
			noMoreStops = true;
		}
		// if (untilFirstStop < 0) {
		// System.out.println(untilFirstStop);
		// timeUntilNextArrival = untilFirstStop + currentTime;
		// untilFirstStop++;
		// }
		// System.out.println("time until next arrival" + timeUntilNextArrival);
		// System.out.println("untilFirststop" + untilFirstStop);
		// System.out.println(untilFirstStop);
		currentTime = currentTime + 1;
	}

	/*
	 * // add and set up stations public void setStation(Station s) {
	 * stations.enqueue(s); }
	 */

	// setters
	public void setFirstCapacity(int i) {
		firstCapacity = i;
	}

	public void setSecondCapacity(int i) {
		secondCapacity = i;
	}

	// getters
	public PassengerQueue getFirstSeats() {
		return firstSeats;
	}

	public PassengerQueue getSecondSeats() {
		return secondSeats;
	}

	/**
	 * Method that has a String that describes the train with times until next arrival, 
	 * what station it is at, Passengers that board, and if it stops picking up Passengers
	 * @return
	 * String that describes the train
	 */
	public String toString() {
		// if (stopIndex < 4) {
		// System.out.println("stop Index" + stopIndex);
		// System.out.println(noMoreStops);
		if (noMoreStops) { // after it arrives at the last stop (mineola)
			return this.name + " has stopped picking up passengers.\n";
		}
		if ((currentTime - 1) % 5 == 0 && timeUntilNextArrival + 1 >= 0) {// && untilFirstStop >= 0) { // at a stop
			String embarkedPassengers1 = "";
			String embarkedPassengers2 = "";
			if (this.embarked1.isEmpty()) {
				embarkedPassengers1 = "none";
			} else {
				for (int i = 0; i < embarked1.size(); i++) {
					embarkedPassengers1 = embarkedPassengers1 + "P" + (embarked1.get(i)).getId();
					if (i < embarked1.size() - 1) {
						embarkedPassengers1 += ", ";
					}
					// embarked1.dequeue();
				}
			}
			if (this.embarked2.isEmpty()) {
				embarkedPassengers2 = "none";
			} else {
				for (int i = 0; i < embarked2.size(); i++) {
					embarkedPassengers2 = embarkedPassengers2 + "P" + (embarked2.get(i)).getId();
					if (i < embarked2.size() - 1) {
						embarkedPassengers2 += ", ";
					}
					// embarked1.dequeue();
				}
			}
			int originalFirstSeats = firstSeats.size() - embarked1.size();
			int originalSecondSeats = secondSeats.size() - embarked2.size();
			return this.name + " arrives at " + this.currentStop.getName() + ", there are " + originalFirstSeats
					+ " passengers in first class and " + originalSecondSeats + " in second class.\n"
					+ "Passengers embarking in first class: " + embarkedPassengers1
					+ "\nPassengers embarking in second class: " + embarkedPassengers2 + "\n";
		} else { // not at a stop
			int time = timeUntilNextArrival;
			if (time < 0) {
				time = time * -1;
			}
			return this.name + " will arrive in " + this.currentStop.getName() + " in " + time + " minutes\n";
		}
		// } else {
		// return this.name + " has stopped picking up passengers.";
		// }
	}

}
