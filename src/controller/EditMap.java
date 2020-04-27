package controller;

import model.Tile;
import model.BoardModel;

import java.util.ArrayList;

import controller.MapJsonParser;

/**
 * This class implements edit map functionality. It has methods to edit cost house price and different rent prices. End users are not given permission to edit coordinates and names
 */

public class EditMap {

    /**
     * @param boardmodel is an object of boardmodel class
     * @param map is an object of parser class
     * @param al stores list of tiles locally.
     */
    BoardModel boardModel;
    MapJsonParser map;
    ArrayList<Tile> al = new ArrayList<Tile>();

    public EditMap(ArrayList<Tile> al) {
    	this.al = al;
    }
    
    public ArrayList<Tile> getTileList() {
        return al;
    }

    /**
     * This method is used for displaying list of editable  tiles on main screen
     */
    public void EditValues() {
        ArrayList<String> AvenuePlots = new ArrayList<String>();
        ArrayList<String> otherEditablePlots = new ArrayList<>();

        for (Tile tile : getTileList()) {
            String type = tile.getType();
            if (type.equalsIgnoreCase("Property")) {
                AvenuePlots.add(tile.getTileName());
            }
        }

        for (Tile tile : getTileList()) {
            String type = tile.getType();
            if (type.equalsIgnoreCase("tax") || type.equalsIgnoreCase("railroad") || type.equalsIgnoreCase("utility")) {
                otherEditablePlots.add(tile.getTileName());
            }
        }
    }


    /**
     * This method is used to edit cost of avenue plots
     *
     * @param name is the name of tile to be edited
     * @param cost is editable amount instead of cost
     * @return boolean value
     */
    public boolean EditAvenueCost(String name, int cost) {
        for (Tile t : getTileList()) {
            if (t.getTileName().equalsIgnoreCase(name)) {
                t.setValue("cost", cost);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to edit house price of avenue plots
     *
     * @param name  is the name of tile to be edited
     * @param house is editable amount instead of house price
     * @return boolean value
     */
    public boolean EditAvenuehouse(String name, int house) {
        for (Tile t : getTileList()) {
            if (t.getTileName().equalsIgnoreCase(name)) {
                t.setValue("house", house);
                return true;
            }
        }
        return false;

    }

    /**
     * This method is used to edit 1st rent price of avenue plots
     *
     * @param name  is the name of tile to be edited
     * @param rent1 is editable amount instead of 1st rent
     * @return boolean value
     */
    public boolean EditAvenueRent1(String name, int rent1) {
        for (Tile t : getTileList()) {
            if (t.getTileName().equalsIgnoreCase(name)) {
                t.setValue("rent1", rent1);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to edit 2nd rent price of avenue plots
     *
     * @param name  is the name of tile to be edited
     * @param rent2 is editable amount instead of 2nd rent
     * @return boolean value
     */
    public boolean EditAvenueRent2(String name, int rent2) {
        for (Tile t : getTileList()) {
            if (t.getTileName().equalsIgnoreCase(name)) {
                t.setValue("rent2", rent2);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to edit 3rd rent price of avenue plots
     *
     * @param name  is the name of tile to be edited
     * @param rent3 is editable amount instead of 3rd rent
     * @return boolean value
     */
    public boolean EditAvenueRent3(String name, int rent3) {
        for (Tile t : getTileList()) {
            if (t.getTileName().equalsIgnoreCase(name)) {
                t.setValue("rent3", rent3);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to edit 4th rent price of avenue plots
     *
     * @param name  is the name of tile to be edited
     * @param rent4 is editable amount instead of 4th rent
     * @return boolean value
     */
    public boolean EditAvenueRent4(String name, int rent4) {
        for (Tile t : getTileList()) {
            if (t.getTileName().equalsIgnoreCase(name)) {
                t.setValue("rent4", rent4);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to edit 5th rent price of avenue plots
     *
     * @param name  is the name of tile to be edited
     * @param rent5 is editable amount instead of 5th rent
     * @return boolean value
     */
    public boolean EditAvenueRent5(String name, int rent5) {
        for (Tile t : getTileList()) {
            if (t.getTileName().equalsIgnoreCase(name)) {
                t.setValue("rent5", rent5);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to edit 6th rent price of avenue plots
     *
     * @param name  is the name of tile to be edited
     * @param rent6 is editable amount instead of 6th rent
     * @return boolean value
     */
    public boolean EditAvenueRent6(String name, int rent6) {
        for (Tile t : getTileList()) {
            if (t.getTileName().equalsIgnoreCase(name)) {
                t.setValue("rent6", rent6);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to edit cost of other editable plots than Avenue plots such as railroad, electricity, income-tax cost
     *
     * @param name is the name of tile to be edited
     * @param cost is editable amount instead of assigned cost
     * @return boolean value
     */
    public boolean EditOtherPlotCost(String name, int cost) {
        for (Tile t : getTileList()) {
            if (t.getTileName().equalsIgnoreCase(name)) {
                t.setValue("cost", cost);
                return true;
            }
        }
        return false;
    }
}	
