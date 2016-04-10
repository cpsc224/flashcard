import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		ProfileManager p = new ProfileManager();
		/**
		User alex = new User("Alex");
		p.addUser(alex);
		Deck d = new Deck("deck1", "spanish");
		alex.addDeck(d);
		d.addCard("Question 1", "answer1");
		d.addCard("question2", "answer2");
		System.out.println(p.getUser("Alex").getUsername());
		System.out.println(alex.getDeck("deck1").getName());
		*/
		FileReadWrite filereadwrite = new FileReadWrite();
		//filereadwrite.saveFile("test1", p);
		p = filereadwrite.readFile("test1");
		System.out.println(p.getUser("Alex").getUsername());
		User user = p.getUser("Alex");
		System.out.println(user.getDeck("deck1").getName());

		
	}
}
