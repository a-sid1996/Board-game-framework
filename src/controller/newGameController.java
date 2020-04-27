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


	/**
	 * This method gets executed when back button is pressed
	 */
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

	/**
	 *This method starts actual game play and implements game playing rules 
	 *@param event of start game
	 */
	@FXML
	void startGameClick(ActionEvent event) throws JSONException, IOException, InvalidMapException {

		if(playerNumber.getValue() == null) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Input not valid");
			errorAlert.setContentText("Please select number of players.");
			errorAlert.showAndWait();
			return;
		} else if(mapLocation.getText().isEmpty()) {
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

		Card card = new Card(12);

		card.setDesc(1, "Move To Go");
		card.setDesc(2, "Bank error in your favor. Collect $125");
		card.setDesc(3, "You have won a CrossWord Competition. Collect $100");
		card.setDesc(4, "You have been elected as the Chairman of the Board. Pay each player $50");
		card.setDesc(5, "Building loan matures. Collect $150 from Bank");
		card.setDesc(6, "Go To Jail. Do not pass Go. Do not collect $100");
		card.setDesc(7, "You inherit $100");
		card.setDesc(8, "Hospital fees. Pay $50");
		card.setDesc(9, "Grand Opera Night. Collect $50 from every player for opening night seats");
		card.setDesc(10, "You are assessed for street repairs. Pay $40 per plot");
		card.setDesc(11, "Go to Jail. Pay $50 to the bank");
		card.setDesc(12, "Advance to go. Collect 200$ from bank");


		PlayerTurnModule<Player> ptm = new PlayerTurnModule<Player>(new ArrayList<>(players.subList(1, players.size())));
		GameController gc = new GameController(bc, card, players, score, ptm, false);

		startGame(gc, event);
	}

	public static void startGame(GameController gc, ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(newGameController.class.getResource("/view/GameScreen.fxml"));
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