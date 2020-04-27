package controller;

import model.Player;
import model.Tile;

public interface Strategy {
	public void setOfferType(Tile t , Player p , String s);
}
