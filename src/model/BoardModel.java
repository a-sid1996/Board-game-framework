package model;

import java.util.*;

public class BoardModel {

    private int height, width;
    private ArrayList<ArrayList<Tile>> tiles = new ArrayList<>();

    public BoardModel(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public ArrayList<ArrayList<Tile>> getTiles() {
        return tiles;
    }

    public void populateBoard(String ans) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        boolean needCustomNames = ans.equals("Y");
        for (int i = 0; i < width; i++) {
            ArrayList<Tile> temp = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                String str;
                if (needCustomNames) {
                    str = "coordinate " + i + " " + j;
                } else {
                    System.out.println("Enter name of tile at (" + (i + 1) + ", " + (j + 1) + ")");
                    str = s.next();
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

    public String tileConnectName(String nameSource, String nameDest) {
        return "Names entered are invaid.";
    }

    public boolean tileConnectCoordinate(int xSource, int ySource, int xDest, int yDest) {
        if (xSource < width && xDest < width && ySource < height && yDest < height) {
            Tile sourceTile = tiles.get(xSource).get(ySource);
            Tile destTile = tiles.get(xDest).get(yDest);
            sourceTile.addNeigbour(destTile);
            return true;
        }
        return false;
    }

    public Tile getTile(String coordinates) {
        String[] coo = coordinates.split(" ");
        return tiles.get(Integer.parseInt(coo[0])).get(Integer.parseInt(coo[1]));
    }

    public void setCustomConnections() {
        // TODO Auto-generated method stub
    }
}
