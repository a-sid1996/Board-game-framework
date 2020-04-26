package controller;

import model.Player;
import model.Tile;
import model.Unit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import controller.GameController;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StrategyAttack  implements Strategy{

	
	private GameController gc;
	private offerScreenController oc;
	private Player player;
	private Tile tile;
	private String desc;

	
	StrategyAttack(GameController gc, offerScreenController oc){
		this.oc = oc;
		this.gc= gc;
	}
	
	public void setOfferType(Tile resultTile, Player p, String desc2) {
		String tileType = resultTile.getTileName();
		player = p;
    	tile = resultTile;
    	desc = desc2;
    	if (resultTile.getType().equals("property") || resultTile.getType().equals("railroad")) 
    	{
    		/*BUY FUNCTIONALITY*/
			if(resultTile.getMainPlayer() == null) 
			{
				System.out.println("Attacker buy" +p.getName());
				if(p.getMoney() > tile.getValue("Cost"))
				{
		        	gc.list.get(0).addMoney(tile.getValue("Cost"));
		        	p.deductMoney(tile.getValue("Cost"));
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
			
			/*BUILD FUNCTIONALITY*/

			else if(resultTile.getMainPlayer().equals(p))
			{
				if(!resultTile.getType().equals("railroad")){
				System.out.println("Attacker build" +p.getName());
				if(p.getMoney() > tile.getValue("hotel")) 
				{
		        	gc.list.get(0).addMoney(tile.getValue("hotel"));
		        	p.deductMoney(tile.getValue("hotel"));
		        	Unit unit = new Unit("property", tile);
		        	p.setAsset(unit);
		        	tile.setMainPlayer(p);
		    	} 
				else 
				{
					System.out.println("Insufficient fund");
		    	}}
								
			}
			
			/*RENT PAYING FUNCTIONALITY*/
			else 
			{
				if(p.getMoney() > tile.getValue("rent1")) 
				{
		    		gc.getPlayer( tile.getMainPlayer() ).addMoney(tile.getValue("rent1"));
		        	gc.list.get(0).addMoney(tile.getValue("rent1"));
		        	p.deductMoney(tile.getValue("rent1"));
		    	} 
				else
				{

					System.out.println("You do not have suficient funds to pay rent this.\\n Assigning loan from bank");					      	
					gc.list.get(0).deductMoney(tile.getValue("rent1"));
					tile.getMainPlayer().addMoney(tile.getValue("rent1"));
				}
			}
			
		}
    	
    	else if (resultTile.getType().equals("community-chest")) 
    	{	    		
    		System.out.println("You received the following card : " + desc);
			oc.chance(player, desc);			
		} 
    	
    	else if(resultTile.getType().equals("chance")) 
    	{

    		System.out.println("You received the following card : " + desc);
			oc.chance(player, desc);
			
		} 
    	
    	else if (resultTile.getType().equals("tax")) 
    	{
			
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
    		
		 }

		
	}


}
