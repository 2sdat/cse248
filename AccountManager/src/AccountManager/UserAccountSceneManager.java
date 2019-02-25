package AccountManager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UserAccountSceneManager {
	private Scene sceneUserAccount;
	private Button btLogOut;
	private EventHandler<ActionEvent> handlerLogOut;
	
	public void createScene(UserAccount user) {
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
		
		btLogOut = new Button("Log Out");
		btLogOut.setOnAction(handlerLogOut);
		
		VBox vbox = new VBox(lblUserName, gridPane, btLogOut);
		vbox.setSpacing(5);
		vbox.setBackground(new Background(new BackgroundFill(Color.NAVY, null, null)));
		vbox.setAlignment(Pos.CENTER);
		
		sceneUserAccount =  new Scene(vbox, 300, 300, Color.BLACK);
	}
	
	public Scene getScene() {
		return sceneUserAccount;
	}
	
	public void setLogoutButtonAction(EventHandler<ActionEvent> handler) {
		handlerLogOut = handler;
	}
	
	public void destroyScene() {
		sceneUserAccount = null;
	}
}
