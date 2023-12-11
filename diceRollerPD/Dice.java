/**
 * Hank Heiselbetz
 * Class Dice
 * Creates Dice and sets a number of faces on them
 */

package diceRollerPD;
import java.util.Random;

public class Dice {
	private int numberOfFaces;
	private Random random;
	
	public Dice(int facesOnDice) {
		if(facesOnDice <= 0) {
			System.out.println("Error: Number of faces is less than 0.");
			System.exit(0);
		}
		this.numberOfFaces = facesOnDice;
	}
	
	//rollDice
	//Assigns the dice a random number to give it a roll
	public int rollDice() {
		this.random = new Random();
		return random.nextInt(numberOfFaces) + 1;
	}
	
	public int getNumberOfFaces() {
		return numberOfFaces;
	}
	
	public void setNumberOfFaces(int scanDie) {
		this.numberOfFaces = scanDie;
	}
}
