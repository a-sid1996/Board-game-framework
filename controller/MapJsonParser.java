package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import model.Tile;
import model.Unit;

public class MapJsonParser {
	private static final Tile Null = null;

	public static void main(String args[]) throws Exception {

		ArrayList<Tile> TileList = new ArrayList<Tile>();
		String jsonInput = "{\r\n" + 
				"\"JObjects\": \r\n" + 
				"	{\r\n" + 
				"		\"JArray1\":\r\n" + 
				"		[\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Go\",\r\n" + 
				"				 \"b_type\": \"go\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Mediterranean Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"60\",\r\n" + 
				"				 \"f_rent\": \"[2,10,30,90,160,250]\",\r\n" + 
				"				 \"g_house\": \"50\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Community Chest\",\r\n" + 
				"				 \"b_type\": \"communit-chest\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Baltic Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"60\",\r\n" + 
				"				 \"f_rent\": \"[4,20,60,180,320,450]\",\r\n" + 
				"				 \"g_house\": \"50\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Income Tax\",\r\n" + 
				"				 \"b_type\": \"tax\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"200\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Reading Railroad\",\r\n" + 
				"				 \"b_type\": \"railroad\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"200\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Oriental Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"100\",\r\n" + 
				"				 \"f_rent\": \"[6,30,90,270,400,550]\",\r\n" + 
				"				 \"g_house\": \"50\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Chance\",\r\n" + 
				"				 \"b_type\": \"chance\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Vermont Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"100\",\r\n" + 
				"				 \"f_rent\": \"[6,30,90,270,400,550]\",\r\n" + 
				"				 \"g_house\": \"50\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Connecticut Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"120\",\r\n" + 
				"				 \"f_rent\": \"[8,40,100,300,450,600]\",\r\n" + 
				"				 \"g_house\": \"50\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Jail\",\r\n" + 
				"				 \"b_type\": \"jail\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"St. Charles Place\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"140\",\r\n" + 
				"				 \"f_rent\": \"[10,50,150,450,625,750]\",\r\n" + 
				"				 \"g_house\": \"100\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Electric Compand_y\",\r\n" + 
				"				 \"b_type\": \"utility\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"150\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"States Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"140\",\r\n" + 
				"				 \"f_rent\": \"[10,50,150,450,625,750]\",\r\n" + 
				"				 \"g_house\": \"100\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Virginia Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"160\",\r\n" + 
				"				 \"f_rent\": \"[12,60,180,500,700,900]\",\r\n" + 
				"				 \"g_house\": \"100\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Pennsylvania Railroad\",\r\n" + 
				"				 \"b_type\": \"railroad\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"200\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"St. James Place\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"180\",\r\n" + 
				"				 \"f_rent\": \"[14,70,200,550,750,950]\",\r\n" + 
				"				 \"g_house\": \"100\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Community Chest\",\r\n" + 
				"				 \"b_type\": \"community-chest\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Tennessee Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"180\",\r\n" + 
				"				 \"f_rent\": \"[14,70,200,550,750,950]\",\r\n" + 
				"				 \"g_house\": \"100\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Newyork Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"200\",\r\n" + 
				"				 \"f_rent\": \"[16,80,220,600,800,1000]\",\r\n" + 
				"				 \"g_house\": \"100\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Free Parking\",\r\n" + 
				"				 \"b_type\": \"free-parking\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Kentucky Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"220\",\r\n" + 
				"				 \"f_rent\": \"[18,90,250,700,875,1050]\",\r\n" + 
				"				 \"g_house\": \"150\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Chance\",\r\n" + 
				"				 \"b_type\": \"chance\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Indiana Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"220\",\r\n" + 
				"				 \"f_rent\": \"[18,90,250,700,875,1050]\",\r\n" + 
				"				 \"g_house\": \"150\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Illnois Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"240\",\r\n" + 
				"				 \"f_rent\": \"[20,100,300,750,925,1100]\",\r\n" + 
				"				 \"g_house\": \"150\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"B. & O. Railroad\",\r\n" + 
				"				 \"b_type\": \"railroad\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"200\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Atlatic Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"260\",\r\n" + 
				"				 \"f_rent\": \"[22,110,330,800,975,1150]\",\r\n" + 
				"				 \"g_house\": \"150\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Ventura Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"260\",\r\n" + 
				"				 \"f_rent\": \"[22,110,330,800,975,1150]\",\r\n" + 
				"				 \"g_house\": \"150\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Water Works\",\r\n" + 
				"				 \"b_type\": \"utility\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"150\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Marvin Gardens\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"280\",\r\n" + 
				"				 \"f_rent\": \"[24,120,360,850,1025,1200]\",\r\n" + 
				"				 \"g_house\": \"150\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Go To Jail\",\r\n" + 
				"				 \"b_type\": \"go-to-jail\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Pacific Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"300\",\r\n" + 
				"				 \"f_rent\": \"[26,130,390,900,1100,1275]\",\r\n" + 
				"				 \"g_house\": \"200\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"North Carolina Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"300\",\r\n" + 
				"				 \"f_rent\": \"[26,130,390,900,1100,1275]\",\r\n" + 
				"				 \"g_house\": \"200\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Community Chest\",\r\n" + 
				"				 \"b_type\": \"community-chest\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Pennsylvania Avenue\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"320\",\r\n" + 
				"				 \"f_rent\": \"[28,150,450,1000,1200,1400]\",\r\n" + 
				"				 \"g_house\": \"200\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Shortline\",\r\n" + 
				"				 \"b_type\": \"railroad\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"200\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Chance\",\r\n" + 
				"				 \"b_type\": \"chance\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Park Place\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"350\",\r\n" + 
				"				 \"f_rent\": \"[35,175,500,1100,1300,1500]\",\r\n" + 
				"				 \"g_house\": \"200\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Luxury Tax\",\r\n" + 
				"				 \"b_type\": \"tax\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"100\"\r\n" + 
				"				 },\r\n" + 
				"				 {\r\n" + 
				"				 \"a_name\": \"Boardwalk\",\r\n" + 
				"				 \"b_type\": \"property\",\r\n" + 
				"				 \"c_x\": \"0\",\r\n" + 
				"				 \"d_y\": \"0\",\r\n" + 
				"				 \"e_cost\": \"400\",\r\n" + 
				"				 \"f_rent\": \"[50,200,600,1400,1700,2000]\",\r\n" + 
				"				 \"g_house\": \"200\"\r\n" + 
				"				 }\r\n" + 
				"				 \r\n" + 
				"				 \r\n" + 
				"		]\r\n" + 
				"\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"}  ";
		// "I want to iterate though the objects in the array..."
		JSONObject outerObject = new JSONObject(jsonInput);
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
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("tax")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);		
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("railroad")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);
				tile.setValue("Cost", cost);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("chance")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				tile = new Tile(name, x, y);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("go-to-jail")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				tile = new Tile(name, x, y);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("utility")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));
				tile = new Tile(name, x, y);
				tile.setValue("Cost", cost);
				TileList.add(tile);

			}

			else if (tmap.get("b_type").equals("free-parking")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
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
	
		
	}
}