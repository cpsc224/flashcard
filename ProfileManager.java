import java.io.Serializable;
import java.util.ArrayList; 

/**  
 * Holds and manages an array of users 
 * @author Katie Phillips (kphillips2) 
 * @date 4/7/16 
 * @class CPSC 224 - Section 1 
 * @assignment Group Project 
 */ 
public class ProfileManager implements Serializable { 
	private ArrayList<User> users; 

	public ProfileManager() { 
		users = new ArrayList<>(); 
	} 

	/** 
	 *Retrieves a user from the list 
	 *@pre There must be a user in the list with the given username 
	 *@param username is the username of the user to be retrieved 
	 *@return Returns the User that has the given username 
	 */ 
	public User getUser(String username) { 
		User user = new User(""); 
		for(int i = 0; i < users.size(); i++) { 
			User currUser = users.get(i); 

			if(username.equals(currUser.getUsername())) { 
				user = currUser; 
				break; 
			} 
		} 

		return user; 
	} 

	/** 
	 *Adds a user to the list 
	 *@post The user has been added to the list 
	 *@param username is the username of the new user to be added 
	 */ 
	public void addUser(User user) { 
		users.add(user); 
	} 

	/** 
	 *Removes a user from the list 
	 *@pre There must be a user in the list that has the given username 
	 *@post The user has been removed from the list 
	 *@param username is the username of the user to be removed 
	 */ 
	public void removeUser(String username) { 
		for(int i = 0; i < users.size(); i++) { 
			User currUser = users.get(i); 
			if(username.equals(currUser.getUsername())) { 
				users.remove(i); 
				break; 
			} 
		} 
	} 

	/** 
	 *Checks whether or not a username is already taken by another user 
	 *@param username is the username to be checked for 
	 *@return Returns true if there is a user in the list with the given username, false otherwise 
	 */ 
	public boolean isUsernameTaken(String username) { 
		for(int i = 0; i < users.size(); i++) { 
			User currUser = users.get(i); 
			if(username.equals(currUser.getUsername())) return true; 
		} 

		return false; 
	} 


}
