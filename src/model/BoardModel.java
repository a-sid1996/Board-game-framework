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
     * @param board  is a collection of board represented as
     */
    private BufferedReader BoardModel_br = new BufferedReader(new InputStreamReader(System.in));
    private int height, width;
    private ArrayList<ArrayList<Tile>> board = new ArrayList<>();

    public BoardModel(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /**
     * @return is a metric of total board in a board
     */
    public ArrayList<ArrayList<Tile>> getBoard() {
        return board;
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
            board.add(temp);
        }
    }


    /**
     * @param coordinates stored x and y coordinates passed as a string
     * @return is a tile located at the coordinates passed
     */
    public Tile getTile(String coordinates) {
        String[] coo = coordinates.split(" ");
        return getTile(Integer.parseInt(coo[1]), Integer.parseInt(coo[0]));
    }

    public Tile getTile(int row, int column) {
        if (row >= 0 && row < board.size()) {
            ArrayList<Tile> boardRow = getBoard().get(row);
            if (column >= 0 && column < boardRow.size()) {
                return boardRow.get(column);
            }
        }
        return null;
    }

    public void setConnections() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                connectTiles(i, j, i - 1, j);
                connectTiles(i, j, i + 1, j);
                connectTiles(i, j, i, j - 1);
                connectTiles(i, j, i, j + 1);
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
//				System.out.print(board.get(i).get(j).getTileName() + "    ");
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
     * @param xSource is the x coordinate of the first tile
     * @param ySource is the y coordinate of the first tile
     * @param xDest   is the x coordinate of the second tile
     * @param yDest   is the y coordinate of the second tile
     * @return is true if both the board are connected or false if both the board
     * are not connected
     */
    public boolean connectTiles(int xSource, int ySource, int xDest, int yDest) {
        Tile t1 = getTile(ySource, xSource);
        Tile t2 = getTile(yDest, xDest);
        if (t1 != null && t2 != null) {
            t1.addNeigbour(t2);
            return true;
        }
        return false;
    }
}
