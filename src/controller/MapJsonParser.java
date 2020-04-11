package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import org.apache.commons.io.*;
import org.apache.commons.io.IOUtils;

import model.Tile;
import model.Unit;
import controller.EditMap;


public class MapJsonParser {
	//private static final Tile Null = null;
	//private static final EditMap editmap = null;
	public static ArrayList<Tile> TileList = new ArrayList<Tile>();
	
	public static void main(String args[]) throws Exception 
	{
		
		File f = new File("C:\\Users\\kjagani\\OneDrive - Laurentide Controls\\Desktop\\Monoply_temp\\Board-game-framework\\src\\controller\\mapFinal.json");
		
		InputStream is = new FileInputStream("C:\\Users\\kjagani\\OneDrive - Laurentide Controls\\Desktop\\Monoply_temp\\Board-game-framework\\src\\controller\\mapFinal.json");
        String jsonTxt = IOUtils.toString(is, "UTF-8");
		
		// "I want to iterate though the objects in the array..."
		JSONObject outerObject = new JSONObject(jsonTxt);
		JSONObject innerObject = outerObject.getJSONObject("JObjects");
		JSONArray jsonArray = innerObject.getJSONArray("JArray1");
		for (int i = 0, size = jsonArray.length(); i < size; i++) {
			JSONObject objectInArray = jsonArray.getJSONObject(i);
			String[] elementNames = JSONObject.getNames(objectInArray);

			TreeMap<String, Object> tmap = new TreeMap<String, Object>();
			for (String elementName : elementNames) {
				String value = objectInArray.getString(elementName);
				tmap.put(elementName, value);
			}
			
			Tile tile = null;
			
			
			if (tmap.get("b_type").equals("go")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("go");
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("property")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				int house = Integer.parseInt((String) tmap.get("g_house"));
				String tempRent = (String) tmap.get("f_rent");
				tempRent = tempRent.replace("[", "");
				tempRent = tempRent.replace("]", "");
				String vals[] = tempRent.split(",");
				ArrayList<Integer> rentList = new ArrayList<Integer>();
				
				for(String s: vals) 
				{
					rentList.add(Integer.parseInt(s));
				}
				
				tile = new Tile(name, x, y);	
				tile.setTypeOfTile("property");
				tile.setValue("Cost", cost);
				tile.setValue("house", house);
				tile.setValue("rent1", rentList.get(0));
				tile.setValue("rent2", rentList.get(1));
				tile.setValue("rent3", rentList.get(2));
				tile.setValue("rent4", rentList.get(3));
				tile.setValue("rent5", rentList.get(4));
				tile.setValue("rent6", rentList.get(5));
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("communit-chest")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("communit-chest");
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("tax")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);	
				tile.setTypeOfTile("tax");
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("railroad")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("railroad");
				tile.setValue("Cost", cost);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("chance")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("chance");
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("go-to-jail")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("go-to-jail");
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("utility")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("utility");
				tile.setValue("Cost", cost);
				TileList.add(tile);

			}
      
			else if (tmap.get("b_type").equals("free-parking")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("free-parking");
				TileList.add(tile);

			}	

		}
		System.out.println("Total tile objects created :  " +TileList.size());
		
		for(Tile tile : TileList) 
		{
			
			if(tile.getTileName().equalsIgnoreCase("Baltic Avenue")) 
			{
				System.out.println("before tile edit");
				System.out.println(tile.getTileName());
				System.out.println(tile.getInternalValue());
							
			}			
		}
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to edit : ");
		String nametoedit  = sc.nextLine();
		System.out.println("Enter cost  value to edit : ");
		int costtoEdit = Integer.parseInt(sc.nextLine());
		System.out.println("Enter house value to edit : ");
		int housetoEdit = Integer.parseInt(sc.nextLine());
	
		EditMap.EditAvenueCost(nametoedit, costtoEdit);
		EditMap.EditAvenuehouse(nametoedit, housetoEdit);
		
		for(Tile tile : TileList) 
		{
			
			if(tile.getTileName().equalsIgnoreCase(nametoedit)) 
			{
				System.out.println("After tile edit");
				System.out.println(tile.getTileName());
				System.out.println(tile.getInternalValue());
//				System.out.println(tile.getValue("cost"));
//				System.out.println(tile.getValue("house"));
							
			}			
		}
	
		
		
	}
}