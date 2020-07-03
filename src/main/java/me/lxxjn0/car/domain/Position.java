package me.lxxjn0.car.domain;

public class Position {

	private int position;

	public Position(final int position) {
		validate(position);
		this.position = position;
	}

	private void validate(final int position) {
		if (position < 0) {
			throw new IllegalArgumentException("위치 값이 유효하지 않습니다.");
		}
	}

}
