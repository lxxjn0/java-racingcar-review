package me.lxxjn0.domain.factory;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Objects;

import me.lxxjn0.domain.car.Car;
import me.lxxjn0.domain.car.Cars;
import me.lxxjn0.domain.car.Name;

public class CarsFactory {

    private static final String DELIMITER = ",";

    public static Cars create(final String inputCarNames) {
        Objects.requireNonNull(inputCarNames, "자동차 이름이 null입니다.");

        return Arrays.stream(inputCarNames.split(DELIMITER))
                .map(String::trim)
                .map(Name::new)
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }
}
