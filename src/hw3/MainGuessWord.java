package hw3;

import java.util.Random;
import java.util.Scanner;

public class MainGuessWord {
    static Scanner scanner;
    static Random random;
    public static void main(String[] args) {
        //comment
        scanner = new Scanner(System.in);
        random = new Random();
        int wordToGuessNum;
        String wordToGuess;
        String wordUser;
        String wordTemp = "###############"; //15 символов
        char[] arrWordTemp = wordTemp.toCharArray();
        String[] words = {"apple", "orange", "lemon", "banana",
                          "apricot", "avocado", "broccoli", "carrot",
                          "cherry", "garlic", "grape", "melon", "leak",
                          "kiwi", "mango", "mushroom", "nut", "olive",
                          "pea", "peanut", "pear", "pepper", "pineapple",
                          "pumpkin", "potato"};
        wordToGuessNum = random.nextInt(words.length);
        wordToGuess = words[wordToGuessNum];

        String wordExit = "exit";
        int arrLimit;

        System.out.println("Игра 'Угадай слово'. Для выхода введите 'exit'");
        System.out.println(wordToGuess);
        do {
            System.out.println("Введите слово:");
            wordUser = scanner.nextLine();

            if (wordUser.equals(wordExit)) break;

            if (wordUser.equals(wordToGuess)) {
                System.out.println("Вы выиграли! Игра окончена");
                break;
            } else {
                arrLimit = Math.min(wordToGuess.length(),wordUser.length());
                for (int i = 0; i < arrLimit; i++) {
                    if ((wordUser.charAt(i) == wordToGuess.charAt(i))) {
                        arrWordTemp[i] = wordToGuess.charAt(i);
                    }
                }
                System.out.println("Пробуйте дальше");
                System.out.println(arrWordTemp);
            }
        } while (true);
    }
}
