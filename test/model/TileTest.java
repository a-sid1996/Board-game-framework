package model;

import org.junit.Assert;
import org.junit.Test;

public class TileTest {

    @Test
    public void addNeigbour() {
        Tile tile = new Tile("DemoTile", 0, 0, "property");
        tile.addNeigbour(new Tile("NeighbourTile", 1, 1, "property"));
    }

    @Test
    public void getNeighbours() {
        Tile tile = new Tile("DemoTile", 0, 0, "property");
        Tile neighbour = new Tile("NeighbourTile", 1, 1, "property");
        tile.addNeigbour(neighbour);
        Assert.assertEquals(tile.getNeighbours().size(), 1);
        Assert.assertEquals(tile.getNeighbours().get(0), neighbour);
    }

    @Test
    public void removeNeigbour() {
        Tile tile = new Tile("DemoTile", 0, 0, "property");
        Tile neighbour = new Tile("NeighbourTile", 1, 1, "property");
        tile.addNeigbour(neighbour);
        tile.removeNeigbour(neighbour);
        Assert.assertEquals(tile.getNeighbours().size(), 0);
    }
}