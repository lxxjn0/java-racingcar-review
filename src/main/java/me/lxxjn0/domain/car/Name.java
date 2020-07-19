package me.lxxjn0.domain.car;

import java.util.Objects;

public class Name {

    private static final int NAME_LENGTH_LOWER_BOUND = 1;
    private static final int NAME_LENGTH_UPPER_BOUND = 5;

    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        Objects.requireNonNull(name, "자동차 이름이 null입니다.");

        if (name.length() < NAME_LENGTH_LOWER_BOUND || name.length() > NAME_LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException("자동차 이름이 유효하지 않습니다.");
        }
    }
}
