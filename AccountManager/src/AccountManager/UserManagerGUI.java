package AccountManager;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserManagerGUI extends Application{
	private final String BOYSNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/boys_names.txt";
	private final String GIRLSNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/girls_names.txt";
	private final String LASTNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/last_names.txt";
	private Stage primaryStage;
	private LoginSceneManager loginSceneManager;
	private NewUserSceneManager newUserSceneManager;
	private UserAccountSceneManager userAccountSceneManager;
	private UserBag userBag;
	
	@Override
	public void start(Stage stage){
		this.primaryStage = stage;
		primaryStage.setTitle("User Account Manager");
		
		loginSceneManager = new LoginSceneManager(primaryStage);
		loginSceneManager.setLoginButtonAction(action -> {requestLogin(loginSceneManager.getUserNameAndPassword());});
		loginSceneManager.setNewUserButtonAction(action -> {requestNewUser();});
		
		newUserSceneManager = new NewUserSceneManager(primaryStage);
		newUserSceneManager.setCreateButtonAction(action -> {requestCreateUser(newUserSceneManager.getTextFieldData());});
		newUserSceneManager.setCancelButtonAction(action -> {requestCancel();});
		
		userAccountSceneManager = new UserAccountSceneManager(primaryStage);
		userAccountSceneManager.setLogoutButtonAction(action -> {requestLogOut();});
		
		
		UserAccountFactory userFactory;
		try {
			userFactory = new UserAccountFactory(BOYSNAMESFILE, GIRLSNAMESFILE, LASTNAMESFILE);
			userBag = userFactory.populateUserBag();
		} catch (Exception e) {
			loginSceneManager.setNotice("Could not find name files.");
			userBag = new UserBag();
		}
		
		loginSceneManager.makeActive();
		primaryStage.show();
	}
	
	private void requestLogin(String[] userData) {
		boolean loginSuccessful = userBag.loginUser(userData[0], userData[1]);
		if(loginSuccessful) {
			loginSceneManager.setNotice("Login Successful!");
			userAccountSceneManager.addUserDirectory(userBag);
			userAccountSceneManager.createScene(userBag.getUser(userData[0], userData[1]));
			userAccountSceneManager.makeActive();
		} else {
			loginSceneManager.setNotice("The username and/or password\n you entered was incorrect.");
		}
	}
	
	private void requestNewUser() {
		newUserSceneManager.makeActive();
	}
		
	private void requestCreateUser(String[] userData) {
		ArrayList<String> incFields = new ArrayList<String>();
		
		int firstNameIndex = 0;
		int lastNameIndex = 1;
		int genderIndex = 2;
		int gpaIndex = 3;
		int userNameIndex = 4;
		int passwordIndex = 5;
		
		if(userBag.checkUserNameExists(userData[userNameIndex]) || userData[userNameIndex].contentEquals("")) {
			incFields.add("Username");
		}
		
		if(!UserAccount.validatePassword(userData[passwordIndex])) {
			incFields.add("Password");
		}
		
		double gpa = 0.0;
		try {
			gpa = Double.parseDouble(userData[gpaIndex]);
		} catch(Exception e) {
			incFields.add("GPA");
		}
		
		if(incFields.size() > 0) {
			newUserSceneManager.setNotice("Incorrect values in fields:\n" + String.join(", ", incFields));
			return;
		}
		
		boolean isMale = userData[genderIndex].equals("Male");
		
		userBag.addNewUser(userData[firstNameIndex], userData[lastNameIndex], isMale, userData[userNameIndex], userData[passwordIndex], gpa);
		loginSceneManager.setNotice("Account successfully created!\nYou may now login.");

		loginSceneManager.makeActive();
	}
	
	private void requestCancel() {
		loginSceneManager.setNotice("");
		loginSceneManager.makeActive();
	}
	
	
	private void requestLogOut() {
		loginSceneManager.setNotice("Successfully logged out.");
		loginSceneManager.makeActive();
		userAccountSceneManager.destroyScene();
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
