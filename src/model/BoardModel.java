package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Board class contains methods related to gaming board.
 */
public class BoardModel {
	/**
	 * @param height is the height of board
	 * @param width  is the width of board
	 * @param tiles  is a collection of tiles representated as
	 */
	BufferedReader BoardModel_br = new BufferedReader(new InputStreamReader(System.in));
	private int height, width;
	private ArrayList<ArrayList<Tile>> tiles = new ArrayList<>();

	public BoardModel(int height, int width) {
		this.height = height;
		this.width = width;
	}

	/**
	 * @return is a metric of total tiles in a board
	 */
	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}

	public void populateBoard(String ans) throws IOException {
		// TODO Auto-generated method stub
		boolean needCustomNames = ans.equals("Y");
		for (int i = 0; i < width; i++) {
			ArrayList<Tile> temp = new ArrayList<>();
			for (int j = 0; j < height; j++) {
				String str;
				if (needCustomNames) {
					System.out.println("Enter name of tile at (" + (i + 1) + ", " + (j + 1) + ")");
					str = BoardModel_br.readLine();
				} else {
					str = "coordinate " + i + " " + j;
				}
				temp.add(new Tile(str, i, j));
			}
			tiles.add(temp);
		}
	}

	public void setConnections() {
		// TODO Auto-generated method stub

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (i - 1 >= 0) {
					tiles.get(i).get(j).addNeigbour(tiles.get(i - 1).get(j));
				}

				if (i + 1 < width) {
					tiles.get(i).get(j).addNeigbour(tiles.get(i + 1).get(j));
				}

				if (j + 1 < height) {
					tiles.get(i).get(j).addNeigbour(tiles.get(i).get(j + 1));
				}

				if (j - 1 >= 0) {
					tiles.get(i).get(j).addNeigbour(tiles.get(i).get(j - 1));
				}
			}
		}

//		Scanner s = new Scanner(System.in);
//		System.out.println("Use default connections? \n Enter (Y/N)");
//		if(s.next().equals("Y")) {
//		} else {
//			
//		}

//		for(int i=0; i<width; i++) {
//			for(int j=0; j<height; j++) {
//				System.out.print(tiles.get(i).get(j).getTileName() + "    ");
//			}
//			System.out.println();
//		}
//
//
//		for(String i : getTile("3 2").getNeighbours()) {
//			System.out.println("neighbour is " + i);
//		}

	}

	/**
	 * @param xsource is the x coordinate of the first tile
	 * @param ysource is the y coordinate of the first tile
	 * @param xdest   is the x coordinate of the second tile
	 * @param ydest   is the y coordinate of the second tile
	 * @return is true if both the tiles are connected or false if both the tiles
	 *         are not connected
	 */
	public boolean tileConnectCoordinate(int xSource, int ySource, int xDest, int yDest) {
		if (xSource < width && xDest < width && xSource > -1 && ySource > -1 && xDest > -1 && yDest > -1
				&& (xDest < tiles.size() && xSource < tiles.size())
				&& (yDest < tiles.get(0).size() && ySource < tiles.get(0).size())) {
			if (ySource < height && yDest < height) {
				tiles.get(xSource).get(ySource).addNeigbour(tiles.get(xDest).get(yDest));
				return true;
			}
		}
		return false;
	}

	/**
	 * @param coordinates stored x and y coordinates passed as a string
	 * @return is a tile located at the coordinates passed
	 */
	public Tile getTile(String coordinates) {
		String[] coo = coordinates.split(" ");
		if (Integer.parseInt(coo[0]) > -1 && Integer.parseInt(coo[1]) > -1 && Integer.parseInt(coo[0]) < height
				&& Integer.parseInt(coo[1]) < width) {
			return tiles.get(Integer.parseInt(coo[0])).get(Integer.parseInt(coo[1]));
		}
		return null;
	}

	public void setCustomConnections() {
		// TODO Auto-generated method stub
	}
}
