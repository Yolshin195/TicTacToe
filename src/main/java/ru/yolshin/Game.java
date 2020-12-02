package ru.yolshin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game implements Runnable {
    private final Map map;
    private final List<User> users;
    private User currentUser;
    private boolean isGaming;
    private int currentStep;
    private final int maxStep;

    Game() {
        this.currentStep = 1;
        this.maxStep = 9;
        this.map = new Map(maxStep);
        this.users = new ArrayList<>();
        this.users.add(new User("Alex", Label.X));
        this.users.add(new User("Anna", Label.O));
        this.currentUser = users.get(0);
    }

    private void nextUser() {
        int nextUser = currentStep % 2;

        currentUser = users.get(nextUser);
    }

    private void nextStep() {
        currentStep++;
        if (currentStep > maxStep) isGaming = false;
    }

    private int[] getUserInput() {
        System.out.print("Введите номер строки и столбца X Y>");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        return new int[]{x, y};
    }

    private void step(int x, int y) {
        map.setLabel(x, y, currentUser.getLabel());
    }

    private String show() {
        return "Текущий ход: " + currentStep + "\n" +
                map +
                "Ход игрока: " + currentUser;
    }

    @Override
    public void run() {
        isGaming = true;
        while (isGaming) {
            System.out.println(show());

            int[] input = getUserInput();
            if (!map.isNULL(input[0], input[1])) {
                System.out.println("Эта ячейка занята, выбери другую");
                continue;
            }
            step(input[0], input[1]);

            if (map.isIntersection(currentUser.getLabel())) {
                System.out.println("--------------Победа!!!---------------");
                System.out.printf("Победил игрок: %s%n", currentUser);
                isGaming = false;
            }

            nextUser();
            nextStep();
        }

        System.out.println(map);
    }

    @Override
    public String toString() {
        return """
                %s
                Ход Игрока: %s
                """.formatted(map, currentUser);
    }
}
