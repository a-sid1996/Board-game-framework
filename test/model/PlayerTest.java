package model;

import org.junit.Assert;

public class PlayerTest {

	Score score = new Score();
    @org.junit.Test
    public void addMoney() {
    	ArrayList<Tile> t = new ArrayList<Tile>();
        Unit[] units = new Unit[]{new Unit(Unit.UnitType.MONEY.toString())};
        Player player = new Player("John", units, score, t);
        Assert.assertTrue(player.addMoney(100));
        Assert.assertFalse(player.addMoney(-1));
    }

    @org.junit.Test
    public void deductMoney() {
        Unit[] units = new Unit[]{new Unit(Unit.UnitType.MONEY.toString())};
        ArrayList<Tile> t = new ArrayList<Tile>();
        Player player = new Player("John", units, score, t);
        Assert.assertFalse(player.deductMoney(-1));
        Assert.assertFalse(player.deductMoney(100));
        player.addMoney(100);
        Assert.assertTrue(player.deductMoney(100));
        Assert.assertFalse(player.deductMoney(1));
    }
}