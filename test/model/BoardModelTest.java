import model.BoardModel;
import model.Tile;
import org.junit.Assert;

import java.util.ArrayList;

public class BoardModelTest {
    int height = 10;
    int width = 10;

    @org.junit.Test
    public void populateBoard() {
        BoardModel bm = new BoardModel(height, width);
        try {
            bm.populateBoard("N");
        } catch (Exception ex) {
            Assert.assertNull(ex);
        }
        ArrayList<ArrayList<Tile>> tiles = bm.getBoard();
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
        try {
            bm.populateBoard("N");
        } catch (Exception ex) {
            Assert.assertNull(ex);
        }
        boolean result = bm.connectTiles(0, 0, 1, 0);
        Assert.assertTrue(result);
        result = bm.connectTiles(width, 0, 0, 0);
        Assert.assertFalse(result);
        result = bm.connectTiles(0, width, 0, 0);
        Assert.assertFalse(result);
        result = bm.connectTiles(0, 0, height, 0);
        Assert.assertFalse(result);
        result = bm.connectTiles(0, 0, 0, height);
        Assert.assertFalse(result);
        result = bm.connectTiles(-1, 0, 0, 0);
        Assert.assertFalse(result);
        result = bm.connectTiles(0, -1, 0, 0);
        Assert.assertFalse(result);
        result = bm.connectTiles(0, 0, -1, 0);
        Assert.assertFalse(result);
        result = bm.connectTiles(0, 0, 0, -1);
        Assert.assertFalse(result);
    }

    @org.junit.Test
    public void getTile() {
        BoardModel bm = new BoardModel(height, width);
        try {
            bm.populateBoard("N");
        } catch (Exception ex) {
            Assert.assertNull(ex);
        }
        Assert.assertNotNull(bm.getTile("0 0"));
        Assert.assertNull(bm.getTile(-1 + " " + -1));
        Assert.assertNull(bm.getTile(height + " " + -1));
        Assert.assertNull(bm.getTile(-1 + " " + width));
        Assert.assertNull(bm.getTile(height + " " + width));
    }
}