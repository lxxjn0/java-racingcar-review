package me.lxxjn0.domain.attemptnumber;

import java.util.Objects;

public class AttemptNumber {

    private static final int ATTEMPT_NUMBER_LOWER_BOUND = 1;

    private final int attemptNumber;

    private AttemptNumber(final int attemptNumber) {
        validate(attemptNumber);
        this.attemptNumber = attemptNumber;
    }

    public static AttemptNumber of(final String inputAttemptNumber) {
        Objects.requireNonNull(inputAttemptNumber, "시도 횟수가 null입니다.");

        int parsedAttemptNumber = Integer.parseInt(inputAttemptNumber);
        return new AttemptNumber(parsedAttemptNumber);
    }

    private void validate(final int attemptNumber) {
        if (attemptNumber < ATTEMPT_NUMBER_LOWER_BOUND) {
            throw new IllegalArgumentException("시도 횟수가 " + ATTEMPT_NUMBER_LOWER_BOUND + "보다 작습니다.");
        }
    }
}
