package model;

import java.util.*;

public class BoardModel {

	private ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();

	public BoardModel() {
		populateBoard();
	}

	private void populateBoard() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter height and width of intended Board");
		int height = s.nextInt() , width = s.nextInt();
		System.out.println("Do you want custom names for Tiles? \n (Enter Y/N)");
		if(s.next().equals("Y")) {
			for(int i=0; i<width; i++) {
				ArrayList<Tile> temp = new ArrayList<Tile>();
				tiles.add(temp);
				for(int j=0; j<height; j++) {
					String str = s.nextLine();
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
	}
	
	public Tile getTile(String coordinates) {
		String[] coo = coordinates.split(" ");
		return tiles.get( Integer.parseInt(coo[0])-1).get(Integer.parseInt(coo[1])-1);
	}
	
	
}
