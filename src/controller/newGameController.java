package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import model.Tile;
import model.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class newGameController {

	ObservableList<String> number = FXCollections.observableArrayList("2","3","4","5");
	
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
    void backBtnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainScreen.fxml"));
            Parent root = (Parent) loader.load();
            Scene newScene = new Scene(root);
            Stage newStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            newStage.setScene(newScene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }	

	
	@FXML
	private ComboBox<String> playerNumber;

	@FXML
	void initialize() {
		playerNumber.setItems(number);
	}
	
	@FXML
	void startGameClick(ActionEvent event) throws JSONException, IOException, InvalidMapException {

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
		units[0] = new Unit("money", 10000000);
		units[1] = new Unit("hotel", 1000);

		ArrayList<Tile> t = new ArrayList<Tile>();
		t.add(bc.getBoard().get(0));

		Player bank = new Player("bank", units, score, t);

		ArrayList<Player> players = new ArrayList<Player>();
		players.add(bank);

		for (int i=0; i<numPLayers; i++) {
			Unit[] unitP = new Unit[2];
			unitP[0] = new Unit("money", 1500);
			unitP[1] = new Unit("hotel", 0);
			ArrayList<Tile> t1 = new ArrayList<Tile>();
			t1.add(bc.getBoard().get(0));
			Player p = new Player("player"+i, unitP, score, t1);
			players.add(p);
		}

		Card cards = new Card(10);
		PlayerTurnModule<Player> ptm = new PlayerTurnModule<Player>(players.subList(1, players.size()));
		GameController gc = new GameController(bc, cards, players, score, ptm);

	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameScreen.fxml"));
	        Parent root = (Parent) loader.load();
	        Scene newScene = new Scene(root);
	        Stage newStage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        newStage.setScene(newScene);
	        newStage.show();
	        gameScreenController controller = loader.getController();
	        controller.setGameController(gc);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
