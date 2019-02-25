package AccountManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;

public class UserBag {
	private Hashtable<String, UserAccount> userBag;
	private HashSet<String> idBag;
	
	public UserBag(int size) {
		userBag = new Hashtable<String, UserAccount>(size);
		idBag = new HashSet<String>(size);
	}
	
	public UserBag() {
		this(5000);
	}
	
	public ArrayList<String> getUserList(){
		return new ArrayList<String>(userBag.keySet());
	}
	
	public Hashtable<String, UserAccount> getUsers(){
		return userBag;
	}

	public void addUser(UserAccount user) {
		String userName = user.getUserName();
		String userID = user.getUserID();
		
		if(!checkUserNameExists(userName)) {
			if(!checkIDExists(userID)) {
				idBag.add(userID);
				userBag.put(userName, user);
				return;
			}
			
			throw new IllegalArgumentException("Account with ID '" + user.getUserID() + "' already exists");
		}
			
		throw new IllegalArgumentException("Account for user '" + user.getUserName() + "' already exists");
	}
	
	public void addNewUser(String firstName, String lastName, boolean isMale, String password, double GPA) {
		String userName = lastName.substring(0, Math.min(lastName.length(), 4)) + firstName.charAt(0);
		String id;
		while(checkIDExists(id = genID()) || checkUserNameExists(userName += id.charAt(7)));
		addUser(new UserAccount(firstName, lastName, id, isMale, userName, password, GPA));
	}
	
	public void addNewUser(String firstName, String lastName, boolean isMale, String userName, String password, double GPA) {
		if(checkUserNameExists(userName))
			throw new IllegalArgumentException("An account with the username '" + userName + "' already exists.");
		addUser(new UserAccount(firstName, lastName, genID(), isMale, userName, password, GPA));
	}
	
	private String genID() {
		String id;
		Random rand = new Random();
		while(checkIDExists(id = String.format("%08d",rand.nextInt(100000000))));
		return id;
	}

	private boolean checkUserNameExists(String userName) {
		return userBag.containsKey(userName);
	}
	
	private boolean checkIDExists(String userID) {
		return idBag.contains(userID);
	}

	public boolean loginUser(String userName, String password) {
		if(checkUserNameExists(userName))
			return userBag.get(userName).checkPassword(password);
		return false;
	}
}
