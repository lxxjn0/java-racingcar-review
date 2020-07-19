package me.lxxjn0.view;

import java.util.List;

public class ConsoleOutput {

    public static void printReport(final List<String> reports) {
        System.out.println("실행 결과");

        for (String report : reports) {
            System.out.println(report);
        }
    }
}
