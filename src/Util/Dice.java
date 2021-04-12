package Util;

import java.util.Random;

public class Dice {

    public static int rollDice(){
        int diceNumber;
        Random random = new Random();
        diceNumber = random.nextInt(6) + 1;
        return diceNumber;
    }

}
