package ru.yolshin;

public class User {
    private final String username;
    private final Label label;

    public User(String username, Label label) {
        this.username = username;
        this.label = label;
    }

    public Label getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "%s-%s".formatted(username, label);
    }
}
