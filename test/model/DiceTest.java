package model;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void diceroll() {
        int numberOfDice = 3;
        int[] results = Dice.diceroll(numberOfDice);
        Assert.assertEquals(results.length, numberOfDice);
        for (int result : results) {
            Assert.assertTrue(result > 0 && result <= 6);
        }
    }
}