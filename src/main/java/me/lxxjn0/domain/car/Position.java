package me.lxxjn0.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int POSITION_INIT_VALUE = 0;

    private int position;

    public Position(final int position) {
        validate(position);
        this.position = position;
    }

    public Position() {
        this(POSITION_INIT_VALUE);
    }

    private void validate(final int position) {
        if (position < POSITION_INIT_VALUE) {
            throw new IllegalArgumentException("위치 값이 유효하지 않습니다.");
        }
    }

    public void move(final int unit) {
        this.position += unit;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position that) {
        return this.position - that.position;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        Position position = (Position)that;
        return this.getPosition() == position.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
