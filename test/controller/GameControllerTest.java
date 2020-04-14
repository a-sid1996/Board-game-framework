package controller;

import model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GameControllerTest {

	Score score = new Score();
    @Test
    public void fortification() {
        ArrayList<Tile> t = new ArrayList<Tile>();
        Player player1 = new Player("John", new Unit[]{new Unit("money",100)}, score,t);
        Player player2 = new Player("John", new Unit[]{new Unit("money",100)}, score,t);
        GameController gc = new GameController(null, null, new ArrayList<>(), null, new PlayerTurnModule<>(new ArrayList<>()));
        player1.addMoney(100);
        Assert.assertFalse(gc.fortification(player2, player1, 100));
        Assert.assertTrue(gc.fortification(player1, player2, 100));
    }
}