package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Dice;
import model.Player;
import model.Tile;
import model.Unit;

/**
 *This class handles different game playing operations such as Buying plots, building house, paying rent etc. 
 */
public class offerScreenController {
	
	private GameController gc;
	private Player player;
	private Tile tile;
	private String desc;
	
	public void setController(GameController gc) {
		// TODO Auto-generated method stub
    	this.gc = gc;		
	}

   @FXML
    private Button percenBtn;

    @FXML
    private Button flatPrice;

	@FXML
	private Label amount;
	
	@FXML
	private Label further;

    @FXML
    private Label tileType;
    
    @FXML
    private Label instruction;

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

    /**
     * THis method gets executed when player wants to build a house on the prpoerth he has bought
     * @param event of build button clicking
     */
    @FXML
    void buildHouseBtn(ActionEvent event) {
    	if(player.getMoney() > tile.getValue("house")) {
//    		gc.getPlayer(player).deductMoney(tile.getValue("Cost"));
        	gc.list.get(0).addMoney(tile.getValue("house"));
        	player.deductMoney(tile.getValue("house"));
        	Unit unit = new Unit("property", tile);
        	player.setAsset(unit);
        	tile.setMainPlayer(player);
    	} else {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Insufficient funds");
			errorAlert.setContentText("You do not have suficient funds to build this.");
			errorAlert.showAndWait();
    	}
	    Stage stage = (Stage) cancelBtn.getScene().getWindow();
	    stage.close();
    	
    }
    
    /**
     * THis method gets executed  when player wants to buy a property he has landed on
     * @param event of buy button clicking
     */
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
    void flatClick(ActionEvent event) {
 	   player.deductMoney(200);
 	   gc.list.get(0).addMoney(200);
	    Stage stage = (Stage) cancelBtn.getScene().getWindow();
	    stage.close();

    }

    @FXML
    void percenBtnClick(ActionEvent event) {
    	int money = (int)(player.getMoney()*0.1);
  	   player.deductMoney(money);
  	   gc.list.get(0).addMoney(money);
	    Stage stage = (Stage) cancelBtn.getScene().getWindow();
	    stage.close();
    }


    @FXML
    void cancelBtnClick(ActionEvent event) {
	    Stage stage = (Stage) cancelBtn.getScene().getWindow();
	    stage.close();
    }

