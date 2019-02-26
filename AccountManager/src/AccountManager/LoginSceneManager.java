package AccountManager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class LoginSceneManager {
	private Stage primaryStage;
	private Scene sceneLogin;
	private Label lblLogin;
	private Label lblNoticeLogin;
	private TextField tfUserName;
	private PasswordField pfPassword;
	private Button btLogin;
	private Button btNewUser;
	private HBox hbox;
	private GridPane gridPane;
	private VBox vbox;
	
	public LoginSceneManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
		createScene();
	}
	
	private void createScene() {
		lblLogin = new Label("Login");
		lblLogin.setTextFill(Color.WHITESMOKE);
		lblLogin.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		lblLogin.setPadding(new Insets(15,0,15,0));
		
		lblNoticeLogin = new Label();
		lblNoticeLogin.setAlignment(Pos.CENTER);
		lblNoticeLogin.setTextFill(Color.WHITE);
		
		tfUserName = new TextField();
		tfUserName.setPromptText("Username");
		
		pfPassword = new PasswordField();
		pfPassword.setPromptText("Password");
		
		btLogin = new Button("Login");
		
		btNewUser = new Button("New User");
		
		hbox = new HBox(btLogin, btNewUser);
		hbox.setAlignment(Pos.CENTER);
		
		gridPane = new GridPane();
		gridPane.add(lblLogin, 0, 0, 1, 1);
		GridPane.setHalignment(lblLogin, HPos.CENTER);
		gridPane.add(tfUserName, 0, 1, 1, 1);
		gridPane.add(pfPassword,  0,  2, 1, 1);
		gridPane.add(hbox, 0, 3, 1, 1);
		gridPane.setAlignment(Pos.CENTER);
		
		vbox = new VBox(gridPane, lblNoticeLogin);
		vbox.setBackground(new Background(new BackgroundFill(Color.NAVY, null, null)));
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(15);
		sceneLogin = new Scene(vbox, 300, 300);
	}
	
	public void setLoginButtonAction(EventHandler<ActionEvent> handler) {
		btLogin.setOnAction(handler);
	}
	
	public void setNewUserButtonAction(EventHandler<ActionEvent> handler) {
		btNewUser.setOnAction(handler);
	}
	
	public String[] getUserNameAndPassword() {
		String[] textValues = new String[2];
		textValues[0] = tfUserName.getText();
		textValues[1] = pfPassword.getText();
		
		return textValues;
	}
	
	public void resetTextFields() {
		tfUserName.setText(null);
		pfPassword.setText(null);
	}
	
	public void setNotice(String msg) {
		lblNoticeLogin.setText(msg);
	}
	
	public Scene getScene() {
		return sceneLogin;
	}
	
	public void makeActive() {
		resetTextFields();
		primaryStage.setScene(sceneLogin);
		primaryStage.sizeToScene();
		sceneLogin.getRoot().requestFocus();
	}
}
