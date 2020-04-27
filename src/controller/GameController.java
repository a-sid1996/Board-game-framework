package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.BoardModel;
import model.Card;
import model.Player;
import model.PlayerTurnModule;
import model.Score;
import model.Tile;
import model.Unit;

/**
 * This controller class is the main controller of the framework which initializes all model objects and
 */
public class GameController implements gameScreenController.GameControlObserver, Serializable {
    ArrayList<Player> list = new ArrayList<Player>();
    BoardModel bc;
    Card cm;
    Score score;
    PlayerTurnModule<Player> turn;
    boolean tournament = false;

    /**
     * It starts the execution of the startup phase. starts reinforcement phase
     *
     * @param bc   is an object of board model
     * @param cm   is an object of card model
     * @param list represents list of player objects playing the game
     * @param turn represents current turn of the player and he will roll the dice
     * @param score score
     * @param tournament tournament
     */
    public GameController(BoardModel bc, Card cm, ArrayList<Player> list, Score score, PlayerTurnModule<Player> turn, boolean tournament) {
        // TODO Auto-generated constructor stub
        this.bc = bc;
        this.cm = cm;
        this.list = list;
        this.score = score;
        this.turn = turn;
        this.tournament = tournament;
    }

    /**
     * This method returns turn of the next player
     *
     * @return next player object
     */
    public Player nextPlayer() {
        return turn.next();
    }

    /**
     * This method player at specific tile index
     *
     * @param player player
     * @return player object
     */
    public Player getPlayer(Player player) {
        System.out.println("HERE  list.indexOf is " +list.indexOf(player));
        return list.get(list.indexOf(player));
    }

    /**
     * This method moves player at the specified tile
     *
     * @param p object
     * @param t object
     */
    public void movePlayer(Player p, Tile t) {
        if (t.getTileName().equals("Go")) {
            p.addMoney(200);
        }
        p.updateCurrentTile(bc.getBoard().get(bc.getBoard().indexOf(t)), 1);
        p.removeCurrentTile(p.getCurrentTile().get(1));
    }


    /**
     * This method moves player to the specific tile coordinates passed as result
     *
     * @param player is current player object
     */
    @Override
    public void onDiceRolled(Player player, int result, GameController gameController) throws IOException {
        movePlayer(player, result, gameController);
    }

    /**
     * This method moves player to the specific tile coordinates passed as result
     *
     * @param gc     is game controller
     * @param p      is current player object
     * @param result results
     * @throws IOException Input Output Exception
     */
    public void movePlayer(Player p, int result, GameController gc) throws IOException {
        // TODO Auto-generated method stub
        //	for(Player player : list) {
        //		if(player == p) {
        Tile resultTile;
        if (bc.getBoard().size() <= bc.getBoard().indexOf(p.getCurrentTile().get(0)) + result) {
            p.addMoney(200);
            resultTile = bc.getBoard().get(bc.getBoard().indexOf(p.getCurrentTile().get(0)) + result - bc.getBoard().size());
        } else {
            resultTile = bc.getBoard().get(bc.getBoard().indexOf(p.getCurrentTile().get(0)) + result);
        }
        p.updateCurrentTile(resultTile, 1);
        p.removeCurrentTile(p.getCurrentTile().get(1));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/offerScreen.fxml"));
        Parent root = (Parent) loader.load();
        Scene newScene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(newScene);
        offerScreenController os  = loader.getController();
        os.setController(gc);
        os.setOfferType(resultTile, p, cm.getDesc());
        newStage.showAndWait();
    }
    
    public Tile movePlayerTournament(Player p, int result, GameController gc) throws IOException {
        // TODO Auto-generated method stub
        //	for(Player player : list) {
        //		if(player == p) {
        Tile resultTile;
        if (bc.getBoard().size() <= bc.getBoard().indexOf(p.getCurrentTile().get(0)) + result) {
            p.addMoney(200);
            resultTile = bc.getBoard().get(bc.getBoard().indexOf(p.getCurrentTile().get(0)) + result - bc.getBoard().size());
        } else {
            resultTile = bc.getBoard().get(bc.getBoard().indexOf(p.getCurrentTile().get(0)) + result);
        }
        p.updateCurrentTile(resultTile, 1);
        p.removeCurrentTile(p.getCurrentTile().get(1));

		return resultTile;
    }

    //}
    //}

    /**
     * It starts the execution of reinforcement phase.
     * Most common reinforcement strategy in all board game is the distribution of units equally among players
     *
     * @param list  represents list of player objects playing the game
     * @param units are total units used in game
     */
    private void reinforcement(ArrayList<Player> list, Unit[] units) {
        // TODO Auto-generated method stub
        for (Player player : list) {
            for (Unit u : units) {
                if (player.getName().equalsIgnoreCase("money")) {
                    player.setMoney((int) (u.getAmount() / list.size()));
                    break;
                }
            }
        }
    }

    /**
     * It starts the execution of fortification phase.
     * Most common fortification strategy in all board game is passing of assets between players according to the rules of the game.
     *
     * @param player1 is a player who is giving an  asset
     * @param player2 is a player who is receiving an asset
     * @param amount  is the money to be transferred between players
     * @return boolean
     */
    public boolean fortification(Player player1, Player player2, int amount) {
        if (player1.getMoney() > amount && player1.getMoney() > 0 && amount > 0) {
            player1.setMoney(player1.getMoney() - amount);
            player2.setMoney(player2.getMoney() + amount);
            return true;
        }
        return false;
    }

	public void removePlayer(Player p) {
		// TODO Auto-generated method stub

//		p.getCurrentTile().get(0).setMainPlayer(null);
		
		for(Tile t : p.getCurrentTile()) {
			t.setMainPlayer(null);
		}

		list.get(0).addMoney(p.getMoney());
		p.deductMoney(p.getMoney());
		
		list.remove(p);
		turn.setList(new ArrayList<>(list.subList(1, list.size())));

	}

}

//Dummy function for future build 
//	public void performpayment(List<Player> list, Player player, int amount) 
//	{
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) == player) {
//				continue;
//			} else {
//				player.setMoney(player.getMoney() - amount);
//				list.get(i).setMoney(list.get(i).getMoney() + amount);
//			}
//
//		}
//
//	}
