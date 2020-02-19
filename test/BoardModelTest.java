import model.BoardModel;
import model.Tile;
import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardModelTest {
    int height = 10;
    int width = 10;

    @org.junit.Test
    public void populateBoard() {
        BoardModel bm = new BoardModel(height, width);
        bm.populateBoard("Y");
        ArrayList<ArrayList<Tile>> tiles = bm.getTiles();
        for (int i = 0; i < width; i++) {
            Assert.assertNotNull(tiles.get(i));
            ArrayList<Tile> temp = tiles.get(i);
            for (int j = 0; j < height; j++) {
                Tile tile = temp.get(j);
                Assert.assertNotNull(tile);
                Assert.assertEquals(tile.getTileName(), "coordinate " + i + " " + j);
                Assert.assertEquals(tile.getTileCoordinates(), i + " " + j);
            }
        }
    }


    @org.junit.Test
    public void tileConnectCoordinate() {
        BoardModel bm = new BoardModel(height, width);
        bm.populateBoard("Y");
        boolean result = bm.tileConnectCoordinate(0, 0, 1, 0);
        Assert.assertTrue(result);
        result = bm.tileConnectCoordinate(width, 0, 0, 0);
        Assert.assertFalse(result);
        result = bm.tileConnectCoordinate(0, width, 0, 0);
        Assert.assertFalse(result);
        result = bm.tileConnectCoordinate(0, 0, height, 0);
        Assert.assertFalse(result);
        result = bm.tileConnectCoordinate(0, 0, 0, height);
        Assert.assertFalse(result);
        result = bm.tileConnectCoordinate(-1, 0, 0, 0);
        Assert.assertFalse(result);
        result = bm.tileConnectCoordinate(0, -1, 0, 0);
        Assert.assertFalse(result);
        result = bm.tileConnectCoordinate(0, 0, -1, 0);
        Assert.assertFalse(result);
        result = bm.tileConnectCoordinate(0, 0, 0, -1);
        Assert.assertFalse(result);
    }

    @org.junit.Test
    public void getTile() {
        BoardModel bm = new BoardModel(height, width);
        bm.populateBoard("Y");
        Assert.assertNotNull(bm.getTile("0 0"));
        Assert.assertNull(bm.getTile(-1 + " " + -1));
        Assert.assertNull(bm.getTile(height + " " + -1));
        Assert.assertNull(bm.getTile(-1 + " " + width));
        Assert.assertNull(bm.getTile(height + " " + width));
    }
}