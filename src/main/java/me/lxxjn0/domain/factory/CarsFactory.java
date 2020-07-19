package me.lxxjn0.domain.factory;

import static java.util.stream.Collectors.*;

import java.util.Arrays;

import me.lxxjn0.domain.car.Car;
import me.lxxjn0.domain.car.Cars;
import me.lxxjn0.domain.car.Name;

public class CarsFactory {

    private static final String DELIMITER = ",";

    public static Cars create(final String inputCarNames) {
        return Arrays.stream(inputCarNames.split(DELIMITER))
                .map(String::trim)
                .map(Name::new)
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }
}
