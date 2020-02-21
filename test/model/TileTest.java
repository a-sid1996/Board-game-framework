package model;

import org.junit.Assert;
import org.junit.Test;

public class TileTest {

    @Test
    public void addNeigbour() {
        Tile tile = new Tile("DemoTile", 0, 0);
        tile.addNeigbour(new Tile("NeighbourTile", 1, 1));
    }

    @Test
    public void getNeighbours() {
        Tile tile = new Tile("DemoTile", 0, 0);
        Tile neighbour = new Tile("NeighbourTile", 1, 1);
        tile.addNeigbour(neighbour);
        Assert.assertEquals(tile.getNeighbours().size(), 1);
        Assert.assertEquals(tile.getNeighbours().get(0), neighbour);
    }

    @Test
    public void removeNeigbour() {
        Tile tile = new Tile("DemoTile", 0, 0);
        Tile neighbour = new Tile("NeighbourTile", 1, 1);
        tile.addNeigbour(neighbour);
        tile.removeNeigbour(neighbour);
        Assert.assertEquals(tile.getNeighbours().size(), 0);
    }
}