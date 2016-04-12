import java.io.Serializable;

/** 
 * Holds and manages number of attempts and number of correct attempts. Is able to calculate
 * a percentage using these values.
 * @author Flashcards Group
 * @date 4/12/16
 * @class CPSC 224 - Section 1
 * @assignment Group Project
 */
public class Score implements Serializable {
	private int attempts, correctNum;

	Score(){
		attempts = 0;
		correctNum = 0;
	}
	
	Score(int attempts, int correctNum){
		this.attempts = attempts;
		this.correctNum = correctNum;
	}
	
	/**
	*Adds a correct attempt to the score
	*@post Both attempts and correctNum have had 1 added to them
	*/	
	public void addCorrectAttempt(){
		attempts +=1;
		correctNum +=1;
	}
	
	/**
	*Adds an incorrect attempt to the score
	*@post Attempts has been updated to plus 1
	*/
	public void addWrongAttempt(){
		attempts +=1;
	}
	
	/**
	*Retrieves the score's percentage
	*@return Returns a double value that is correct answers divided by attempts
	*/
	public double getPercentage(){
		return (double) correctNum / (double) attempts;
	}


}
