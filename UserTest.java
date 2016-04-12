import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUser() {
		User tester = new User("New user");
		assertEquals("0 decks in new user", 0, tester.getNumberOfDecks());
		assertTrue((tester.getUsername()).equals("New user"));
		assertTrue(tester.getMissCutoff() == .5);
	}
	
	@Test
	public void testSetMissCutoff(){
		User tester = new User("New user");
		tester.setMissCutoff(.2);
		assertTrue(tester.getMissCutoff() == .2);
	}
	
	@Test
	public void testGetMissCutoff(){
		User tester = new User("New user");
		tester.setMissCutoff(.2);
		assertTrue(tester.getMissCutoff() == .2);
	}

	@Test
	public void testGetDeck() {
		User tester = new User("New");
		Deck testDeck = new Deck("Deck name", "cat");
		testDeck.addCard("a", "b");
		tester.addDeck(testDeck);
		Deck testDeck2 = tester.getDeck("Deck name");
		assertTrue((testDeck2.getCategory()).equals("cat"));
		assertEquals("The deck has 1 card", 1, testDeck.getSize());
	}

	@Test
	public void testAddDeck() {
		User tester = new User("New");
		Deck testDeck = new Deck("Deck name", "cat");
		tester.addDeck(testDeck);
		assertEquals("There is 1 deck", 1, tester.getNumberOfDecks());
	}

	@Test
	public void testRemoveDeck() {
		User tester = new User("New");
		Deck testDeck0 = new Deck("a", "b");
		Deck testDeck1 = new Deck("c", "d");
		Deck testDeck2 = new Deck("e", "f");
		tester.addDeck(testDeck0);
		tester.addDeck(testDeck1);
		tester.addDeck(testDeck2);
		tester.removeDeck("a");
		assertEquals("There are 2 decks", 2, tester.getNumberOfDecks());
		tester.removeDeck("c");
		assertEquals("There is 1 deck", 1, tester.getNumberOfDecks());
	}

	@Test
	public void testGetUsername() {
		User tester = new User("This Name");
		assertTrue((tester.getUsername()).equals("This Name"));
	}

	@Test
	public void testCreateCategoryDeck() {
		User tester = new User("New");
		Deck testDeck0 = new Deck("a", "cat");
		Deck testDeck1 = new Deck("c", "cat");
		Deck testDeck2 = new Deck("f", "not cat");
		Deck testDeck3 = new Deck("e", "cat");
		
		testDeck0.addCard("q0", "a0");
		testDeck1.addCard("q1", "a1");
		testDeck1.addCard("q1.5", "a1.5");
		testDeck2.addCard("q2", "a2");
		testDeck2.addCard("q2.5", "a2.5");
		testDeck3.addCard("q3", "a3");
		testDeck3.addCard("q3.5", "a3.5");
		
		tester.addDeck(testDeck0);
		tester.addDeck(testDeck1);
		tester.addDeck(testDeck2);
		tester.addDeck(testDeck3);
		
		Deck catDeck = tester.createCategoryDeck("cat");
		assertEquals("There are 5 cards", 5, catDeck.getSize());
		
		Card card0 = catDeck.getCard(0);
		Card card1 = catDeck.getCard(1);
		Card card2 = catDeck.getCard(2);
		Card card3 = catDeck.getCard(3);
		Card card4 = catDeck.getCard(4);
		
		boolean same0 = (card0.getQuestion()).equals("q0") && (card0.getAnswer()).equals("a0");
		boolean same1 = (card1.getQuestion()).equals("q1") && (card1.getAnswer()).equals("a1");
		boolean same2 = (card2.getQuestion()).equals("q1.5") && (card2.getAnswer()).equals("a1.5");
		boolean same3 = (card3.getQuestion()).equals("q3") && (card3.getAnswer()).equals("a3");
		boolean same4 = (card4.getQuestion()).equals("q3.5") && (card4.getAnswer()).equals("a3.5");
		
		assertTrue(same0 && same1 && same2 && same3 && same4);
	}

	@Test
	public void testIsDeckNameTaken() {
		User tester = new User("username");
		Deck testDeck = new Deck("Deck Name");
		tester.addDeck(testDeck);
		assertTrue(tester.isDeckNameTaken("Deck Name"));
		assertFalse(tester.isDeckNameTaken("Deck Name2"));
	}

	@Test
	public void testCreateFreqMissed() {
		User tester = new User("username");
		Deck testDeck = new Deck("deck");
		testDeck.setManualOn();
		tester.addDeck(testDeck);
		testDeck.addCard("a", "b");
		testDeck.addCard("c", "d");
		testDeck.addCard("e", "f");
		testDeck.addCard("g", "h");
		testDeck.addCard("i", "j");
		
		Card card0 = testDeck.getCard(0),
				card1 = testDeck.getCard(1),
				card2 = testDeck.getCard(2),
				card3 = testDeck.getCard(3),
				card4 = testDeck.getCard(4);
		
		Score score0 = new Score(5, 1), //0.2
				score1 = new Score(5, 3), //0.6
				score2 = new Score(5, 4), //0.8
				score3 = new Score(5, 0), //0
				score4 = new Score(5, 2); //0.4
		
		card0.setCardScore(score0);
		card1.setCardScore(score1);
		card2.setCardScore(score2);
		card3.setCardScore(score3);
		card4.setCardScore(score4);
		
		Deck fmDeck = tester.createFreqMissed(testDeck);
		assertEquals("F.M. Deck has 3 cards", 3, fmDeck.getSize());
		
		card0 = fmDeck.getCard(0);
		card1 = fmDeck.getCard(1);
		card2 = fmDeck.getCard(2);
		
		boolean same0 = (card0.getQuestion()).equals("a") && (card0.getAnswer()).equals("b");
		boolean same1 = (card1.getQuestion()).equals("g") && (card1.getAnswer()).equals("h");
		boolean same2 = (card2.getQuestion()).equals("i") && (card2.getAnswer()).equals("j");
		
		assertTrue(same0 && same1 && same2);
	}
	
	@Test
	public void testGetNumberOfDecks(){
		User tester = new User("");
		assertEquals("0 decks", 0, tester.getNumberOfDecks());
		tester.addDeck(new Deck());
		assertEquals("1 deck", 1, tester.getNumberOfDecks());
		tester.addDeck(new Deck());
		assertEquals("2 decks", 2, tester.getNumberOfDecks());
	}

}
