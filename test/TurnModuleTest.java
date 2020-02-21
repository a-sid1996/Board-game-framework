import java.util.ArrayList;
import model.Player;
import model.PlayerTurnModule;
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
		
		Player player1 = new Player("player1", units);
		Player player2 = new Player("player2", units);
		Player player3 = new Player("player3", units);
		Player player4 = new Player("player4", units);
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		PlayerTurnModule<Player> turn = new PlayerTurnModule<Player>(players);
		
		Assert.assertEquals(turn.update(player1), player1);

	}
	
}
