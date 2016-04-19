import java.io.Serializable;

/**
 * Class that holds information for a card, including an answer, a question, and a score. 
 * @author group
 *
 */
public class Card implements Serializable{  
	private String answer; 
	private String question;   
	private Score cardScore;
	
	/**
	 * Default constructor
	 */
	public Card(){
		cardScore = new Score();
		answer ="";
		question = "";
	}
	
	/**
	 * @param question the question for the card
	 * @param answer the answer for the card
	 */
	public Card(String question, String answer){ 
		cardScore = new Score();
		this.question = question; 
		this.answer = answer; 
	} 

	/**
	 * 
	 * @return answer the answer of the card
	 */
	public String getAnswer(){ 
		return answer; 
	} 

	/**
	 * 
	 * @return question the question of the card
	 */
	public String getQuestion(){ 
		return question; 
	} 

	/**
	 * 
	 * @param q the new question to be assigned to the card
	 */
	public void setQuestion(String q){ 
		question = q; 
	} 
	
	/**
	 * 
	 * @param a the answer to be assigned to the card
	 */
	public void setAnswer(String a){ 
		answer = a; 
	} 
	
	/**
	 * 
	 * @return cardScore the score object of the card
	 */
	public Score getScoreObject(){
		return cardScore;
	}
} 
