package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Dice;
import model.Player;
import model.Tile;
import model.Unit;

import java.util.ArrayList;

public class gameScreenController{
	
 	private static ArrayList<GameControlObserver> observers = new ArrayList<>();
	private GameController gc;
	private Player p;
	private Label label[][] = new Label[9][5];
	
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
    private GridPane posessedProp;
    
    @FXML
    private GridPane scoreGrid;
    
    @FXML
    private GridPane gameBoard;
    
    @FXML
    void diceBtnClick(ActionEvent event) throws IOException {

    	Dice dice = new Dice(1);
    	int result = dice.diceroll();
    	gc.movePlayer(p, result, gc);
    	diceResult.setText("User rolled a " + result);


    	
        for(GameControlObserver gameControlObserver : observers) {
      		gameControlObserver.onDiceRolled(p, result, gc);
  		}
    	
    	updateScreen();
    	updateScoreboard();
    }
    
    private void updateScoreboard() {
		// TODO Auto-generated method stub

    	scoreGrid.getChildren().clear();
    	
    	label[0][0].setText("Player");
    	label[0][1].setText("Position");
    	label[0][2].setText("Money");
		scoreGrid.add(label[0][0], 0, 0);
		scoreGrid.add(label[0][1], 1, 0);
		scoreGrid.add(label[0][2], 2, 0);
    	
    	int i=1;
    	for(Player p : gc.list) {
    		label[i][0].setText(p.getName());
    		label[i][1].setText(p.getCurrentTile().get(0).getTileName());;
    		label[i][2].setText(String.valueOf(p.getMoney()));;
    		scoreGrid.add(label[i][0], 0, i);
    		scoreGrid.add(label[i][1], 1, i);
    		scoreGrid.add(label[i][2], 2, i);
    		
    		i++;
    	}

    	posessedProp.getChildren().clear();
    	
    	for(Player p : gc.list.subList(1, gc.list.size())) {
    		Label l = new Label(p.getName());
    		posessedProp.add(l, gc.list.indexOf(p), 0);
    		for(Unit u : p.getAssetList("property")) {
    			Label k = new Label(u.getTile().getTileName());
    			posessedProp.add(k, gc.list.indexOf(p), p.getAssetList("property").indexOf(u)+1);
    		}
    	}

    	
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

    	for(int j=0; j<=gc.list.size(); j++) {
    		for(int k=0; k<3; k++) {
    			this.label[j][k] = new Label();
    		}
    	}
    	
    	
    	for(Player p : gc.list.subList(1, gc.list.size())) {
    		Label l = new Label(p.getName());
    		posessedProp.add(l, gc.list.indexOf(p), 0);
    		for(Unit u : p.getAssetList("property")) {
    			Label k = new Label(u.getTile().getTileName());
    			posessedProp.add(k, gc.list.indexOf(p), p.getAssetList("property").indexOf(u));
    		}
    	}
    	
//    	for(Tile t : gc.bc.getBoard()) {
//    		Label l = new Label(t.getTileName());
//    		gameBoard.add(l, gc.bc.getBoard().indexOf(t), 0);
//    	}    	
    	
    	updateScoreboard();

    }
	
	 interface GameControlObserver {
	    	void onDiceRolled(Player player, int result, GameController gameController) throws IOException;
		}

    

}
