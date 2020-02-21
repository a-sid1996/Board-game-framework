import model.Player;
import model.Unit;
import org.junit.Assert;

public class PlayerTest {

    @org.junit.Test
    public void addMoney() {
        Unit[] units = new Unit[]{new Unit(Unit.UnitType.MONEY.toString())};
        Player player = new Player("John", units);
        Assert.assertTrue(player.addMoney(100));
        Assert.assertFalse(player.addMoney(-1));
    }

    @org.junit.Test
    public void deductMoney() {
        Unit[] units = new Unit[]{new Unit(Unit.UnitType.MONEY.toString())};
        Player player = new Player("John", units);
        Assert.assertFalse(player.deductMoney(-1));
        Assert.assertFalse(player.deductMoney(100));
        player.addMoney(100);
        Assert.assertTrue(player.deductMoney(100));
        Assert.assertFalse(player.deductMoney(1));
    }
}