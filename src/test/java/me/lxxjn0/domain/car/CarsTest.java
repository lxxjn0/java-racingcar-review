package me.lxxjn0.domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import me.lxxjn0.domain.numbergenerator.OptionalNumberGenerator;
import me.lxxjn0.domain.report.Report;

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

    @DisplayName("move() - NumberGenerator의 전략에 따라 cars 이동")
    @Test
    void move() {
        // given
        OptionalNumberGenerator numberGenerator = new OptionalNumberGenerator(4);
        List<Car> generatedCars = Arrays.asList(
                new Car(new Name("test1")),
                new Car(new Name("test2")),
                new Car(new Name("test3")));
        Cars cars = new Cars(generatedCars);

        // when
        cars.move(numberGenerator);

        // then
        assertThat(cars).extracting("cars")
                .asList()
                .extracting("position")
                .extracting("position")
                .isEqualTo(Arrays.asList(1, 1, 1));
    }

    @DisplayName("generateReports() - 자동차들의 Report를 생성하여 반환")
    @Test
    void generateReports() {
        // given
        List<Car> generatedCars = Arrays.asList(
                new Car(new Name("test1")),
                new Car(new Name("test2")),
                new Car(new Name("test3")));
        Cars cars = new Cars(generatedCars);

        // then
        assertThat(cars.generateReports()).asList()
                .hasOnlyElementsOfType(Report.class);
    }

    @DisplayName("findWinners() - 승자의 이름들을 반환")
    @Test
    void findWinners() {
        // given
        List<Car> generatedCars = Arrays.asList(
                new Car(new Name("test1"), new Position(1)),
                new Car(new Name("test2"), new Position(4)),
                new Car(new Name("test3"), new Position(4)));
        Cars cars = new Cars(generatedCars);

        // then
        assertThat(cars.findWinners()).asList()
                .isEqualTo(Arrays.asList("test2", "test3"));
    }
}
