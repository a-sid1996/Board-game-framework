package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import controller.InvalidMapException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import org.apache.commons.io.*;
import org.apache.commons.io.IOUtils;
import model.Tile;
import model.Unit;


public class maptest {
	private static final Tile Null = null;
	public static ArrayList<Tile> TileList = new ArrayList<Tile>();
	
	public static void main(String args[]) throws Exception {
		
		File f = new File("C:\\Users\\kjagani\\OneDrive - Laurentide Controls\\Desktop\\Monoply_temp\\Board-game-framework\\src\\controller\\FinalMapFile.json");
		
		InputStream is = new FileInputStream("C:\\Users\\kjagani\\OneDrive - Laurentide Controls\\Desktop\\Monoply_temp\\Board-game-framework\\src\\controller\\FinalMapFile.json");
        String jsonTxt = IOUtils.toString(is, "UTF-8");
       // System.out.println(jsonTxt);
		
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
				boolean flag = true;
				//System.out.println(value.length());
				if(value.length()>0) 
				{
					if(elementName.equalsIgnoreCase("a_name") && value instanceof String) 
					{
						tmap.put(elementName, value);
					}					
					else if(elementName.equalsIgnoreCase("b_type") && value instanceof String)
					{
						tmap.put(elementName, value);
					}					
					else if(elementName.equalsIgnoreCase("c_x") && Float.parseFloat(value)% 1==0 && Float.parseFloat(value) >=0 ) 
					{
						tmap.put(elementName, value);
					}					
					else if(elementName.equalsIgnoreCase("d_y") && Float.parseFloat(value)% 1==0 && Float.parseFloat(value) >=0 ) 
					{
						tmap.put(elementName, value);
					}					
					else if(elementName.equalsIgnoreCase("e_cost") && Float.parseFloat(value)% 1==0 && Float.parseFloat(value) >0 ) 
					{
						tmap.put(elementName, value);
					}
					else if(elementName.equalsIgnoreCase("g_house") && Float.parseFloat(value)% 1==0 && Float.parseFloat(value) >0 ) 
					{
						tmap.put(elementName, value);
					}
					else if(elementName.equalsIgnoreCase("f_rent")) 
					{
						
						String tempRent = value;
						if(tempRent.startsWith("[") && tempRent.endsWith("]")) 
						{
						tempRent = tempRent.replace("[", "");
						tempRent = tempRent.replace("]", "");
						}
						
						String vals[] = tempRent.split(",");
						ArrayList<Integer> rentList = new ArrayList<Integer>(vals.length);
					
						
						for(String s: vals) 
						{
							try 
							{
								rentList.add(Integer.parseInt(s));
							}
						    catch(NumberFormatException nfe)
							{
						    	rentList.add(-1);
						    }
						}
						
						if(rentList.size() == 6) 
						{
							for(int a : rentList) 
							{
								if(a > 0) 
								{
									continue;
								}
								else 
								{
									throw new InvalidMapException("Invalid Map : rent can not be negative amount ");
								}
							}							
						} else 
						{
							throw new InvalidMapException("Invalid Map : rent range must be total 6  ");
						}					
						
						tmap.put(elementName, value);						
					}
					else 
					{
						throw new InvalidMapException("Invalid Map : Coordinates can not be float  ");
					}
								
				}				
				else 
				{
					throw new InvalidMapException("Null Values are not allowed");
				}
				
			}
			
			Tile tile = null;
			System.out.println(tmap);
			if (tmap.get("b_type").equals("go")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("go");
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

			else if (tmap.get("b_type").equals("community-chest")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("communit-chest");
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("tax")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);	
				tile.setTypeOfTile("tax");
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("railroad")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("railroad");
				tile.setValue("Cost", cost);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("chance")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("chance");
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("go-to-jail")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("go-to-jail");
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("utility")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("utility");
				tile.setValue("Cost", cost);
				TileList.add(tile);

			}
      
			else if (tmap.get("b_type").equals("free-parking")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("free-parking");
				TileList.add(tile);

			}	
			
			else if (tmap.get("b_type").equals("jail")){
				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("d_y"));
				tile = new Tile(name, x, y);
				tile.setTypeOfTile("jail");
				TileList.add(tile);
			}

		}
		
		int temp_x1 = 11;
		int temp_y1 = 0;
		for(Tile tile : TileList) 
		{
			String[] temp_xy = tile.getTileCoordinates().split(" ");
			int temp_x2 = Integer.parseInt(temp_xy[0]);
			int temp_y2 = Integer.parseInt(temp_xy[1]);	
			System.out.println(tile.getTileName());
			System.out.println("x1 " +temp_x1);
			System.out.println("y1 " +temp_y1);
			System.out.println("x2 " +temp_x2);
			System.out.println("y2 " +temp_y2);
			
			if(temp_x1 - temp_x2 == 1 || temp_x1 - temp_x2 == -1)
			{
				if(temp_y1 != temp_y2) 
				{
					throw new InvalidMapException("Invalid map : Tiles coordinates are not in sync 1");
				}
			}
			else if(temp_y1 - temp_y2 == 1 || temp_y1 - temp_y2 == -1) 
			{
				if(temp_x1 != temp_x2) 
				{
					throw new InvalidMapException("Invalid map : Tiles coordinates are not in sync 2");
					
				}
			}
			
			
			System.out.println("--------");
			temp_x1 = temp_x2;
			temp_y1 = temp_y2;
		}
	// new HAshMap("name of tile" , Tile);
		
	}
}











