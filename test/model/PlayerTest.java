package model;

import org.junit.Assert;

import java.util.ArrayList;

public class PlayerTest {

	Score score = new Score();
    @org.junit.Test
    public void addMoney() {
        ArrayList<Tile> t = new ArrayList<Tile>();
        Unit[] units = new Unit[]{new Unit("money",100)};
        Player player = new Player("John", units, score, t);
        Assert.assertTrue(player.addMoney(100));
        Assert.assertFalse(player.addMoney(-1));
    }

    @org.junit.Test
    public void deductMoney() {
        ArrayList<Tile> t = new ArrayList<Tile>();
        Unit[] units = new Unit[]{new Unit("money",100)};
        Player player = new Player("John", units, score, t);
        Assert.assertFalse(player.deductMoney(-1));
        Assert.assertFalse(player.deductMoney(101));
        player.addMoney(100);
        Assert.assertTrue(player.deductMoney(100));
        Assert.assertFalse(player.deductMoney(1000));
    }
}