package model;

import org.junit.Assert;

import java.util.ArrayList;

public class PlayerTurnModuleTest {
    Score score = new Score();

    @org.junit.Test
    public void updateTurn() {
        Unit[] units = new Unit[2];
        units[0] = new Unit("money",100);
        units[1] = new Unit("hotel",100);
    	ArrayList<Tile> t = new ArrayList<Tile>();
        Player player1 = new Player("player1", units, score, t);
        Player player2 = new Player("player2", units, score, t);
        Player player3 = new Player("player3", units, score, t);
        Player player4 = new Player("player4", units, score, t);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        PlayerTurnModule<Player> turn = new PlayerTurnModule<>(players);

        Assert.assertNull(turn.update(player1));
        Assert.assertNull(turn.update(player2));
        Assert.assertNull(turn.update(player3));
        Assert.assertNull(turn.update(player4));
    }

    @org.junit.Test
    public void nextTurn() {
        Unit[] units = new Unit[2];
        units[0] = new Unit("money",100);
        units[1] = new Unit("hotel",100);
        ArrayList<Tile> t = new ArrayList<Tile>();
        Player player1 = new Player("player1", units, score, t);
        Player player2 = new Player("player2", units, score, t);
        Player player3 = new Player("player3", units, score, t);
        Player player4 = new Player("player4", units, score, t);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        PlayerTurnModule<Player> turn = new PlayerTurnModule<>(players);
        Assert.assertEquals(turn.next(), player2);
        Assert.assertEquals(turn.next(), player3);
        Assert.assertEquals(turn.next(), player4);
        Assert.assertEquals(turn.next(), player1);
    }

}