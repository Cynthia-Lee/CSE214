/**
 * This class constructs an object with a probability between 0 and 1
 * 
 * CSE 214-R12 Recitation, CSE 214-02 Lecture
 * @author Cynthia Lee
 * e-mail: cynthia.lee.2@stonybrook.edu
 * Stony Brook ID: 111737790
 */
public class BooleanSource {
	private double probability;

	/**
	 * Creates an object with a probability number
	 * @param p
	 * Probability the object should have
	 * @throws IllegalArgumentException
	 * If the probability is less than 0 or greater than 1
	 */
	public BooleanSource(double p) throws IllegalArgumentException {
		if (p < 0.0 || p > 1.0) {
			throw new IllegalArgumentException();
		}
		probability = p;
	}
	
	/**
	 * Generates if probability happened/occurred through Math.random 
	 * @return
	 * True if Math.random() less than probability, otherwise return false
	 */
	public boolean occurs() {
		return (Math.random() < probability);
	}
}
