import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void testScore() {
		Score tester = new Score();
		tester.addCorrectAttempt();
		assertTrue(tester.getPercentage() == 1.0);
	}

	@Test
	public void testScoreIntInt() {
		Score tester = new Score(4, 1);
		assertTrue(tester.getPercentage() == .25);
	}

	@Test
	public void testAddCorrectAttempt() {
		Score tester = new Score(3, 1);
		tester.addCorrectAttempt();
		assertTrue(tester.getPercentage() == .5);
	}

	@Test
	public void testAddWrongAttempt() {
		Score tester = new Score(3, 1);
		tester.addWrongAttempt();
		assertTrue(tester.getPercentage() == .25);
	}

	@Test
	public void testGetPercentage() {
		Score tester = new Score(5, 4);
		assertTrue(tester.getPercentage() == .8);
		tester = new Score(6, 3);
		assertTrue(tester.getPercentage() == .5);
		tester = new Score(8, 0);
		assertTrue(tester.getPercentage() == 0);
		tester = new Score(11, 11);
		assertTrue(tester.getPercentage() == 1);
	}

}
