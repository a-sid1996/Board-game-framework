package controller;

import model.Tile;
import model.BoardModel;

import java.util.ArrayList;

import controller.MapJsonParser;

public class EditMap {

	BoardModel boardModel;
	MapJsonParser map;
	public static ArrayList<Tile> al = new ArrayList<Tile>(MapJsonParser.TileList);
	
	public static void EditValues()
	{
		
		ArrayList<String> AvenuePlots = new ArrayList<String>();
		ArrayList<String> otherEditablePlots = new ArrayList<>();
		
		for(Tile tile : al)
		{
			String type = tile.getTypeOfTile();
			if(type.equalsIgnoreCase("Property"))
			{
			   AvenuePlots.add(tile.getTileName());
			}
		}
		
		for(Tile tile : al)
		{
			String type = tile.getTypeOfTile();
			if(type.equalsIgnoreCase("tax") || type.equalsIgnoreCase("railroad") || type.equalsIgnoreCase("utility") )
			{
			   otherEditablePlots.add(tile.getTileName());
			}
		}
	}
	
	
	//
	public static void EditAvenueCost(String name, int cost) 
	{
		for(Tile t : al) 
		{
			if(t.getTileName().equalsIgnoreCase(name)) 
			{
				t.setValue("Cost", cost);
			}
		}
	}
	
	public static void EditAvenuehouse(String name, int house) 
	{
		for(Tile t : al) 
		{
			if(t.getTileName().equalsIgnoreCase(name)) 
			{
				t.setValue("house", house);
			}
		}
		
	}
	public static void EditAvenueRent1(String name, int rent1) 
	{
		for(Tile t : al) 
		{
			if(t.getTileName().equalsIgnoreCase(name)) 
			{
				t.setValue("rent1", rent1);
			}
		}
	}
	public static void EditAvenueRent2(String name, int rent2) 
	{
		for(Tile t : al) 
		{
			if(t.getTileName().equalsIgnoreCase(name)) 
			{
				t.setValue("rent2", rent2);
			}
		}
	}
	public static void EditAvenueRent3(String name, int rent3) 
	{
		for(Tile t : al) 
		{
			if(t.getTileName().equalsIgnoreCase(name)) 
			{
				t.setValue("rent3", rent3);
			}
		}
	}
	public static void EditAvenueRent4(String name, int rent4) 
	{
		for(Tile t : al) 
		{
			if(t.getTileName().equalsIgnoreCase(name)) 
			{
				t.setValue("rent4", rent4);
			}
		}
	}
	public static void EditAvenueRent5(String name, int rent5) 
	{
		for(Tile t : al) 
		{
			if(t.getTileName().equalsIgnoreCase(name)) 
			{
				t.setValue("rent5", rent5);
			}
		}
	}
	
	public static void EditOtherPlotCost(String name, int cost) 
	{
		for(Tile t : al) 
		{
			if(t.getTileName().equalsIgnoreCase(name)) 
			{
				t.setValue("cost", cost);
			}
		}
	}
	public static void EditAvenueRent6(String name, int rent6) 
	{
		for(Tile t : al) 
		{
			if(t.getTileName().equalsIgnoreCase(name)) 
			{
				t.setValue("cost", rent6);
			}
		}
	}
}	
