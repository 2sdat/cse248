package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;

public class guiController implements Initializable{
	@FXML
	private Button bt;
	
	@FXML
	private MenuItem quit;
	
	@FXML
	private ComboBox<String> comboBox;
	
	private ObservableList<String> list = FXCollections.observableArrayList("This", "is", "my", "list.");
	
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		comboBox.setItems(list);
	}
	
	@FXML
	public void stateSelected(ActionEvent event) {
		System.out.println(comboBox.getValue());
	}
	
	@FXML
	public void onClick() {
		System.out.println("Clicked");
	}
	
	@FXML
	public void quit() {
		//Stage primaryStage = (Stage) bt.getScene().getWindow();
		//primaryStage.close();
		Platform.exit();
	}
}
