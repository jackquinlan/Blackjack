package util;

import java.util.Random;

public class Helper {
    private static Random rand = null;

    private static Random getRandom() {
        if (rand == null)
            rand = new Random();
        return rand;
    }

    /*
    * Generates a random integer
    * @param int max is the upper bound of the random number
    * @return an integer 0 <= value < max
    */
    public static int nextInt(int max) {
        return getRandom().nextInt(max);
    }
}