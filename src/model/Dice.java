package model;

import java.io.Serializable;
import java.math.*;
import java.util.Random;

/**
 * This is a model class for score module that stores different score parameters
 * of different players
 */
public class Dice implements Serializable {
    private int noOfDice;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    /**
     * @return Method returns random numbers between 1 and appropriate number as per
     * noOfDice added
     */
    public int diceroll() {
        Random rand = new Random();
        int result = 0;
        for (int i = 0; i < noOfDice; i++) {
            result = result + rand.nextInt(6) + 1;
        }
        return result;
    }
}

