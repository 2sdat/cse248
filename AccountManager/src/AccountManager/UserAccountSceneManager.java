package AccountManager;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;

public class UserAccountSceneManager {
	private Stage primaryStage;
	private Scene sceneUserAccount;
	private Button btLogOut;
	private EventHandler<ActionEvent> handlerLogOut;
	private TableView<UserAccount> tableUsers;
	
	public UserAccountSceneManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
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
		
		if(tableUsers != null) {
			Label lblDirectory = new Label("Directory");
			lblDirectory.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
			VBox vboxDirectory = new VBox(lblDirectory, tableUsers);
			
			HBox hbox = new HBox(vbox, vboxDirectory);
			hbox.setSpacing(10);
			hbox.setBackground(new Background(new BackgroundFill(Color.NAVY, null, null)));
			hbox.setAlignment(Pos.CENTER);
		
			sceneUserAccount =  new Scene(hbox, 300, 300, Color.BLACK);
		} else {
			sceneUserAccount =  new Scene(vbox, 300, 300, Color.BLACK);
		}
	}
	
	public Scene getScene() {
		return sceneUserAccount;
	}
	
	public void setLogoutButtonAction(EventHandler<ActionEvent> handler) {
		handlerLogOut = handler;
	}
	
	public void makeActive() {
		primaryStage.setScene(sceneUserAccount);
		primaryStage.sizeToScene();
		sceneUserAccount.getRoot().requestFocus();
	}
	
	public void destroyScene() {
		sceneUserAccount = null;
	}
	
	public void addUserDirectory(UserBag userBag) {
		tableUsers = new TableView<UserAccount>();
		TableColumn<UserAccount, String> nameCol = new TableColumn<UserAccount, String>("Name");
		TableColumn<UserAccount, String> firstNameCol = new TableColumn<UserAccount, String>("First");
		firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<UserAccount, String>, ObservableValue<String>>(){
			public ObservableValue<String> call(CellDataFeatures<UserAccount, String> p) {
				return new SimpleStringProperty(p.getValue().getFirstName());
			}
		});
		TableColumn<UserAccount, String> lastNameCol = new TableColumn<UserAccount, String>("Last");
		lastNameCol.setCellValueFactory(new Callback<CellDataFeatures<UserAccount, String>, ObservableValue<String>>(){
			public ObservableValue<String> call(CellDataFeatures<UserAccount, String> p) {
				return new SimpleStringProperty(p.getValue().getLastName());
			}
		});
		nameCol.getColumns().addAll(firstNameCol, lastNameCol);
		
		TableColumn<UserAccount, String> userNameCol = new TableColumn<UserAccount, String>("Username");
		userNameCol.setCellValueFactory(new Callback<CellDataFeatures<UserAccount, String>, ObservableValue<String>>(){
			public ObservableValue<String> call(CellDataFeatures<UserAccount, String> p) {
				return new SimpleStringProperty(p.getValue().getUserName());
			}
		});
		
		TableColumn<UserAccount, String> genderCol = new TableColumn<UserAccount, String>("Gender");
		genderCol.setCellValueFactory(new Callback<CellDataFeatures<UserAccount, String>, ObservableValue<String>>(){
			public ObservableValue<String> call(CellDataFeatures<UserAccount, String> p) {
				if(p.getValue().isMale())
					return new SimpleStringProperty("Male");
				else
					return new SimpleStringProperty("Female");
			}
		});
		
		TableColumn<UserAccount, String> gpaCol = new TableColumn<UserAccount, String>("GPA");
		gpaCol.setCellValueFactory(new Callback<CellDataFeatures<UserAccount, String>, ObservableValue<String>>(){
			public ObservableValue<String> call(CellDataFeatures<UserAccount, String> p) {
				return new SimpleStringProperty(Double.toString(p.getValue().getGPA()));
			}
		});
		
		tableUsers.setItems(FXCollections.observableArrayList(userBag.getUsers().values()));
		tableUsers.getColumns().addAll(nameCol, userNameCol, genderCol, gpaCol);
	}
}
