package me.lxxjn0.car.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class CarsTest {
    @DisplayName("Cars() - Car 리스트를 입력받아 객체 생성")
    @Test
    void cars() {
        // given
        List<Car> cars = Arrays.asList(
                new Car(new Name("test1")),
                new Car(new Name("test2")),
                new Car(new Name("test3")));
        // then
        assertThat(new Cars(cars)).isInstanceOf(Cars.class);
    }

    @DisplayName("validate() - Car 리스트가 null일 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    void validate_null(List<Car> cars) {
        // then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("자동차 리스트가 null입니다.");
    }

    @DisplayName("validate() - Car 리스트가 empty일 경우 예외 발생")
    @ParameterizedTest
    @EmptySource
    void validate_empty(List<Car> cars) {
        // then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차가 존재하지 않습니다.");
    }
}
