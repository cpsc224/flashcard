import java.io.Serializable;

public class Card implements Serializable{  
	private String answer; 
	private String question;   
	private Score cardScore;
	public Card(){
		cardScore = new Score();
		answer ="";
		question = "";
	}
	public Card(String question, String answer){ 
		cardScore = new Score();
		this.question = question; 
		this.answer = answer; 
	} 

	public String getAnswer(){ 
		return answer; 
	} 

	public String getQuestion(){ 
		return question; 
	} 

	public void setQuestion(String q){ 
		question = q; 
	} 
	
	public void setAnswer(String a){ 
		answer = a; 
	} 
	
	public Score getScoreObject(){
		return cardScore;
	}
} 
