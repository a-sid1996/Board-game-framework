package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;
import model.Tile;
import model.Unit;

public class MapJsonParser {
	public static void main(String[] args) throws Exception {

		ArrayList<Tile> TileList = new ArrayList<Tile>();
		String jsonInput = "{\r\n" + "\"JObjects\": \r\n" + "	{\r\n" + "		\"JArray1\":\r\n" + "		[\r\n"
				+ "				 {\r\n" + "				 \"a_name\": \"Go\",\r\n"
				+ "				 \"b_type\": \"go\",\r\n" + "				 \"c_x\": \"0\",\r\n"
				+ "				 \"d_y\": \"0\"\r\n" + "				 },\r\n" + "				 {\r\n"
				+ "				 \"a_name\": \"Mediterranean Avenue\",\r\n"
				+ "				 \"b_type\": \"property\",\r\n" + "				 \"c_x\": \"0\",\r\n"
				+ "				 \"d_y\": \"0\",\r\n" + "				 \"e_cost\": \"60\",\r\n"
				+ "				 \"f_rent\": \"[2,10,30,90,160,250]\",\r\n" + "				 \"g_house\": \"50\"\r\n"
				+ "				 },\r\n" + "				 {\r\n"
				+ "				 \"a_name\": \"Community Chest\",\r\n"
				+ "				 \"b_type\": \"communit-chest\",\r\n" + "				 \"c_x\": \"0\",\r\n"
				+ "				 \"d_y\": \"0\"\r\n" + "				 },\r\n" + "				 {\r\n"
				+ "				 \"a_name\": \"Baltic Avenue\",\r\n" + "				 \"b_type\": \"property\",\r\n"
				+ "				 \"c_x\": \"0\",\r\n" + "				 \"d_y\": \"0\",\r\n"
				+ "				 \"e_cost\": \"60\",\r\n" + "				 \"f_rent\": \"[4,20,60,180,320,450]\",\r\n"
				+ "				 \"g_house\": \"50\"\r\n" + "				 },\r\n" + "				 {\r\n"
				+ "				 \"a_name\": \"Income Tax\",\r\n" + "				 \"b_type\": \"tax\",\r\n"
				+ "				 \"c_x\": \"0\",\r\n" + "				 \"d_y\": \"0\",\r\n"
				+ "				 \"e_cost\": \"200\"\r\n" + "				 },\r\n" + "				 {\r\n"
				+ "				 \"a_name\": \"Reading Railroad\",\r\n" + "				 \"b_type\": \"railroad\",\r\n"
				+ "				 \"c_x\": \"0\",\r\n" + "				 \"d_y\": \"0\",\r\n"
				+ "				 \"e_cost\": \"200\"\r\n" + "				 }\r\n" + "				 \r\n"
				+ "				 \r\n" + "		]\r\n" + "\r\n" + "	}\r\n" + "\r\n" + "} ";
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
			System.out.println(tmap);
			System.out.println(tmap.get("b_type"));

			if (tmap.get("b_type").equals("go")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));

				System.out.println("name is " + name);
				System.out.println("x is  " + x);
				System.out.println("y is " + y);

				Tile tile0 = new Tile(name, x, y);
				TileList.add(tile0);

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

				System.out.println("name is " + name);
				System.out.println("x is  " + x);
				System.out.println("y is " + y);
				System.out.println("cost is " + cost);
				System.out.println("house is  " + house);
				System.out.println("rent is "+rentList);

				Tile tile1 = new Tile(name, x, y);
				tile1.setValue("Cost", cost);
				tile1.setValue("house", house);
				TileList.add(tile1);

			}

			else if (tmap.get("b_type").equals("communit-chest")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));

				System.out.println("name is " + name);
				System.out.println("x is  " + x);
				System.out.println("y is " + y);

				Tile tile2 = new Tile(name, x, y);
				TileList.add(tile2);

			}

			else if (tmap.get("b_type").equals("tax")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));

				System.out.println("name is " + name);
				System.out.println("x is  " + x);
				System.out.println("y is " + y);

				Tile tile3 = new Tile(name, x, y);
		
				TileList.add(tile3);

			}

			else if (tmap.get("b_type").equals("railroad")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));

				System.out.println("name is " + name);
				System.out.println("x is  " + x);
				System.out.println("y is " + y);

				Tile tile4 = new Tile(name, x, y);
				// tile0.setValue("Cost", cost);
				TileList.add(tile4);

			}

			else if (tmap.get("b_type").equals("chance")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));

				System.out.println("name is " + name);
				System.out.println("x is  " + x);
				System.out.println("y is " + y);

				Tile tile5 = new Tile(name, x, y);
				TileList.add(tile5);

			}

			else if (tmap.get("b_type").equals("go-to-jail")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));

				System.out.println("name is " + name);
				System.out.println("x is  " + x);
				System.out.println("y is " + y);

				Tile tile6 = new Tile(name, x, y);
				TileList.add(tile6);

			}

			else if (tmap.get("b_type").equals("utility")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));
				int cost = Integer.parseInt((String) tmap.get("e_cost"));

				System.out.println("name is " + name);
				System.out.println("x is  " + x);
				System.out.println("y is " + y);

				Tile tile7 = new Tile(name, x, y);
				// tile0.setValue("Cost", cost);
				TileList.add(tile7);

			}

			else if (tmap.get("b_type").equals("free-parking")) {

				String name = (String) tmap.get("a_name");
				int x = Integer.parseInt((String) tmap.get("c_x"));
				int y = Integer.parseInt((String) tmap.get("c_x"));

				System.out.println("name is " + name);
				System.out.println("x is  " + x);
				System.out.println("y is " + y);

				Tile tile8 = new Tile(name, x, y);
				TileList.add(tile8);

			}	

		}

		System.out.println(TileList.size() + "------------------------------");
	}
}