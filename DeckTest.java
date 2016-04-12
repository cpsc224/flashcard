import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DeckTest {

	@Test
	public void testDeck() {
		Deck tester = new Deck();
		assertTrue((tester.getName()).equals(""));
		assertTrue((tester.getCategory()).equals(""));
		assertFalse(tester.getIsManual());
		assertEquals("Size of new deck is 0", 0, tester.getSize());
		ArrayList <Score> results = tester.getResults();
		assertEquals("0 results for new deck", 0, results.size());
	}

	@Test
	public void testDeckString() {
		Deck tester = new Deck("new");
		assertTrue((tester.getName()).equals("new"));
		assertTrue((tester.getCategory()).equals(""));
		assertFalse(tester.getIsManual());
		assertEquals("Size of new deck is 0", 0, tester.getSize());
		ArrayList <Score> results = tester.getResults();
		assertEquals("0 results for new deck", 0, results.size());
	}

	@Test
	public void testDeckStringString() {
		Deck tester = new Deck("new", "cat");
		assertTrue((tester.getName()).equals("new"));
		assertTrue((tester.getCategory()).equals("cat"));
		assertFalse(tester.getIsManual());
		assertEquals("Size of new deck is 0", 0, tester.getSize());
		ArrayList <Score> results = tester.getResults();
		assertEquals("0 results for new deck", 0, results.size());
	}

	@Test
	public void testGetName() {
		Deck tester = new Deck();
		assertTrue((tester.getName()).equals(""));
		tester.setName("deck name");
		assertTrue((tester.getName()).equals("deck name"));
	}

	@Test
	public void testSetName() {
		Deck tester = new Deck();
		tester.setName("deck name");
		assertTrue((tester.getName()).equals("deck name"));
	}

	@Test
	public void testGetCategory() {
		Deck tester = new Deck();
		assertTrue((tester.getCategory()).equals(""));
		tester.setCategory("cat");
		assertTrue((tester.getCategory()).equals("cat"));
	}

	@Test
	public void testSetCategory() {
		Deck tester = new Deck();
		tester.setCategory("cat");
		assertTrue((tester.getCategory()).equals("cat"));
	}

	@Test
	public void testAddCard() {
		Deck tester = new Deck();
		tester.addCard("a", "b");
		tester.addCard("c", "d");
		assertEquals("Size has been updated to 2", 2, tester.getSize());
		Card testCard1 = tester.getCard(0);
		Card testCard2 = tester.getCard(1);
		assertTrue((testCard1.getQuestion()).equals("a"));
		assertTrue((testCard2.getQuestion()).equals("c"));
	}

	@Test
	public void testRemoveCard() {
		Deck tester = new Deck();
		tester.addCard("a", "b");
		tester.addCard("c", "d");
		tester.addCard("e", "f");
		tester.removeCard(0);
		assertEquals("Size has been updated to 2", 2, tester.getSize());
		Card testCard1 = tester.getCard(0);
		Card testCard2 = tester.getCard(1);
		assertTrue((testCard1.getQuestion()).equals("c"));
		assertTrue((testCard2.getQuestion()).equals("e"));
		tester.removeCard(1);
		assertEquals("Size has been updated to 1", 1, tester.getSize());
		testCard1 = tester.getCard(0);
		assertTrue((testCard1.getQuestion()).equals("c"));
	}

	@Test
	public void testSetManualOn() {
		Deck tester = new Deck();
		tester.setManualOn();
		assertTrue(tester.getIsManual());
	}

	@Test
	public void testSetManualOff() {
		Deck tester = new Deck();
		tester.setManualOff();
		assertFalse(tester.getIsManual());
	}

	@Test
	public void testGetIsManual() {
		Deck tester = new Deck();
		tester.setManualOff();
		assertFalse(tester.getIsManual());
		tester.setManualOn();
		assertTrue(tester.getIsManual());
	}

	@Test
	public void testShuffleDeck() {
		Deck tester = new Deck();
		tester.addCard("a", "b");
		tester.addCard("c", "d");
		tester.addCard("e", "f");
		tester.addCard("g", "h");
		tester.addCard("i", "j");
		tester.addCard("k", "l");
		tester.addCard("m", "n");
		tester.addCard("o", "p");
		tester.shuffleDeck();
		
		Card testCard0 = tester.getCard(0),
				testCard1 = tester.getCard(1),
				testCard2 = tester.getCard(2),
				testCard3 = tester.getCard(3),
				testCard4 = tester.getCard(4),
				testCard5 = tester.getCard(5),
				testCard6 = tester.getCard(6),
				testCard7 = tester.getCard(7);
		
		boolean cardsInSamePlace = (testCard0.getQuestion()).equals("a") &&
				(testCard1.getQuestion()).equals("c") &&
				(testCard2.getQuestion()).equals("e") &&
				(testCard3.getQuestion()).equals("g") &&
				(testCard4.getQuestion()).equals("i") &&
				(testCard5.getQuestion()).equals("k") &&
				(testCard6.getQuestion()).equals("m") &&
				(testCard7.getQuestion()).equals("o");
	
		assertFalse(cardsInSamePlace);
		
	}

	@Test
	public void testGetSize() {
		Deck tester = new Deck();
		assertEquals("Size of new deck is 0", 0, tester.getSize());
		tester.addCard("", "");
		assertEquals("Size of deck with 1 card is 1", 1, tester.getSize());
	}

	@Test
	public void testGetCard() {
		Deck tester = new Deck();
		tester.addCard("question", "answer");
		Card testCard = tester.getCard(0);
		assertTrue((testCard.getQuestion()).equals("question"));
		assertTrue((testCard.getAnswer()).equals("answer"));
	}

	@Test
	public void testAddResult() {
		Deck tester = new Deck();
		tester.addCard("a", "b");
		tester.addCard("c", "d");
		tester.addCard("e", "f");
		tester.addCard("g", "h");
		tester.addResult(1);
		tester.addResult(2);
		ArrayList<Score> scores = tester.getResults();
		assertEquals("There are two results", 2, scores.size());
		Score testScore = scores.get(0);
		assertTrue(0.25 == testScore.getPercentage());
		testScore = scores.get(1);
		assertTrue(0.5 == testScore.getPercentage());
	}

	@Test
	public void testGetResults() {
		Deck tester = new Deck();
		tester.addCard("a", "b");
		tester.addCard("c", "d");
		tester.addCard("e", "f");
		tester.addCard("g", "h");
		tester.addResult(1);
		tester.addResult(2);
		ArrayList<Score> scores = tester.getResults();
		assertEquals("There are two results", 2, scores.size());
		Score testScore = scores.get(0);
		assertTrue(0.25 == testScore.getPercentage());
		testScore = scores.get(1);
		assertTrue(0.5 == testScore.getPercentage());
	}

}
