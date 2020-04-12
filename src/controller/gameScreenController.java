package controller;

import javafx.beans.InvalidationListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Dice;
import model.Player;

public class gameScreenController {

	private GameController gc;
	
    @FXML
    private Button diceBtn;

    @FXML
    private Label playerLabel;

    @FXML
    private Label diceResult;

    @FXML
    private GridPane scoreGrid;
    
    @FXML
    void diceBtnClick(ActionEvent event) {
    	Dice dice = new Dice(1);
    	int result = dice.diceroll();
    	diceResult.setText("User rolled a " + result);
    	Player p = gc.nextPlayer();
    	gc.movePlayer(p, result);
    	
    }
    
    public void setGameController(GameController gc) {
    	this.gc = gc;
    }
    

}
