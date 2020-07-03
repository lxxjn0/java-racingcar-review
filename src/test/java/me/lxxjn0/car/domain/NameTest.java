package me.lxxjn0.car.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

	@DisplayName("Name() - 자동차 이름을 입력받아 객체 생성")
	@Test
	void Name_NameOfCar_GenerateInstance() {
		assertThat(new Name("hello")).isInstanceOf(Name.class);
	}

	@DisplayName("validate() - 자동차 이름으로 null이 입력될 경우 예외 발생")
	@ParameterizedTest
	@NullSource
	void validate_NameIsNull_ExceptionThrown(final String name) {
		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(NullPointerException.class)
			.hasMessage("자동차 이름이 null입니다.");
	}

	@DisplayName("validate() - 유효하지 않은 이름을 입력받을 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"", "abcdef"})
	void validate_InvalidNameLength_ExceptionThrown(final String name) {
		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("자동차 이름이 유효하지 않습니다.");
	}

}
