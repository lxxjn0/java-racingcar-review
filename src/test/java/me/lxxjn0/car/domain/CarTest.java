package me.lxxjn0.car.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("Car() - 자동차의 이름을 입력받아 객체 생성")
    @Test
    void Car_Name_GenerateInstance() {
        final Name name = new Name("test");

        assertThat(new Car(name)).isInstanceOf(Car.class);
    }

    @DisplayName("Car() - 자동차의 이름과 위치를 입력받아 객체 생성")
    @Test
    void Car_NameAndPosition_GenerateInstance() {
        final Name name = new Name("test");
        final Position position = new Position();

        assertThat(new Car(name, position)).isInstanceOf(Car.class);
    }

    @DisplayName("move() - 입력받는 값이 4보다 작을 경우 정지")
    @Test
    void move_NumberUnderFour_StopPosition() {
        final Name name = new Name("test");
        final Position position = new Position(1);
        final Car car = new Car(name, position);

        car.move(3);

        assertThat(car).extracting("position")
                .extracting("position")
                .isEqualTo(1);
    }

    @DisplayName("move() - 입력받는 값이 4보다 작을 경우 정지")
    @Test
    void move_NumberOverThanFour_MovePosition() {
        final Name name = new Name("test");
        final Position position = new Position(1);
        final Car car = new Car(name, position);

        car.move(4);

        assertThat(car).extracting("position")
                .extracting("position")
                .isEqualTo(2);
    }

}
