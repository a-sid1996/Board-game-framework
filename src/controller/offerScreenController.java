package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Player;
import model.Tile;
import model.Unit;

public class offerScreenController {
	
	private GameController gc;
	private Player player;
	private Tile tile;
	
	public void setController(GameController gc) {
		// TODO Auto-generated method stub
    	this.gc = gc;		
	}
	
	@FXML
	private Label amount;

    @FXML
    private Label tileType;

    @FXML
    private Button buyBtn;

    @FXML
    private Button rentBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private GridPane cardProp;
    
    @FXML
    private Button buildHouseBtn;

    @FXML
    void buildHouseBtn(ActionEvent event) {

    }    
    @FXML
    void buyBtnClick(ActionEvent event) {
    	if(player.getMoney() > tile.getValue("Cost")) {
//    		gc.getPlayer(player).deductMoney(tile.getValue("Cost"));
        	gc.list.get(0).addMoney(tile.getValue("Cost"));
        	player.deductMoney(tile.getValue("Cost"));
        	Unit unit = new Unit("property", tile);
        	player.setAsset(unit);
        	tile.setMainPlayer(player);
    	} else {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Insufficient funds");
			errorAlert.setContentText("You do not have suficient funds to buy this.");
			errorAlert.showAndWait();
    	}
	    Stage stage = (Stage) cancelBtn.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void cancelBtnClick(ActionEvent event) {
	    Stage stage = (Stage) cancelBtn.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void rentBtnClick(ActionEvent event) {
    	
    	if(player.getMoney() > tile.getValue("rent1")) {
//    		gc.getPlayer(player).deductMoney(tile.getValue("Cost"));
        	gc.list.get(0).addMoney(tile.getValue("rent1"));
        	player.deductMoney(tile.getValue("rent1"));
    	} else {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Insufficient funds");
			errorAlert.setContentText("You do not have suficient funds to pay rent this.\n Assigning loan from bank.");
			errorAlert.showAndWait();        	
			gc.list.get(0).deductMoney(tile.getValue("rent1"));
			tile.getMainPlayer().addMoney(tile.getValue("rent1"));
    	}
	    Stage stage = (Stage) cancelBtn.getScene().getWindow();
	    stage.close();

    }
    
    public void setOfferType(Tile resultTile, Player p) {
    	tileType.setText(resultTile.getTileName());
    	player = p;
    	tile = resultTile;
    	
		if (resultTile.getType().equals("property")) {
			if(resultTile.getMainPlayer() == null) {
				buildHouseBtn.setVisible(false);
				rentBtn.setVisible(false);
			} else if(resultTile.getMainPlayer().equals(p)){
				rentBtn.setVisible(false);
				buyBtn.setVisible(false);
			} else {
				buildHouseBtn.setVisible(false);
				buyBtn.setVisible(false);
			}
		} else if (resultTile.getType().equals("community-chest")) {
			
		} else if (resultTile.getType().equals("tax")) {
		
		} else if (resultTile.getType().equals("railroad")) {

		} else if (resultTile.getType().equals("chance")) {
			
		} else if (resultTile.getType().equals("go-to-jail")) {

		} else if (resultTile.getType().equals("utility")) {
		
		} else if (resultTile.getType().equals("free-parking")) {
			
		}

    }
    

}