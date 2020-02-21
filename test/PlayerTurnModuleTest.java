import model.Player;
import model.PlayerTurnModule;
import model.Unit;
import org.junit.Assert;

import java.util.ArrayList;

public class PlayerTurnModuleTest {

    @org.junit.Test
    public void updateTurn() {
        Unit[] units = new Unit[2];
        units[0] = new Unit("money");
        units[1] = new Unit("hotel");
        Player player1 = new Player("player1", units);
        Player player2 = new Player("player2", units);
        Player player3 = new Player("player3", units);
        Player player4 = new Player("player4", units);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        PlayerTurnModule<Player> turn = new PlayerTurnModule<>(players);

        Assert.assertEquals(turn.update(player1), player1);
        Assert.assertEquals(turn.update(player2), player2);
        Assert.assertEquals(turn.update(player3), player3);
        Assert.assertEquals(turn.update(player4), player4);
    }

    @org.junit.Test
    public void nextTurn() {
        Unit[] units = new Unit[2];
        units[0] = new Unit("money");
        units[1] = new Unit("hotel");

        Player player1 = new Player("player1", units);
        Player player2 = new Player("player2", units);
        Player player3 = new Player("player3", units);
        Player player4 = new Player("player4", units);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        PlayerTurnModule<Player> turn = new PlayerTurnModule<>(players);
        Assert.assertEquals(turn.next(), player1);
        Assert.assertEquals(turn.next(), player2);
        Assert.assertEquals(turn.next(), player3);
        Assert.assertEquals(turn.next(), player4);

    }

}