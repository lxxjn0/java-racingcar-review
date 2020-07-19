package me.lxxjn0.view;

import java.util.List;

public class ConsoleOutput {

    public static void printReport(final List<String> reports) {
        System.out.println("실행 결과");

        for (String report : reports) {
            System.out.println(report);
        }
        System.out.println();
    }

    public static void printWinners(final List<String> winnerNames) {
        String joiningWinnerNames = String.join(",", winnerNames);

        System.out.printf("%s가 최종 우승했습니다.", joiningWinnerNames);
    }
}
