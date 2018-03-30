/**
 * Class that creates a queue of Passengers
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.LinkedList;

public class PassengerQueue extends LinkedList<Passenger> {

	/**
	 * The method adds a passenger to the end of the queue
	 * @param p
	 * Passenger to be put into the queue
	 */
	public void enqueue(Passenger p) { // can be full
		this.addLast(p);
	}

	/**
	 * The method removes the passenger in the front of the queue
	 * @return
	 * Passenger that was removed from queue
	 */
	public Passenger dequeue() { // throws EmptyQueueException
		/*
		 * if (this.isEmpty()) { throw new EmptyQueueException(); } else { return
		 * this.removeFirst(); }
		 */
		Passenger temp = this.peek();
		this.removeFirst();
		return temp;
	}

	/**
	 * Method describes Passenger queue in a String, lists out each Passenger's description
	 * @return
	 * Passenger queue's description in a string 
	 */
	public String toString() {
		String s = "[";
		if (this.isEmpty()) {
			s += "empty]";
		} else {
			for (int i = 0; i < this.size(); i++) {
				// s = s + "P" + this.get(i).getId() + "@T" + this.get(i).getArrivalTime(); //
				// P#@T#, ex: P3@T0
				s += this.get(i).toString();
				if (i < this.size() - 1) {
					s += ",";
				}
			}
		}
		return s;
	}

	/**
	 * The method retrieves the first Passenger in the queue
	 * @return
	 * First Passenger this queue
	 */
	public Passenger peek() {
		return this.peekFirst();
	}

	/**
	 * The method returns boolean value representing if the queue has no Passengers
	 * @return
	 * True if queue is empty, false if not empty
	 */
	public boolean isEmpty() {
		if (this.size() == 0) {// if (this.getFirst() == null) {
			return true;
		} else {
			return false;
		}
		// return this.isEmpty();
	}
}
