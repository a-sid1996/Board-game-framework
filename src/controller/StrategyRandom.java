package controller;

import model.Player;
import model.Tile;
import model.Unit;

import java.util.Random;

import controller.GameController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This is the implementation of strategy interface where a player is aggresive.
 * Random player will either buy plot/build house or he will not do so. 
 */
public class StrategyRandom implements Strategy{

	
	private GameController gc;
	private offerScreenController oc;
	private Player player;
	private Tile tile;
	private String desc;

	/**
	 * Constructor to initialize strategyRandom
	 * @param gc is GameController object
	 * @param oc is OfferScreenController object
	 */
	StrategyRandom(GameController gc,offerScreenController oc ){
		this.gc= gc;
		this.oc = oc;
	}
	
	/**
	 * This method gets executed when player is playing randomly
	 * @param resultTile is the tile player lands on
	 * @param p is the current player whose turn is going on
	 * @param desc2 is the description on the card
	 */
	public void setOfferType(Tile resultTile, Player p, String desc2) {
		String tileType = resultTile.getTileName();
    	tile = resultTile;
    	desc = desc2;
    	
    	if (resultTile.getType().equals("property") || resultTile.getType().equals("railroad")) 
    	{
    		/*BUY FUNCTIONALITY*/
			if(resultTile.getMainPlayer() == null) 
			{
				Random r = new Random();
				int low = 1;
				int high = 3;
				int result = r.nextInt(high-low) + low;
				System.out.println("result " +result);
				if(result == 1)
				{
					//buy
					System.out.println("Attacker buy " +p.getName());
					if(p.getMoney() > tile.getValue("cost"))
					{
			        	gc.list.get(0).addMoney(tile.getValue("cost"));
			        	p.deductMoney(tile.getValue("cost"));
			        	Unit unit = new Unit("property", tile);
			        	p.setAsset(unit);
			        	p.updateCurrentTile(tile, 0);
			        	tile.setMainPlayer(p);
			    	} 
					else
					{
						System.out.println("Insufficient fund");
			    	}
				}
				else 
				{
					System.out.println("Entering else : means player wont BUY anything");
				}
			}
		/*BUILD FUNCTIONALITY*/
			else if(resultTile.getMainPlayer().equals(p))
			{
				Random r = new Random();
				int low = 1;
				int high = 2;
				int result = r.nextInt(high-low) + low;
				System.out.println("result " +result);
				if(result == 1)
				{
					if(!resultTile.getType().equals("railroad"))
					{
						System.out.println("Attacker build" +p.getName());
						if(p.getMoney() > tile.getValue("house"))
						{
							gc.list.get(0).addMoney(tile.getValue("house"));
							p.deductMoney(tile.getValue("house"));
							Unit unit = new Unit("property", tile);
							p.setAsset(unit);
							tile.setMainPlayer(p);
						}
						else
						{
							System.out.println("Insufficient fund");
						}
					}
				}
				else 
				{
					System.out.println("Entering else : means player wont BUILD anything");
				}								
			} 
			
			/*RENT PAYING FUNCTIONALITY*/
			else 
			{
				if(tournamentController.a == 0)
				{
					if (p.getMoney() > tile.getValue("rent1")) {
						gc.getPlayer(tile.getMainPlayer()).addMoney(tile.getValue("rent1"));
						gc.list.get(0).addMoney(tile.getValue("rent1"));
						p.deductMoney(tile.getValue("rent1"));
					} else {
						System.out.println("You do not have suficient funds to pay rent this.\\n Assigning loan from bank");
						gc.list.get(0).deductMoney(tile.getValue("rent1"));
						tile.getMainPlayer().addMoney(tile.getValue("rent1"));
					}
				}
			}
			
		}
    	
    	else if (resultTile.getType().equals("community-chest")) 
    	{	    		
    		System.out.println("You received the following card : " + desc);
			oc.chance(p, desc);			
		} 
    	
    	else if(resultTile.getType().equals("chance")) 
    	{

    		System.out.println("You received the following card : " + desc);
			oc.chance(p, desc);
			
		} 
    	
    	else if (resultTile.getType().equals("tax")) 
    	{
    		System.out.println("Tax paid");
			p.deductMoney(100);
			gc.list.get(0).addMoney(100);
		} 
    	
    	else if (resultTile.getType().equals("go-to-jail")) 
    	{
			
			System.out.println("A fine of $50 would be collected.");
			p.deductMoney(50);
			gc.list.get(0).addMoney(50);
			gc.movePlayer(p, gc.bc.getTile("10 10"));

		} 
    	
    	else if (resultTile.getType().equals("utility")) 
    	{
    		System.out.println("Utility bill of $200 is collected");
    		p.deductMoney(200);
			gc.list.get(0).addMoney(200);
		
		} 
    	
    	else if (resultTile.getType().equals("free-parking"))
    	 {
    		System.out.println("Free parking");
		 }
		
	}

		
}
