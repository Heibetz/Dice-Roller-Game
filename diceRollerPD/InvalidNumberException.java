/**
 * Hank Heiselbetz
 * class InvalidNumberException
 * Catches exception for too few dice or faces
 * Prints message if incorrect
 */
package diceRollerPD;

@SuppressWarnings("serial")
public class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}

