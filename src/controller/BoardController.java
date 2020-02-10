package controller;

import model.BoardModel;
import view.BoardView;

public class BoardController {

	public BoardModel board = new BoardModel();
//	public BoardView view = new BoardView();
	
	public BoardController() {
		System.out.println(board.getTile("1 2").getTileName());
	}	
}
