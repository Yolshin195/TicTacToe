package ru.yolshin;

public enum Label {
    X ("X"),
    O ("O"),
    NULL (" ");

    private final String title;

    Label(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
