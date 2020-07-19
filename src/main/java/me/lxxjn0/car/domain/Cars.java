package me.lxxjn0.car.domain;

import java.util.List;
import java.util.Objects;

import me.lxxjn0.numbergenerator.domain.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(final List<Car> cars) {
        Objects.requireNonNull(cars, "자동차 리스트가 null입니다.");

        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 존재하지 않습니다.");
        }
    }

    public void move(final NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }
}
