package model;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void diceroll() {
        int numberOfDice = 3;
        int results = Dice.diceroll(numberOfDice);
        Assert.assertEquals(results > 0 && result <= 18);
//        for (int result : results) {
//            Assert.assertTrue(results > 0 && result <= 18);
//        }
    }
}