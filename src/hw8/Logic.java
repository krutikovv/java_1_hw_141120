package hw8;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    static int SIZE;
    static int DOTS_TO_WIN;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Random random = new Random();

    static byte gameFinished;

    static StringBuilder[] winMassive; //Для хранения координат победной линии

    static String[] resultStrings = {"Вы выиграли!", "Компьютер победил", "Ничья"};
    static StringBuilder resultString;

    public static void go() {
        gameFinished = 0;

        //printMap();
        if (checkWinLines(DOT_X, DOTS_TO_WIN)) {
            System.out.println("Вы выиграли!!!");
            for (int i = 0; i < DOTS_TO_WIN; i++) {
                System.out.print(winMassive[i] + "; ");
            }
            gameFinished = 1;
            return;
        }
        if (isFull()) {
            System.out.println("Ничья");
            gameFinished = 3;
            return;
        }

        aiTurn();
        //printMap();
        if (checkWinLines(DOT_O, DOTS_TO_WIN)) {
            System.out.println("Комьютер победил");
            gameFinished = 2;
            return;
        }
        if (isFull()) {
            System.out.println("Ничья");
            gameFinished = 3;
            return;
        }

    }

    static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
        winMassive = new StringBuilder[DOTS_TO_WIN];
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    static void humanTurn(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }
    }

    static void aiTurn() {
        int x;
        int y;

        // Попытка победить самому
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O, DOTS_TO_WIN)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
// Сбить победную линии противника, если осталось 1 ход для победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOTS_TO_WIN)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

// Сбить победную линии противника, если осталось 2 хода для победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOTS_TO_WIN - 1) &&
                            Math.random() < 0.5) { //  фактор случайности, чтобы сбивал не все время первый попавшийся путь.
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

// Сходить в произвольную не занятую ячейку

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }


    static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkLine(int cy, int cx, int vy, int vx, char dot, int dotsToWin) {
        if (cx + vx * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) > SIZE - 1 ||
                cy + vy * (dotsToWin - 1) < 0) {
            return false;
        }

        for (int i = 0; i < dotsToWin; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
            winMassive[i] = new StringBuilder(Integer.toString(cy + i * vy) +
                    Integer.toString(cx + i * vx));//(cy + i * vy) + (cx + i * vx));
        }
        return true;
    }

    static boolean checkWinLines(char dot, int dotsToWin) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot, dotsToWin) ||
                    checkLine(i, j, 1, 0, dot, dotsToWin) ||
                    checkLine(i, j, 1, 1, dot, dotsToWin) ||
                    checkLine(i, j, -1, 1, dot, dotsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }

}
