package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Dice;
import model.Player;
import model.Unit;

public class gameScreenController {
	private static ArrayList<GameControlObserver> observers = new ArrayList<>();

	private GameController gc;
	private Player p;

	public static void addObserver(GameControlObserver gameControlObserver) {
		observers.add(gameControlObserver);
	}

	public static void removeObserver(GameControlObserver gameControlObserver) {
		observers.remove(gameControlObserver);
	}
	
    @FXML
    private Button diceBtn;

    @FXML
    private Label playerLabel;

    @FXML
    private Label diceResult;

    @FXML
    private GridPane scoreGrid;
    
    @FXML
    void diceBtnClick(ActionEvent event) throws IOException {

    	Dice dice = new Dice(1);
    	int result = dice.diceroll();
    	diceResult.setText("User rolled a " + result);

    	for(GameControlObserver gameControlObserver : observers) {
    		gameControlObserver.onDiceRolled(p, result, gc);
		}

    	System.out.println(p.getName() + " "  +p.getMoney() + "--------------here");
    	for(Unit u : p.getAssetList("property")) {
    		System.out.println(u.getTile().getTileName());
    	}

    	updateScreen();
    }
    
    private void updateScreen() {
		// TODO Auto-generated method stub
    	p = gc.nextPlayer();
		playerLabel.setText(p.getName());
		diceResult.setText("");
	}

	public void setGameController(GameController gc) {
    	this.gc = gc;
    	updateScreen();
    }

    interface GameControlObserver {
    	void onDiceRolled(Player player, int result, GameController gameController) throws IOException;
	}
}
