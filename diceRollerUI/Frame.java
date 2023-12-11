/**
 * Hank Heiselbetz
 * class Frame
 * creates a frame and sets title
 */
package diceRollerUI;
import javax.swing.JFrame;


public class Frame extends JFrame{
	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dice Roller Counter");
		getContentPane().add(new Panel());
	}
}
