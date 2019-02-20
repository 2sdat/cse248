package AccountManager;

import java.util.Hashtable;

public class UserBag {
	private Hashtable<String,UserAccount> userBag;
	private Hashtable<String, String> idBag;
	
	public UserBag(int size) {
		userBag = new Hashtable<String, UserAccount>(size);
		idBag = new Hashtable<String, String>(size);
	}

	public void addUser(UserAccount user) {
		String userName = user.getUserName();
		String userID = user.getUserID();
		
		if(!checkUserNameExists(userName)) {
			if(!checkIDExists(userID)) {
				idBag.put(userName, userID);
				userBag.put(userID, user);
				return;
			}
			
			throw new IllegalArgumentException("Account with ID '" + user.getUserID() + "' already exists");
		}
			
		throw new IllegalArgumentException("Account for user '" + user.getUserName() + "' already exists");
	}

	public boolean checkUserNameExists(String userName) {
		return idBag.containsKey(userName);
	}
	
	public boolean checkIDExists(String userID) {
		return userBag.containsKey(userID);
	}

	public boolean loginUser(String userName, String password) {
		if(checkUserNameExists(userName))
			return userBag.get(idBag.get(userName)).checkPassword(password);
		return false;
	}
	
}
