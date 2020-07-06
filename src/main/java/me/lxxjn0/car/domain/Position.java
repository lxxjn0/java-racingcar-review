package me.lxxjn0.car.domain;

public class Position {

    private static final int POSITION_INIT_VALUE = 0;

    private int position;

    public Position(final int position) {
        validate(position);
        this.position = position;
    }

    public Position() {
        this.position = POSITION_INIT_VALUE;
    }

    private void validate(final int position) {
        if (position < POSITION_INIT_VALUE) {
            throw new IllegalArgumentException("위치 값이 유효하지 않습니다.");
        }
    }

    public void move(final int unit) {
        this.position += unit;
    }

}
