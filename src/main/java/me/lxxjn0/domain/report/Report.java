package me.lxxjn0.domain.report;

import java.util.Objects;

import me.lxxjn0.domain.car.Name;
import me.lxxjn0.domain.car.Position;

public class Report {

    private final static String PRINTING_MOVING_UNIT = "-";
    private static final String DELIMITER = " : ";

    private final String report;

    public Report(final String report) {
        this.report = report;
    }

    public static Report of(final Name name, final Position position) {
        Objects.requireNonNull(name, "이름이 null입니다.");
        Objects.requireNonNull(position, "위치가 null입니다.");

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name.getName());
        stringBuilder.append(DELIMITER);

        for (int i = 0; i < position.getPosition(); i++) {
            stringBuilder.append(PRINTING_MOVING_UNIT);
        }
        return new Report(stringBuilder.toString());
    }

    public String getReport() {
        return report;
    }
}
