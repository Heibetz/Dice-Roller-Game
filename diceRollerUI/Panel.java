package diceRollerUI;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import diceRollerPD.Dice;
import diceRollerPD.DiceBag;
import diceRollerPD.InvalidNumberException;
import diceTest.DiceRoll;

/**
 * OOP Dice Roller Project
 * class Panel
 * Outputs a GUI
 * Allows users to press buttons which add to the dice
 * and faces of dice and to roll the dice
 * @package diceRollerUI
 * @author Hank Heiselbetz 
 */

@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	private JTextField numberOfDiceField; //allows the user to input numbers into dice and face
	private JTextField numberOfFacesField;
	private JButton rollDice; //this button is used for rolling the dice
	private JLabel label; //creates a label to keep track of how many faces on dice
	private JLabel numberOfDiceLabel; //creates a label to keep track of the number of dice
	private JLabel numberOfFacesLabel; //creates a label to keep track of the number of faces
	private JLabel resultLabel; // sets the results
	private int count; //keeps count of faces on dice
	private int countOfDice; //keeps count of dice
	private int runningTotal = 0; //keeps track of all the dice added together

	//constructor to put together the GUI
	public Panel() {
		
		//sets the user to type into the number of dice 
		JLabel numberOfDiceLabel = new JLabel("Number of Dice");
		this.add(numberOfDiceLabel);
		numberOfDiceField = new JTextField();
		this.add(numberOfDiceField);
		numberOfDiceField.setColumns(3);
		
		//sets the user to type in the number of faces 
		JLabel numberOfFacesLabel = new JLabel("Number of Faces");
		this.add(numberOfFacesLabel);
		numberOfFacesField = new JTextField();
		this.add(numberOfFacesField);
		numberOfFacesField.setColumns(3);
	
		rollDice = new JButton("Click to roll the dice");
		/**
		 * Creates a new button to roll the dice
		 * @throws InvalidNumberException -- Throws exception if dice or faces is less than 1
		 */
		rollDice.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				try {
					int numberOfDice = Integer.parseInt(numberOfDiceField.getText());
					int numberOfFaces = Integer.parseInt(numberOfFacesField.getText());
					
					//checks to see if number of dice and faces is valid
					if(numberOfDice <= 0) {
						numberOfDice = 0;
						throw new InvalidNumberException("number of dice can't be less than 1");
					}
					if(numberOfFaces <= 0 ) {
						numberOfFaces = 0;
						throw new InvalidNumberException("number of faces can't be less than 1");
					}
					
					//creates a new diceBag and rolls it and gets the running total
					DiceBag diceBag = new DiceBag(numberOfDice, numberOfFaces);
					runningTotal = diceBag.rollAllDice(numberOfFaces);
					
					//gets total results and all dice rolled
					int[] results = diceBag.getRolledDice();
					
					//Displays each roll with the for loop and after displays the running total
					String resultText = "Roll results: ";
					for (int result : results)
					{
						resultText += result + ", ";
					}
					resultText += "	   Total: " + runningTotal;
					
					//shows the value of each dice rolled
					resultLabel.setText(resultText);
				}
				//catches any errors
				catch (InvalidNumberException exception)
				{
					resultLabel.setText(exception.getMessage());
				}
				
			}
		});
		//adds this method to the screen
		this.add(rollDice);
		
		//displays the results 
		resultLabel = new JLabel ();
		this.add(resultLabel);
		
		//sets preferred size
		setPreferredSize(new Dimension(300, 300));
		
	}
}

		

		


