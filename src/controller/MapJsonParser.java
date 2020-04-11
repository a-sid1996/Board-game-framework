package controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import model.Tile;
import model.Unit;

public class MapJsonParser {
	private static final Tile Null = null;

//	public static void main(String args[]) throws Exception {
	public static ArrayList<Tile> MapJsonParser1(String jsonInput1) throws JSONException, IOException {
		final ArrayList<Tile> TileList = new ArrayList<Tile>();
		String jsonInput = FileUtils.readFileToString(new File(jsonInput1));
		JSONObject outerObject = new JSONObject(jsonInput);
		JSONObject innerObject = outerObject.getJSONObject("JObjects");
		JSONArray jsonArray = innerObject.getJSONArray("JArray1");
		for (int i = 0, size = jsonArray.length(); i < size; i++) 
		{
			JSONObject objectInArray = jsonArray.getJSONObject(i);
			String[] elementNames = JSONObject.getNames(objectInArray);

			TreeMap<String, Object> tmap = new TreeMap<String, Object>();
			for (String elementName : elementNames) 
			{
				String value = objectInArray.getString(elementName);
				if(value != null) 
				{
					if(elementName.equalsIgnoreCase("a_name") && value instanceof String) 
					{
						tmap.put(elementName, value);
					}
					
					if(elementName.equalsIgnoreCase("b_type") && value instanceof String)
					{
						tmap.put(elementName, value);
					}
					
					if(elementName.equalsIgnoreCase("c_x") && Float.parseFloat(value)% 1==0 && Float.parseFloat(value) >=0 ) 
					{
						tmap.put(elementName, value);
					}
					
					if(elementName.equalsIgnoreCase("d_y") && Float.parseFloat(value)% 1==0 && Float.parseFloat(value) >=0 ) 
					{
						tmap.put(elementName, value);
					}
					
					if(elementName.equalsIgnoreCase("e_cost") && Float.parseFloat(value)% 1==0 && Float.parseFloat(value) >0 ) 
					{
						tmap.put(elementName, value);
					}
					if(elementName.equalsIgnoreCase("g_house") && Float.parseFloat(value)% 1==0 && Float.parseFloat(value) >0 ) 
					{
						tmap.put(elementName, value);
					}
					if(elementName.equalsIgnoreCase("e_cost") && Float.parseFloat(value)% 1==0 && Float.parseFloat(value) >0 ) 
					{
						tmap.put(elementName, value);
					}
								
				}
				tmap.put(elementName, value); 
			}
			
			Tile tile = null;
			
			if (tmap.get("b_type").equals("go")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("property")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
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
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("tax")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);		
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("railroad")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);
				tile.setValue("Cost", cost);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("chance")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("go-to-jail")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("utility")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);
				tile.setValue("Cost", cost);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("free-parking")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				TileList.add(tile);

			}	

		}
		System.out.println("Total tile objects created :  " +TileList.size());
		
			for(Tile tile : TileList) 
			{
				System.out.println(tile.getTileName());
				System.out.println(tile.getTileCoordinates());
				
				System.out.println("-------------");
			}
		
		return TileList;
		
	}
}