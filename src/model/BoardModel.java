package model;

import java.util.*;

public class BoardModel {

	private int height, width;
	private ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();

	public BoardModel() {
		populateBoard();
	}

	private void populateBoard() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter height and width of intended Board");
		this.height = s.nextInt();
		this.width = s.nextInt();
		System.out.println("Do you want custom names for Tiles? \n (Enter Y/N)");
		if(s.next().equals("Y")) {
			for(int i=0; i<width; i++) {
				ArrayList<Tile> temp = new ArrayList<Tile>();
				tiles.add(temp);
				for(int j=0; j<height; j++) {
					System.out.println("Enter name of tile at (" + i+1 + ", " + j+1 + ")");
					String str = s.next();
					tiles.get(i).add(new Tile(str, i, j));					
				}
			}
		} else {
			for(int i=0; i<width; i++) {
				ArrayList<Tile> temp = new ArrayList<Tile>();
				tiles.add(temp);
				for(int j=0; j<height; j++) {
					String str = "coordinate "+String.valueOf(i)+" "+ String.valueOf(j);
					tiles.get(i).add(new Tile(str, i, j));
				}
			}
		}

		setConnections();
		
	}
		
	private void setConnections() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				if( i - 1 >= 0 ) {
					tiles.get(i).get(j).addNeigbour(tiles.get(i-1).get(j));
				}
				
				if( i + 1 < width  ) {
					tiles.get(i).get(j).addNeigbour(tiles.get(i+1).get(j));
				}
				
				if( j + 1 < height  ) {
					tiles.get(i).get(j).addNeigbour(tiles.get(i).get(j+1));
				}

				if( j - 1 >= 0 ) {
					tiles.get(i).get(j).addNeigbour(tiles.get(i).get(j-1));
				}
			}
		}

		
//		Scanner s = new Scanner(System.in);
//		System.out.println("Use default connections? \n Enter (Y/N)");
//		if(s.next().equals("Y")) {
//		} else {
//			
//		}
		
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				System.out.print(tiles.get(i).get(j).getTileName() + "    ");
			}
			System.out.println();
		}


		for(String i : getTile("3 2").getNeighbours()) {
			System.out.println("neighbour is " + i);
		}
		
	}

	public Tile getTile(String coordinates) {
		String[] coo = coordinates.split(" ");
		return tiles.get( Integer.parseInt(coo[0])).get(Integer.parseInt(coo[1]));
	}
	
}
