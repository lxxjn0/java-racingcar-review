package me.lxxjn0.view;

import java.util.Scanner;

public class ConsoleInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInput() {
    }

    public static String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return SCANNER.nextLine();
    }

    public static String receiveAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return SCANNER.nextLine();
    }
}
