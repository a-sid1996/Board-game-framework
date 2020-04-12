package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.BoardModel;
import model.Card;
import model.Player;
import model.PlayerTurnModule;
import model.Score;
import model.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class newGameController {

	ObservableList<String> number = FXCollections.observableArrayList("1","2","3","4","5");
	
	@FXML
	private TextField mapLocation;

	@FXML
	void findFileClick(ActionEvent event) throws NumberFormatException, IOException {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON file", "*.json"));
		File file = fc.showOpenDialog(null);
		
		if(file != null) {
			mapLocation.setText(file.getAbsolutePath());
		}
		
	}
	
	@FXML
	private ComboBox<String> playerNumber;

	@FXML
	void initialize() {
		playerNumber.setItems(number);
	}
	
	@FXML
	void startGameClick(ActionEvent event) throws JSONException, IOException {

		if(playerNumber.getValue() == null) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Input not valid");
			errorAlert.setContentText("Please select number of players.");
			errorAlert.showAndWait();
			return;
		} else if(mapLocation.getText().isBlank()) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Input not valid");
			errorAlert.setContentText("Please select correct map file.");
			errorAlert.showAndWait();
			return;
		}
		
		int numPLayers = Integer.valueOf(playerNumber.getValue());
		BoardModel bc = new BoardModel();
		MapJsonParser m = new MapJsonParser();
		bc.setBoard(m.MapJsonParser1(mapLocation.getText()));
		
		Score score = new Score();
		Unit[] units = new Unit[2];
		units[0].setUnitType("money");
		units[0].setAmount(10000000);
		units[1].setUnitType("hotel");
		units[1].setAmount(1000);

		Player bank = new Player("bank", units, score);
		
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(bank);

		for (int i=0; i<numPLayers; i++) {
			Unit[] unitPlayer = new Unit[2];
			units[0].setUnitType("money");
			units[0].setAmount(5000);
			units[1].setUnitType("hotel");
			units[1].setAmount(0);
			
			Player p = new Player("player"+i, unitPlayer, score);
			players.add(p);
		}
		
		Card cards = new Card(10);
		PlayerTurnModule<Player> ptm = new PlayerTurnModule<Player>(players);
		GameController gc = new GameController(bc, cards, players, score, ptm);
		
		
		
	}

}
