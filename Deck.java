import java.io.Serializable;
import java.util.ArrayList; 
import java.util.Collections; 

/** 
 * Holds and manages an array of cards, as well as an array of results.
 * Is given a name and category.
 * @author Flashcards Group
 * @date 4/10/16
 * @class CPSC 224 - Section 1
 * @assignment Group Project
 */
public class Deck implements Serializable{  

	private ArrayList<Card> cardList; 
	private String name; 
	private ArrayList<Score> resultList; 
	private boolean isManual; 
	private String category; 

	public Deck(){ 
		cardList = new ArrayList<Card>(); 
		name = ""; 
		resultList = new ArrayList<Score>(); 
		isManual = false; 
		category = "";
	} 

	/**
	 * 
	 * @param name the name of the deck
	 */
	public Deck(String name){ 
		this.name = name; 
		cardList = new ArrayList<Card>(); 
		resultList = new ArrayList<Score>(); 
		isManual = false; 
		category = "";
	} 

	/**
	 * 
	 * @param name the name of the deck 
	 * @param category the category of the deck 
	 */
	public Deck(String name, String category){ 
		this.name = name; 
		cardList = new ArrayList<Card>(); 
		resultList = new ArrayList<Score>(); 
		this.category = category; 
		isManual = false; 
	} 

	/**
	*Retrieves the deck's name
	*@return Returns the String name
	*/
	public String getName(){ 
		return name; 
	} 

	/**
	*Sets the name of the deck
	*@param name is the new name of the deck
	*/
	public void setName(String name){ 
		this.name = name; 
	} 
	
	/**
	*Retrieves the deck's category
	*@return Returns the String category
	*/
	public String getCategory(){
		return category;
	}
	
	/**
	*Sets the category of the deck
	*@param category is the new category of the deck
	*/
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	*Adds a new card to the deck
	*@post The card has been added to the deck
	*@param question is the new card's question
	*@param answer is the new card's answer
	*/
	public void addCard(String question, String answer){ 
		Card c = new Card(question,answer); 
		cardList.add(c); 
	} 

	/**
	*Removes a card from the deck
	*@pre There must be a card in the deck that corresponds to index
	*@post The card has been removed from the deck
	*@param index is the index of the card to be removed
	*/
	public void removeCard(int index){ 
		cardList.remove(index); 
	} 

	/**
	*Sets isManual to true
	*@post isManual has been set to true
	*/
	public void setManualOn(){ 
		isManual = true; 
	} 

	/**
	*Sets isManual to false
	*@post isManual has been set to false
	*/
	public void setManualOff(){ 
		isManual = false; 
	} 
	
	/**
	*Retrieves the value in isManual
	*@return Returns isManual
	*/
	public boolean getIsManual(){
		return isManual;
	}

	/**
	*Shuffles the deck so that the cards are in a new order
	*@post The cards are now in a new order
	*/
	public void shuffleDeck(){ 
		Collections.shuffle(cardList); 
	} 
	
	/**
	*Retrieves the size of the deck
	*@return Returns the size of cardList
	*/
	public int getSize() {
		return cardList.size();
	}
	
	/**
	*Retrieves a card from the list
	*@param index is the index of the card to be returned
	*@return Returns the card that is at the specified index
	*/
	public Card getCard(int index) {
		return cardList.get(index);
	}
	
	/**
	*Adds a new score to the deck's list of results
	*@param correct is the number of correct answers that the user had
	*/
	public void addResult(int correct) {
		Score result = new Score(cardList.size(), correct);
		resultList.add(result);
	}
	
	/**
	*Returns the list of all results for the deck
	*@return Returns the ArrayList resultList
	*/
	public ArrayList<Score> getResults() {
		return resultList;
	}

}  
