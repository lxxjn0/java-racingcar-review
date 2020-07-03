package me.lxxjn0.car.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

	@DisplayName("Position() - 자동차 위치를 입력받지 않을 경우 위치가 0인 객체 생성")
	@Test
	void Position_Nothing_GenerateInstance() {
		assertThat(new Position()).isInstanceOf(Position.class)
		                          .extracting("position")
		                          .isEqualTo(0);
	}

	@DisplayName("Position() - 자동차 위치를 입력받아 객체 생성")
	@Test
	void Position_PositionValue_GenerateInstance() {
		assertThat(new Position(1)).isInstanceOf(Position.class);
	}

	@DisplayName("validate() - 유효하지 않은 자동차 위치를 입력받을 경우 예외 발생")
	@Test
	void validate_NegativeValue_ExceptionThrown() {
		assertThatThrownBy(() -> new Position(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("위치 값이 유효하지 않습니다.");
	}

	@DisplayName("move() - 입력받은 값만큼 위치 이동")
	@Test
	void move_NumberOfMovingUnit_MovePosition() {
		final Position position = new Position(0);
		position.move(2);

		assertThat(position).extracting("position")
		                    .isEqualTo(2);
	}

}
