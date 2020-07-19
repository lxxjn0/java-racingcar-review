package me.lxxjn0.car.domain;

import java.util.Objects;

public class Car {

    private static final int MOVING_INCREMENT_UNIT = 1;
    private static final int MOVING_LOWER_BOUND = 4;

    private final Name name;
    private final Position position;

    public Car(final Name name, final Position position) {
        Objects.requireNonNull(name, "자동차 이름이 null입니다.");
        Objects.requireNonNull(position, "자동차 위치가 null입니다.");
        this.name = name;
        this.position = position;
    }

    public Car(final Name name) {
        this(name, new Position());
    }

    public void move(final int number) {
        if (number >= MOVING_LOWER_BOUND) {
            this.position.move(MOVING_INCREMENT_UNIT);
        }
    }

}
