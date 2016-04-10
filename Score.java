import java.io.Serializable;

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
		
	public void addCorrectAttempt(){
		attempts +=1;
		correctNum +=1;
	}
	
	public void addWrongAttempt(){
		attempts +=1;
	}
	
	public double getPercentage(){
		return correctNum/attempts;
	}


}
