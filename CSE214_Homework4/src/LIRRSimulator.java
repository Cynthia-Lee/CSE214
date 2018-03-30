/**
 * Class that simulates trains arriving at stations and prints out each time step and statistics
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.Scanner;

public class LIRRSimulator {
	/**
	 * Main method lets user input values impacting the simulation such as
	 * probability of passengers arriving on each station.
	 */
	public static void main(String[] args) {
		// List of stations
		/*
		 * Station mineola = new Station(); Station hicksville = new Station(); Station
		 * syosett = new Station(); Station huntington = new Station();
		 */
		Station mineola = new Station("Mineola");
		Station hicksville = new Station("Hicksville");
		Station syosett = new Station("Syosett");
		Station huntington = new Station("Huntington");
		// Station[] LIRRStops = { huntington, syosett, hicksville, mineola };
		StationQueue LIRRStops = new StationQueue();
		LIRRStops.enqueue(huntington);
		LIRRStops.enqueue(syosett);
		LIRRStops.enqueue(hicksville);
		LIRRStops.enqueue(mineola);
		// String[] stopNames = { "Huntington", "Syosett", "Hicksville", "Mineola" };
		// List of trains (4)
		// StationQueue LIRR = ...
		// Train train1 = new Train
		// Train train1 = new Train(huntington, syosett, hicksville, mineola);
		// Train train2 = new Train(huntington, syosett, hicksville, mineola);
		// Train train3 = new Train(huntington, syosett, hicksville, mineola);
		// Train train4 = new Train(huntington, syosett, hicksville, mineola);
		// global variables
		int totalPassengersServed = 0;
		int numTrains = 0;
		int firstCap = 0;
		int secondCap = 0;
		int lastTime = 0;
		boolean loop = true;
		Train[] trains = new Train[0];
		Scanner input = new Scanner(System.in);
		// keep looping if the inputs are not valid, keep asking
		System.out.println("Welcome to the LIRR Simulator, Leaving Irate Riders Regularly");
		// do {
		for (int i = LIRRStops.size() - 1; i >= 0; i--) {
			System.out.println("\n" + LIRRStops.get(i).getName() + ":");
			System.out.print("Please enter first class of arrival probability: ");
			double f = input.nextDouble();
			try {
				LIRRStops.get(i).setFirstArrival(f);
			} catch (IllegalArgumentException ex) {
				System.out.println("Invalid first probability value");
				System.exit(1);

			}
			System.out.print("Please enter second class of arrival probability: ");
			double s = input.nextDouble();
			try {
				LIRRStops.get(i).setSecondArrival(s);
			} catch (IllegalArgumentException ex) {
				System.out.println("Invalid second probability value");
				System.exit(1);

			}
		}

		System.out.print("\nPlease enter the first class capacity: "); // of trains
		firstCap = input.nextInt();
		if (firstCap < 0) {
			System.out.println("Invalid first capacity number, it cannot be negative.");
			System.exit(1);
		}
		// train1.setFirstCapacity(firstCap);
		System.out.print("Please enter the second class capacity: "); // of trains
		secondCap = input.nextInt();
		if (secondCap < 0) {
			System.out.println("Invalid second capacity number, it cannot be negative.");
			System.exit(1);
		}
		System.out.print("Please enter the number of trains: ");
		numTrains = input.nextInt();
		if (numTrains < 1) {
			System.out.println("Cannot simulate with invalid number of trains");
			System.exit(1);
		}

		// Train[] trains = new Train[numTrains + 1]; // trains[0] is null
		trains = new Train[numTrains + 1];
		int untilFirstStop = 0;
		for (int i = 1; i <= numTrains; i++) {
			// trains[i] = new Train(huntington, syosett, hicksville, mineola);
			String trainName = "Train " + i;
			if (i == 1) { // 0 for train 1
				untilFirstStop = 0;
			} else {
				untilFirstStop = untilFirstStop - 5;
			}
			trains[i] = new Train(LIRRStops, trainName, untilFirstStop); // 0,5,10,15
			trains[i].setFirstCapacity(firstCap);
			trains[i].setSecondCapacity(secondCap);
		}

		System.out.print("Please enter last arrival time of passengers: ");
		// throw exception if after last station arrival of last train
		lastTime = input.nextInt();
		if (lastTime > (15 + (numTrains - 1) * 5)) {
			// throw new InvalidLastArrivalTimeException();
			System.out.println("Invalid length of simulation.");
			System.exit(1);
		}

		// } while (loop);

		System.out.println("Begin Simulation:\n---------------------------------------------");
		for (int i = 0; i <= (15 + (numTrains - 1) * 5); i++) { // time counter
			System.out.println("Time " + i + ":\n");
			System.out.println("Station overview:\n");
			// LIRRStops.simulateTimeStep((15 + (numTrains - 1) * 5));
			for (int k = LIRRStops.size() - 1; k >= 0; k--) {
				// System.out.println(stopNames[k] + ":");
				System.out.println(LIRRStops.get(k).getName());
				if (i > lastTime) { // people stop arriving
					LIRRStops.get(k).setFirstArrival(0);
					LIRRStops.get(k).setSecondArrival(0);
					// make probability = 0 for each station
				}
				/*
				 * if(LIRRStops.get(k).getHappened1()) {
				 * LIRRStops.get(k).getFirstClass().getLast().setId(id); id++; }
				 * if(LIRRStops.get(k).getHappened2()) {
				 * LIRRStops.get(k).getSecondClass().getLast().setId(id); id++; }
				 */

				// LIRRStops.get(k).simulateTimeStep(); // makes people spawn at stations
				LIRRStops.get(k).simulateTimeStep(LIRRStops);
				System.out.println(LIRRStops.get(k).toString());
			}

			System.out.println("Trains:");
			// tt.simulateTimeStep();
			// System.out.println(tt.toString());
			// trains[1].simulateTimeStep();
			// System.out.println(trains[1].toString());
			for (int t = 1; t <= numTrains; t++) {
				// trains[i].toString();
				// System.out.println(trains[i]);
				trains[t].simulateTimeStep();
				System.out.println(trains[t].toString());
			}

			System.out.println("-------");
		}

		System.out.println("At the end of the simulation:\n");
		int totalFirst = 0;
		int totalSecond = 0;
		int leftoverFirst = 0;
		int leftoverSecond = 0;
		for (int t = 1; t <= numTrains; t++) {
			totalFirst += trains[t].getFirstSeats().size();
			totalSecond += trains[t].getSecondSeats().size();
			// get each person in the train
			// first when person's boolean is true
			// read passenger's station that they were picked up

		}
		for (int i = 0; i < LIRRStops.size(); i++) {
			leftoverFirst += LIRRStops.get(i).getFirstClass().size();
			leftoverSecond += LIRRStops.get(i).getSecondClass().size();
		}
		totalPassengersServed = totalFirst + totalSecond;
		System.out.println("A total of " + totalPassengersServed + " passengers were served, " + leftoverFirst
				+ " first class pasengers were left without a seat, " + leftoverSecond
				+ " second class passengers were left without a seat.\n");
		for (int i = LIRRStops.size() - 1; i >= 0; i--) {
			Station s = LIRRStops.get(i);
			int sum1 = 0;
			int sum2 = 0;
			int avgWait1 = 0;
			int avgWait2 = 0;
			for (int x = 0; x < s.getServedFirst().size(); x++) {
				//System.out.println(s.getServedFirst().get(x).getWaitTime());
				sum1 = sum1 + s.getServedFirst().get(x).getWaitTime();
			}
			for (int w = 0; w < s.getServedSecond().size(); w++) {
				sum2 = sum2 + s.getServedSecond().get(w).getWaitTime();
			}
			if (s.getServedFirst().size() > 0) {
				avgWait1 = sum1 / s.getServedFirst().size();
			}
			if (s.getServedSecond().size() > 0) {
				avgWait2 = sum2 / s.getServedSecond().size();
			}
			System.out.println("At " + s.getName() + " " + s.getServedFirst().size()
					+ " first class passengers were served with an average wait time of " + avgWait1 + " min, "
					+ s.getServedSecond().size() + " second class passengers were served with an average wait time of "
					+ avgWait2 + " min. " + s.getFirstClass().size() + " first class passengers and "
					+ s.getSecondClass().size() + " second class passengers were left without a seat.\n");
		}
	}
}
