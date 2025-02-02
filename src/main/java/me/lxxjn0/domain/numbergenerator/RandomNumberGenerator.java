package me.lxxjn0.domain.numbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int EXCLUSIVE_UPPER_BOUND = 10;

    @Override
    public int generate() {
        return new Random().nextInt(EXCLUSIVE_UPPER_BOUND);
    }
}
