import java.io.Serializable;
import java.util.ArrayList; 

/**  
 * Holds and manages an array of decks, as well as contains a username. 
 * @author Katie Phillips (kphillips2) 
 * @date 4/7/16 
 * @class CPSC 224 - Section 1 
 * @assignment Group Project 
 */ 
public class User implements Serializable{ 
	private String username; 
	private ArrayList<Deck> decks;
	private double missCutoff;

	public User(String name) { 
		username = name; 
		decks = new ArrayList<>(); 
		missCutoff = .5;
	} 
	
	/**
	* Sets the cutoff for frequently missed
	* @param missCutoff is the new cutoff for frequently missed
	*/
	public void setMissCutoff(double missCutoff){
		this.missCutoff = missCutoff;
	}
	
	/**
	* Retrieves the cutoff for frequently missed
	* @return Returns the double missCutoff
	*/
	public double getMissCutoff(){
		return missCutoff;
	}

	/** 
	 *Retrieves a deck from the array 
	 *@pre There must be a deck in the list that has the given name 
	 *@param name is the name of the deck to be retrieved 
	 *@return Returns the deck that corresponds to the given name 
	 */ 
	public Deck getDeck(String name){ 
		Deck nDeck = new Deck(); 

		for(int i = 0; i < decks.size(); i++) { 
			Deck currentDeck = decks.get(i); 
			if(name.equals(currentDeck.getName())) { 
				nDeck = currentDeck; 
				break; 
			} 
		} 
		return nDeck; 
	} 

	/** 
	 *Adds a deck to the list 
	 *@post A new deck has been added to the list 
	 *@param name is the name of the new deck to be added 
	 *@param category is the category of the new deck to be added 
	 */ 
	public void addDeck(Deck deck) {  
		decks.add(deck); 
	} 

	/** 
	 *Removes a deck from the list 
	 *@pre There must be a deck in the list that has the given name 
	 *@post The deck has been removed from the list 
	 *@param name is the name of the deck to be removed 
	 */ 
	public void removeDeck(String name) { 
		for(int i = 0; i < decks.size(); i++) { 
			Deck currentDeck = decks.get(i); 
			if(name.equals(currentDeck.getName())) { 
				decks.remove(i); 
				break; 
			} 
		} 
	} 

	/** 
	 *Retrieves the user's username 
	 *@return Returns String username 
	 */ 
	public String getUsername() { 
		return username; 
	} 

	/** 
	 *Creates a deck that contains all cards from all decks that have that category 
	 *@param category is the category of the decks that should be used to make the new deck 
	 *@return Returns a deck that contains all cards from all decks that correspond to the given category 
	 */ 
	public Deck createCategoryDeck(String category) { 
		Deck categoryDeck = new Deck(); 

		for(int i = 0; i < decks.size(); i++) { 
			Deck current = decks.get(i); 
			String c = current.getCategory(); 

			if(c.equals(category)) { 
				for(int j = 0; j < current.getSize(); j++) { 
					Card newCard = current.getCard(j);
					categoryDeck.addCard(newCard.getQuestion(), newCard.getAnswer()); 
				} 

			}//end if 
		}//end for 

		return categoryDeck; 
	} 

	/** 
	 *Checks whether or not a deck in the list already has the given name 
	 *@param name is the deck name to be checked for 
	 *@return Returns true if a deck with that name already exists, false otherwise 
	 */ 
	public boolean isDeckNameTaken(String name) { 
		for(int i = 0; i < decks.size(); i++) { 
			Deck currentDeck = decks.get(i); 
			if(name.equals(currentDeck.getName())) return true; 
		} 

		return false; 
	} 

	/** 
	 *Creates a deck of frequently missed cards from a particular deck 
	 *@param deck is the deck that the cards shall be taken from 
	 *@return Returns a deck that contains the frequently missed cards from the given deck 
	 */ 
	public Deck createFreqMissed(Deck deck) { 
		Deck nDeck = new Deck(deck.getName(), deck.getCategory()); 
		if(deck.getIsManual()) nDeck.setManualOn();
		else nDeck.setManualOff();

		for(int i = 0; i < deck.getSize(); i++) { 
			Card currCard = deck.getCard(i); 
			if(currCard.getScoreObject().getPercentage() <= missCutoff) { 
				nDeck.addCard(currCard.getQuestion(), currCard.getAnswer()); 
			} 

		}//end for 

		return nDeck; 
	} 
	
	/**
	*Retrieves the number of decks that the user has
	*@return Returns the size of the ArrayList decks
	*/
	public int getNumberOfDecks() {
		return decks.size();
	}
}
