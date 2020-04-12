package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Dice;

public class gameScreenController {

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
    	diceResult.setText("User rolled a " + dice.diceroll());
    }

}
