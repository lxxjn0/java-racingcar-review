package me.lxxjn0.numbergenerator.domain;

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
