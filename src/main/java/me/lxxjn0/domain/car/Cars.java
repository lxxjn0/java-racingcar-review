package me.lxxjn0.domain.car;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import me.lxxjn0.domain.numbergenerator.NumberGenerator;
import me.lxxjn0.domain.report.Report;

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

    public List<Report> generateReports() {
        return cars.stream()
                .map(Car::generateReport)
                .collect(toList());
    }

    public List<String> findWinners() {
        Position winningPosition = findWinningPosition();

        return cars.stream()
                .filter(car -> winningPosition.equals(car.getPosition()))
                .map(Car::getName)
                .map(Name::getName)
                .collect(toList());
    }

    private Position findWinningPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(() -> new NoSuchElementException("최대 위치가 존재하지 않습니다."));
    }
}
