
package diceRollerPD;
import diceRollerPD.Dice;
import diceRollerUI.Frame;
import diceRollerUI.Panel;
import diceRollerUI.StartUI;
import diceTest.DiceRoll;

/**
 * Creates a dicebag of dice
 * rolls the dice
 * stores the numbers
 * @author Hank Heiselbetz
 */
public class DiceBag {
	private int numberOfDice;
	private Dice dice;
	private int runningTotal;
	private int rolledDice[];
	
	//constructor for setting the DiceBag
	public DiceBag(int amountOfDice, int facesOnDice) {
		this.numberOfDice = amountOfDice;
		setRolledDice(new int[amountOfDice]);
		dice = new Dice(facesOnDice);
	}

	/**
	 * sets number of dice
	 * @param numberOfDice
	 */
	public void setNumberOfDice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}
	
	public int getNumberOfDice() {
		return numberOfDice;
	}
	
	//rollAllDice
	//Passed facesOnDice
	//returns the running total
	//This also outputs the frequencies of numbers rolled 
	public int rollAllDice(int facesOnDice) {
		int[] frequencies = new int[facesOnDice];
		for(int i = 0; i < getNumberOfDice(); i++) {
			rolledDice[i] = dice.rollDice();
			frequencies[rolledDice[i] - 1]++;
			runningTotal = runningTotal + getRolledDice()[i];
	    }	
		
		for(int i = 0; i < facesOnDice; i++) {
			System.out.println("Frequency of face " + (i + 1) + ": " + frequencies[i]);
		}
		
		return runningTotal;
	}

	public int[] getRolledDice() {
		return rolledDice;
	}

	public void setRolledDice(int rolledDice[]) {
		this.rolledDice = rolledDice;
	}
}
