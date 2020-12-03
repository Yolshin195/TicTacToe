package ru.yolshin;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Map map = new Map(9);

        List<User> users = new ArrayList<>();
        users.add(new User("Alexey", Label.X));
        users.add(new User("Anna", Label.O));

        Game game = new Game(map, users);
        game.run();
    }
}