    /**
     *This method gets executed when user wants to play a rent to another user
     *@param button clicking event
     */
    @FXML
    void rentBtnClick(ActionEvent event) {
    	
    	if(player.getMoney() > tile.getValue("rent1")) {
    		gc.getPlayer( tile.getMainPlayer() ).addMoney(tile.getValue("rent1"));
//        	gc.list.get(0).addMoney(tile.getValue("rent1"));
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
    
    /**
     *This method gets executed when user wants to play a rent to another user
     *@param inst tile
     *@param p player
     *@param resultTile resultTile
     */
    public void setOfferType(Tile resultTile, Player p, String inst) {
    	tileType.setText(resultTile.getTileName());
    	player = p;
    	tile = resultTile;
    	desc = inst;
		buildHouseBtn.setVisible(false);
		rentBtn.setVisible(false);
		buyBtn.setVisible(false);
		percenBtn.setVisible(false);
		flatPrice.setVisible(false);
		
		amount.setVisible(false);
		further.setVisible(false);
		instruction.setVisible(false);
    	
		if (resultTile.getType().equals("property") || resultTile.getType().equals("railroad")) {
			amount.setVisible(true);
			further.setVisible(true);
			instruction.setVisible(true);

			if(resultTile.getMainPlayer() == null) {
				buyBtn.setVisible(true);
				amount.setText(String.valueOf(resultTile.getValue("Cost")));
			} else if(resultTile.getMainPlayer().equals(p)){
				buildHouseBtn.setVisible(true);
				
			} else {
				rentBtn.setVisible(true);
				instruction.setText("You'll have to pay rent of ");
				amount.setText(String.valueOf(resultTile.getValue("rent1")));
				cancelBtn.setVisible(false);
			}
			
		} else if (resultTile.getType().equals("community-chest")) {
			
			further.setVisible(true);
			instruction.setVisible(true);

		    instruction.setText("You received the following card");
		    tileType.setText(desc);
		    further.setText("The transaction has been processed. (Press OK!)");
		    cancelBtn.setText("OK!");
			chance(player, desc);
			
		} else if(resultTile.getType().equals("chance")) {
			further.setVisible(true);
		    tileType.setText(desc);
		    further.setText("The transaction has been processed. (Press OK!)");
		    cancelBtn.setText("OK!");
			chance(player, desc);
			
		} else if (resultTile.getType().equals("tax")) {
			
			further.setVisible(true);
			percenBtn.setVisible(true);
			flatPrice.setVisible(true);
			
		} else if (resultTile.getType().equals("go-to-jail")) {
			
			further.setVisible(true);
		    further.setText("A fine of $50 would be collected. (Press OK!)");
		    cancelBtn.setText("OK!");
			p.deductMoney(50);
			gc.list.get(0).addMoney(50);
			gc.movePlayer(p, gc.bc.getTile("10 10"));

		} else if (resultTile.getType().equals("utility")) {

			instruction.setVisible(true);
			flatPrice.setVisible(true);
			instruction.setText("Pay $200 Utility bill");
			flatPrice.setText("Pay Utility bill");
		
		} else if (resultTile.getType().equals("free-parking")) {
			instruction.setVisible(true);
			instruction.setText("Welcome to free resting place.");
		}

    }

    /**
     *This method gets executed when user lands on Chance cards
     *@param p player
     *@param desc description on the card
     */
	void chance(Player p, String desc) {
		// TODO Auto-generated method stub
	    
	    switch(desc) 
	    {
	       case("Move To Go") :
	       {
	    	   gc.movePlayer(player, gc.bc.getBoard().get(0));
	    	   break;
	       }  
	       case("Bank error in your favor. Collect $125") :
	       {
	    	   p.addMoney(125);
	    	   gc.list.get(0).deductMoney(125);
	    	   break;
	       }
	       case("You have won a CrossWord Competition. Collect $100") :
	       {
	    	   p.addMoney(100);
	    	   gc.list.get(0).deductMoney(100);
	    	   break;
	       }
	       case("You have been elected as the Chairman of the Board. Pay each player $50") :
	       {
	    	   for (Player player: gc.list.subList(1, gc.list.size())) {
	    		   if(player != p) {
			    	   gc.fortification(p, player, 50);
	    		   }
	    	   }
	    	   break;
	       }
	       case("Building loan matures. Collect $150 from Bank") :
	       {
	    	   p.addMoney(150);
	    	   gc.list.get(0).deductMoney(150);
	    	   break;
	       }
	       case("Go To Jail. Pay bank $100") :
	       {
	    	   p.deductMoney(100);
	    	   gc.list.get(0).addMoney(100);
	    	   //gc.movePlayer(p, gc.bc.getTile("0 0"));
	    	   break;
	       }
	       case("You inherit $100") :
	       {
	    	   p.addMoney(100);
	    	   gc.list.get(0);
	    	   gc.list.get(0).deductMoney(100);
	    	   break;
	       }
	       case("Hospital fees. Pay $50") :
	       {
	    	   p.deductMoney(50);
	    	   gc.list.get(0).addMoney(50);
	    	   break;
	       }
	       case("Grand Opera Night. Collect $50 from every player for opening night seat") :
	       {
	    	   for (Player player: gc.list.subList(1, gc.list.size())) {
	    		   if(player != p) {
			    	   gc.fortification(player, p, 50);
	    		   }
	    	   }
	    	   break;
	       }
	       case("You are assessed for street repairs. Pay $40 per plot") :
	       {
	    	   p.deductMoney(40);
	    	   gc.list.get(0).addMoney(40);
	    	   break;
	       }
	       case("Go to Jail. Pay $50 to the bank") :
	       {
	    	   p.deductMoney(50);
	    	   gc.list.get(0).addMoney(50);
	    	   gc.movePlayer(p, gc.bc.getTile("0 0"));
	    	   break;
	       }
	       case("Advance to go. Collect 200$ from bank") :
	       {
	    	   gc.movePlayer(p, gc.bc.getBoard().get(0));
	    	   p.addMoney(200);
	    	   gc.list.get(0).deductMoney(200);
	    	   break;
	       }     	    
	    }		    

	}
}