package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * This class is a controller class of Tournament mode result box 
 */

public class tournamentRController {
	
    @FXML
    private GridPane resultGrid;

    /**
     * This method displays results of the tournament game to the game window
     * @param results is the Output grid of the game
     * @param gameN is number of games being played
     * @param mapN is number of maps used in the Tournament
     */
	public void setTournamentRController(String[][] results, int gameN, int mapN) {
		// TODO Auto-generated method stub
		
        for(int i=1; i<=mapN; i++) {
    		Label l = new Label("Map "+ i);
    		resultGrid.add(l, 0, i);        		
        }
    	for(int j=1; j<=gameN; j++) {
    		Label l = new Label("Game "+ j);
    		resultGrid.add(l, j, 0);        		
    	}

        
        for (int i=0; i<results.length; i++) {
        	for(int j=0; j<results[i].length; j++) {
        		Label l = new Label(results[i][j]);
        		resultGrid.add(l, i+1, j+1);
        	}
        }

	}    

    

}
