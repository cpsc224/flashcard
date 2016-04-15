import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void testCard() {
		Card c = new Card();
		assertTrue(c.getAnswer().equals(""));
		assertTrue(c.getQuestion().equals(""));
		//assertTrue(c.getScoreObject().equals(Score s);
	}

	@Test
	public void testCardStringString() {
		Card c = new Card("question", "answer");
		assertTrue(c.getQuestion().equals("question"));
		assertTrue(c.getAnswer().equals("answer"));
		
	}

	@Test
	public void testGetAnswer() {
		Card c = new Card("question", "answer");
		assertTrue(c.getAnswer().equals("answer"));
	}

	@Test
	public void testGetQuestion() {
		Card c = new Card("question", "answer");
		assertTrue(c.getQuestion().equals("question"));
	}

	@Test
	public void testSetQuestion() {
		Card c = new Card();
		assertTrue(c.getQuestion().equals(""));
		c.setQuestion("question");
		assertTrue(c.getQuestion().equals("question"));
	}

	@Test
	public void testSetAnswer() {
		Card c = new Card();
		assertTrue(c.getAnswer().equals(""));
		c.setAnswer("answer");
		assertTrue(c.getAnswer().equals("answer"));
	}

	@Test
	public void testGetScoreObject() {
		Card c = new Card();
		c.getScoreObject().addCorrectAttempt();
		assertTrue(c.getScoreObject().getPercentage() == 1.0);
		//assertTrue
		
	}

}
