package AccountManager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class NewUserSceneManager {
	private Stage primaryStage;
	private Scene sceneNewUser;
	private Label lblNewUser;
	private Label lblNoticeNewUser;
	private TextField tfFirstName;
	private TextField tfLastName;
	private TextField tfGPA;
	private TextField tfUserName;
	private PasswordField pfPassword;
	private ComboBox<String> cbGender;
	private Button btCreate;
	private Button btCancel;
	private HBox hbox;
	private GridPane gridPane;
	
	
	public NewUserSceneManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
		createScene();
	}
	
	private void createScene() {
		lblNewUser = new Label("Create Account");
		lblNewUser.setTextFill(Color.WHITESMOKE);
		lblNewUser.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		lblNewUser.setPadding(new Insets(15, 0, 15, 0));
		
		tfFirstName = new TextField();
		tfFirstName.setPromptText("First Name");
		
		tfLastName = new TextField();
		tfLastName.setPromptText("Last Name");
		
		cbGender = new ComboBox<String>();
		cbGender.getItems().addAll("Male", "Female");
		cbGender.setPromptText("Gender");
		
		tfGPA = new TextField();
		tfGPA.setPromptText("GPA");
		
		tfUserName = new TextField();
		tfUserName.setPromptText("Username");
		
		pfPassword = new PasswordField();
		pfPassword.setPromptText("Password");
		
		lblNoticeNewUser = new Label();
		lblNoticeNewUser.setTextFill(Color.WHITE);
		lblNoticeNewUser.setAlignment(Pos.CENTER);
		
		btCreate = new Button("Create");
		
		btCancel = new Button("Cancel");
		
		hbox = new HBox(btCreate, btCancel);
		hbox.setAlignment(Pos.CENTER);
		
		gridPane = new GridPane();
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
		
		sceneNewUser = new Scene(gridPane, 300, 300, Color.BLACK);
	}
	
	public String[] getTextFieldData() {
		String[] textData = new String[6];
		textData[0] = tfFirstName.getText();
		textData[1] = tfLastName.getText();
		textData[2] = cbGender.getValue();
		textData[3] = tfGPA.getText();
		textData[4] = tfUserName.getText();
		textData[5] = pfPassword.getText();
		
		return textData;
	}
	
	public void setCreateButtonAction(EventHandler<ActionEvent> handler) {
		btCreate.setOnAction(handler);
	}
	
	public void setCancelButtonAction(EventHandler<ActionEvent> handler) {
		btCancel.setOnAction(handler);
	}
	
	public void resetTextFields() {
		tfFirstName.setText(null);
		tfLastName.setText(null);
		cbGender.setValue(null);
		tfUserName.setText(null);
		pfPassword.setText(null);
		tfGPA.setText(null);
	}
	
	public void setNotice(String msg) {
		lblNoticeNewUser.setText(msg);
	}
	
	public Scene getScene() {
		return sceneNewUser;
	}
	
	public void makeActive() {
		resetTextFields();
		primaryStage.setScene(sceneNewUser);
		primaryStage.sizeToScene();
		sceneNewUser.getRoot().requestFocus();
	}
}
