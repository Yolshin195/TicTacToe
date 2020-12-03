package ru.yolshin;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int rowSize;
    private final List<Label> gameField;

    public Map(int size) {
        this.rowSize = (int) Math.sqrt(size);
        this.gameField = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            gameField.add(Label.NULL);
        }
    }

    public int getSize() {
        return gameField.size();
    }

    public boolean isIntersection(Label label) {

        for (int i = 0; i < rowSize; i += 3) {
            if (gameField.get(i) == label
                    && gameField.get(i + 1) == label
                    && gameField.get(i + 2) == label) {
                return true;
            }
        }

        for (int i = 0; i < rowSize; i++) {
            if (gameField.get(i) == label
                    && gameField.get(i + 3) == label
                    && gameField.get(i + 6) == label) {
                return true;
            }
        }

        if (gameField.get(0) == label
                && gameField.get(4) == label
                && gameField.get(8) == label) {
            return true;
        }

        return gameField.get(2) == label
                && gameField.get(4) == label
                && gameField.get(6) == label;
    }

    public boolean isNULL(int x, int y) {
        return gameField.get(getIndex(x-1, y-1)) == Label.NULL;
    }

    public void setLabel(int x, int y, Label label) {
        int index = getIndex(x-1, y-1);

        if (gameField.get(index) == Label.NULL) gameField.set(index, label);
    }

    @Override
    public String toString() {
        return """
             1   2   3
           |---|---|---|
         1 | %s | %s | %s | 1
           |---|---|---|
         2 | %s | %s | %s | 2
           |---|---|---|
         3 | %s | %s | %s | 3
           |---|---|---|
             1   2   3
        """.formatted(
                gameField.get(0),
                gameField.get(1),
                gameField.get(2),
                gameField.get(3),
                gameField.get(4),
                gameField.get(5),
                gameField.get(6),
                gameField.get(7),
                gameField.get(8)
        );
    }

    private int getIndex(int x, int y) {
        return y * rowSize + x;
    }
}
