package me.lxxjn0.controller;

import static java.util.stream.Collectors.*;
import static me.lxxjn0.view.ConsoleInput.*;
import static me.lxxjn0.view.ConsoleOutput.*;

import java.util.List;

import me.lxxjn0.domain.attemptnumber.AttemptNumber;
import me.lxxjn0.domain.car.Cars;
import me.lxxjn0.domain.factory.CarsFactory;
import me.lxxjn0.domain.numbergenerator.NumberGenerator;
import me.lxxjn0.domain.numbergenerator.RandomNumberGenerator;
import me.lxxjn0.domain.report.Report;

public class GameController {

    public void run() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Cars cars = CarsFactory.create(receiveCarNames());
        AttemptNumber attemptNumber = AttemptNumber.of(receiveAttemptNumber());

        while (attemptNumber.canAttempt()) {
            attemptNumber.attempt();
            play(cars, numberGenerator);
        }
        printWinners(cars.findWinnerNames());
    }

    public void play(final Cars cars, final NumberGenerator numberGenerator) {
        cars.move(numberGenerator);

        List<String> reports = cars.generateReports()
                .stream()
                .map(Report::getReport)
                .collect(toList());
        printReport(reports);
    }
}
