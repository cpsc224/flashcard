import static org.junit.Assert.*;

import org.junit.Test;

public class ProfileManagerTest {

	@Test
	public void testProfileManager() {
		ProfileManager tester = new ProfileManager();
		assertEquals("New manager has 0 users", 0, tester.getNumberOfUsers());
	}

	@Test
	public void testGetUserString() {
		ProfileManager tester = new ProfileManager();
		User testUser = new User("This user");
		User testUser2 = new User("A");
		Deck testDeck = new Deck();
		testUser2.addDeck(testDeck);
		tester.addUser(testUser);
		tester.addUser(testUser2);
		User aUser = tester.getUser("A");
		assertEquals("If correct user, user has 1 deck", 1, aUser.getNumberOfDecks());
	}

	@Test
	public void testAddUser() {
		ProfileManager tester = new ProfileManager();
		User testUser = new User("This user");
		tester.addUser(testUser);
		assertEquals("Manager has 1 users", 1, tester.getNumberOfUsers());
	}

	@Test
	public void testRemoveUser() {
		ProfileManager tester = new ProfileManager();
		User testUser1 = new User("user1");
		User testUser2 = new User("user2");
		User testUser3 = new User("user3");
		
		testUser2.addDeck(new Deck());
		testUser3.addDeck(new Deck());
		testUser3.addDeck(new Deck());
		
		tester.addUser(testUser1);
		tester.addUser(testUser2);
		tester.addUser(testUser3);
		tester.removeUser("user1");
		assertEquals("Manager has 2 users", 2, tester.getNumberOfUsers());
		
		User aUser1 = tester.getUser("user2");
		User aUser2 = tester.getUser("user3");
		assertEquals("First user has 1 deck", 1, aUser1.getNumberOfDecks());
		assertEquals("Second user has 2 decks", 2, aUser2.getNumberOfDecks());
		
		tester.removeUser("user3");
		assertEquals("Manager has 1 user", 1, tester.getNumberOfUsers());
		aUser1 = tester.getUser("user2");
		assertEquals("First user has 1 deck", 1, aUser1.getNumberOfDecks());
	}

	@Test
	public void testIsUsernameTaken() {
		ProfileManager tester = new ProfileManager();
		tester.addUser(new User("this user"));
		assertTrue(tester.isUsernameTaken("this user"));
		assertFalse(tester.isUsernameTaken("not this user"));
	}

	@Test
	public void testGetNumberOfUsers() {
		ProfileManager tester = new ProfileManager();
		User testUser1 = new User("user1");
		User testUser2 = new User("user2");
		
		assertEquals("Manager has 0 users", 0, tester.getNumberOfUsers());
		tester.addUser(testUser1);
		assertEquals("Manager has 1 user", 1, tester.getNumberOfUsers());
		tester.addUser(testUser2);
		assertEquals("Manager has 2 users", 2, tester.getNumberOfUsers());
	}
	
	@Test
	public void testGetUserInt(){
		ProfileManager tester = new ProfileManager();
		User testUser = new User("This user");
		User testUser2 = new User("A");
		Deck testDeck = new Deck();
		testUser2.addDeck(testDeck);
		tester.addUser(testUser);
		tester.addUser(testUser2);
		User aUser = tester.getUser(1);
		assertEquals("If correct user, user has 1 deck", 1, aUser.getNumberOfDecks());
		aUser = tester.getUser(0);
		assertEquals("If correct user, user has 0 decks", 0, aUser.getNumberOfDecks());
	}
}
