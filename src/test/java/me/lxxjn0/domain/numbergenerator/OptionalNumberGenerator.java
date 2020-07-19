package me.lxxjn0.domain.numbergenerator;

public class OptionalNumberGenerator implements NumberGenerator {

    private final int generatingNumber;

    public OptionalNumberGenerator(final int generatingNumber) {
        this.generatingNumber = generatingNumber;
    }

    @Override
    public int generate() {
        return generatingNumber;
    }
}
