package test.controller;

import model.Player;
import model.PlayerTurnModule;
import model.Score;
import model.Unit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GameControllerTest {

	Score score = new Score();
    @Test
    public void fortification() {
        Player player1 = new Player("John", new Unit[]{new Unit(Unit.UnitType.MONEY.toString())}, score);
        Player player2 = new Player("John", new Unit[]{new Unit(Unit.UnitType.MONEY.toString())}, score);
        GameController gc = new GameController(null, null, new ArrayList<>(), null, new PlayerTurnModule<>(new ArrayList<>()), null);
        player1.addMoney(100);
        Assert.assertFalse(gc.fortification(player2, player1, 100));
        Assert.assertTrue(gc.fortification(player1, player2, 100));
    }
}