package AccountManager;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UserManagerGUI extends Application{
	private final String BOYSNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/boys_names.txt";
	private final String GIRLSNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/girls_names.txt";
	private final String LASTNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/last_names.txt";
	private Stage primaryStage;
	private Label lblNoticeLogin;
	private Label lblNoticeNewUser;
	private UserBag userBag;
	
	@Override
	public void start(Stage stage){
		this.primaryStage = stage;
		primaryStage.setTitle("User Account Manager");
		
		lblNoticeLogin = new Label();
		
		UserAccountFactory userFactory;
		try {
			userFactory = new UserAccountFactory(BOYSNAMESFILE, GIRLSNAMESFILE, LASTNAMESFILE);
			userBag = userFactory.populateUserBag();
		} catch (Exception e) {
			lblNoticeLogin.setText("Could not find name files.");
			userBag = new UserBag();
		}
		
		lblNoticeLogin.setTextFill(Color.WHITE);
		lblNoticeLogin.setAlignment(Pos.CENTER);
		
		Scene sceneLogin = createMainScene();
		primaryStage.setScene(createMainScene());
		sceneLogin.getRoot().requestFocus();
		primaryStage.show();
	}
	
	private Scene createMainScene() {
		Label lblLogin = new Label("Login");
		lblLogin.setTextFill(Color.WHITESMOKE);
		lblLogin.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		lblLogin.setPadding(new Insets(15,0,15,0));
		TextField tfUserName = new TextField();
		tfUserName.setPromptText("Username");
		PasswordField pfPassword = new PasswordField();
		pfPassword.setPromptText("Password");
		Button btLogin = new Button("Login");
		btLogin.setOnAction(action -> { requestLogin(tfUserName.getText(), pfPassword.getText()); });
		Button btNewUser = new Button("New User");
		btNewUser.setOnAction(action -> {requestNewUser();});
		HBox hbox = new HBox(btLogin, btNewUser);
		hbox.setAlignment(Pos.CENTER);
		
		GridPane gridPane = new GridPane();
		gridPane.add(lblLogin, 0, 0, 1, 1);
		GridPane.setHalignment(lblLogin, HPos.CENTER);
		gridPane.add(tfUserName, 0, 1, 1, 1);
		gridPane.add(pfPassword,  0,  2, 1, 1);
		gridPane.add(hbox, 0, 3, 1, 1);
		gridPane.setAlignment(Pos.CENTER);
		VBox vbox = new VBox(gridPane, lblNoticeLogin);
		vbox.setBackground(new Background(new BackgroundFill(Color.NAVY, null, null)));
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(15);
		return new Scene(vbox, 300, 300);
	}
	
	private void requestLogin(String userName, String password) {
		boolean loginSuccessful = userBag.loginUser(userName, password);
		if(loginSuccessful) {
			lblNoticeLogin.setText("Login Successful!");
			primaryStage.setScene(createAccountScene(userBag.getUser(userName, password)));
		} else {
			lblNoticeLogin.setText("The username and/or password\n you entered was incorrect.");
		}
	}
	
	private void requestNewUser() {
		Scene sceneNewUser = createNewUserScene();
		lblNoticeNewUser.setText("");
		primaryStage.setScene(sceneNewUser);
		sceneNewUser.getRoot().requestFocus();
	}
	
	private Scene createNewUserScene() {
		Label lblNewUser = new Label("Create Account");
		lblNewUser.setTextFill(Color.WHITESMOKE);
		lblNewUser.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		lblNewUser.setPadding(new Insets(15, 0, 15, 0));
		
		TextField tfFirstName = new TextField();
		tfFirstName.setPromptText("First Name");
		TextField tfLastName = new TextField();
		tfLastName.setPromptText("Last Name");
		ComboBox<String> cbGender = new ComboBox<String>();
		cbGender.getItems().addAll("Male", "Female");
		cbGender.setPromptText("Gender");
		TextField tfGPA = new TextField();
		tfGPA.setPromptText("GPA");
		TextField tfUserName = new TextField();
		tfUserName.setPromptText("Username");
		PasswordField pfPassword = new PasswordField();
		pfPassword.setPromptText("Password");
		
		lblNoticeNewUser = new Label();
		lblNoticeNewUser.setTextFill(Color.WHITE);
		lblNoticeNewUser.setAlignment(Pos.CENTER);
		
		Button btCreate = new Button("Create");
		btCreate.setOnAction(action -> {
			String firstName = tfFirstName.getText();
			String lastName = tfLastName.getText();
			String isMale = cbGender.getValue();
			String GPA = tfGPA.getText();
			String userName = tfUserName.getText();
			String password = pfPassword.getText();
			
			requestCreateUser(firstName, lastName, isMale, GPA, userName, password);
		});
		
		Button btCancel = new Button("Cancel");
		btCancel.setOnAction(action -> {requestCancel();});
		
		HBox hbox = new HBox(btCreate, btCancel);
		hbox.setAlignment(Pos.CENTER);
		
		GridPane gridPane = new GridPane();
		gridPane.add(lblNewUser, 0, 0, 1, 1);
		GridPane.setHalignment(lblNewUser, HPos.CENTER);
		gridPane.add(tfFirstName, 0, 1, 1, 1);
		gridPane.add(tfLastName, 0, 2, 1, 1);
		gridPane.add(cbGender, 0, 3, 1, 1);
		GridPane.setHalignment(cbGender, HPos.CENTER);
		gridPane.add(tfGPA, 0, 4, 1, 1);
		gridPane.add(tfUserName, 0, 5, 1, 1);
		gridPane.add(pfPassword, 0, 6, 1, 1);
		gridPane.add(hbox, 0, 7, 1, 1);
		gridPane.add(lblNoticeNewUser, 0, 8, 2, 1);
		gridPane.setVgap(2);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setBackground(new Background(new BackgroundFill(Color.NAVY, null, null)));
		
		return new Scene(gridPane, 300, 300, Color.BLACK);
	}
	
	private void requestCreateUser(String firstName, String lastName, String gender, String GPA, String userName, String password) {
		ArrayList<String> incFields = new ArrayList<String>();
		
		if(userBag.checkUserNameExists(userName) || userName.contentEquals("")) {
			incFields.add("Username");
		}
		
		if(!UserAccount.validatePassword(password)) {
			incFields.add("Password");
		}
		
		double gpa = 0.0;
		try {
			gpa = Double.parseDouble(GPA);
		} catch(Exception e) {
			incFields.add("GPA");
		}
		
		if(incFields.size() > 0) {
			lblNoticeNewUser.setText("Incorrect values in fields:\n" + String.join(", ", incFields));
			return;
		}
		
		boolean isMale = gender.equals("Male");
		
		userBag.addNewUser(firstName, lastName, isMale, userName, password, gpa);
		lblNoticeLogin.setText("Account successfully created!\nYou may now login.");
		
		Scene sceneLogin = createMainScene();
		primaryStage.setScene(sceneLogin);
		sceneLogin.getRoot().requestFocus();
	}
	
	private void requestCancel() {
		lblNoticeLogin.setText("");
		Scene sceneLogin = createMainScene();
		primaryStage.setScene(sceneLogin);
		sceneLogin.getRoot().requestFocus();
	}
	
	private Scene createAccountScene(UserAccount user) {
		Label lblUserName = new Label(user.getUserName());
		lblUserName.setTextFill(Color.WHITE);
		lblUserName.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		lblUserName.setAlignment(Pos.CENTER);
		
		Label lblNameLabel = new Label("Name: ");
		lblNameLabel.setTextFill(Color.WHITE);
		Label lblUserIDLabel = new Label("User ID: ");
		lblUserIDLabel.setTextFill(Color.WHITE);
		Label lblGPALabel = new Label("GPA: ");
		lblGPALabel.setTextFill(Color.WHITE);
		
		Label lblName = new Label(user.getFirstName() + " " + user.getLastName());
		lblName.setTextFill(Color.WHITE);
		Label lblUserID = new Label(user.getUserID());
		lblUserID.setTextFill(Color.WHITE);
		Label lblGPA = new Label(Double.toString(user.getGPA()));
		lblGPA.setTextFill(Color.WHITE);
		
		GridPane gridPane = new GridPane();
		gridPane.add(lblNameLabel, 0, 0);
		GridPane.setHalignment(lblNameLabel, HPos.RIGHT);
		gridPane.add(lblName, 1, 0);
		GridPane.setHalignment(lblName, HPos.CENTER);
		gridPane.add(lblUserIDLabel, 0, 1);
		GridPane.setHalignment(lblUserIDLabel, HPos.RIGHT);
		gridPane.add(lblUserID, 1, 1);
		GridPane.setHalignment(lblUserID, HPos.CENTER);
		gridPane.add(lblGPALabel, 0, 2);
		GridPane.setHalignment(lblGPALabel, HPos.RIGHT);
		gridPane.add(lblGPA, 1, 2);
		GridPane.setHalignment(lblGPA, HPos.CENTER);
		gridPane.setVgap(5);
		gridPane.setHgap(10);
		gridPane.setAlignment(Pos.CENTER);
		
		Button btLogOut = new Button("Log Out");
		
		btLogOut.setOnAction(action -> {requestLogOut();});
		
		VBox vbox = new VBox(lblUserName, gridPane, btLogOut);
		vbox.setSpacing(5);
		vbox.setBackground(new Background(new BackgroundFill(Color.NAVY, null, null)));
		vbox.setAlignment(Pos.CENTER);
		
		return new Scene(vbox, 300, 300, Color.BLACK);
	}
	
	private void requestLogOut() {
		lblNoticeLogin.setText("Successfully logged out.");
		Scene sceneLogin = createMainScene();
		primaryStage.setScene(sceneLogin);
		sceneLogin.getRoot().requestFocus();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
