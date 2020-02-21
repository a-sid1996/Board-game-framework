import java.util.ArrayList;
import model.Player;
import model.PlayerTurnModule;
import model.Score;
import model.Unit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({})
public class TurnModuleTest {

	@org.junit.Test
	public void update() {
		
		Unit[] units = new Unit[2];
		units[0] = new Unit("money");
		units[1] = new Unit("hotel");
		Score score = new Score();
		
		Player player1 = new Player("player1", units, score);
		Player player2 = new Player("player2", units, score);
		Player player3 = new Player("player3", units, score);
		Player player4 = new Player("player4", units, score);
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		PlayerTurnModule<Player> turn = new PlayerTurnModule<Player>(players);
		
		Assert.assertEquals(turn.update(player1), player1);

	}
	
}
