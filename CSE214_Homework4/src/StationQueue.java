/**
 * Class that creates a queue of Stations
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
import java.util.LinkedList;

public class StationQueue extends LinkedList<Station>{
	int id = 1;
	//int id = this.peek().getId();
	/**
	 * The method adds a station to the end of the queue
	 * @param p
	 * Station to be put into the queue
	 */
	public void enqueue(Station s) { // can be full
		this.addLast(s);
	}

	/**
	 * The method removes the Station in the front of the queue
	 * @return
	 * Station that was removed from queue
	 */
	public Station dequeue() { // throws EmptyQueueException
		/*
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		} else {
			return this.removeFirst();
		}
		*/
		return this.removeFirst();
	}

	/*
	public String toString() {
		String s = "";
		for (int i = this.size(); i >= 0; i--) {
			s = s + this.get(i).toString();
			s += "\n";
		}
		return s;
	}
	*/

	/**
	 * The method retrieves the first Station in the queue
	 * @return
	 * First Station this queue
	 */
	public Station peek() {
		return this.peekFirst();
	}

	/**
	 * The method returns boolean value representing if the queue has no Stations
	 * @return
	 * True if queue is empty, false if not empty
	 */
	public boolean isEmpty() {
		if (this.getFirst() == null) {
			return true;
		} else {
			return false;
		}
		//return this.isEmpty();
	}
	
	//stations in the same line share passenger id numbers
	//getter
	public int getId() {
		return id;
	}
	
	//setter
	public void setId(int i) {
		id = i;
	}

	/*
	public void simulateTimeStep(int end) {
		//this.peek().simulateTimeStep();
		//id = this.peek().getId();
		for (int i = this.size() - 1; i >=0; i--) {
			//System.out.println(stopNames[k] + ":");
			System.out.println(this.get(i).getName());
			if (i > end) { // people stop arriving
				this.get(i).setFirstArrival(0);
				this.get(i).setSecondArrival(0);
				// make probability = 0 for each station
			}
			this.get(i).simulateTimeStep();
			//this.setId(this.get(i).getId());
			this.get(i).setId(this.get(i).getId());
			/*
			if (this.get(i).getHappened1()) { //this.get(i) first occurs, num++
				//this.get(i).setId(id);
				// make station's num = this num
				id++;
			}
			if(this.get(i).getHappened2()) { //this.get(i) second occurs, num++
				//this.get(i).setId(id);
				id++;
			}
			//set station's num = this num
			
			System.out.println(this.get(i).toString()); 
		}
		
	}*/
	
	
}
