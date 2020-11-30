package hw3;

import java.util.Random;
import java.util.Scanner;

public class MainGame {
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {
        //comment
        scanner = new Scanner(System.in);
        random = new Random();
        int bound = 10;
        byte numOfAttempts = 4;
        byte numOfAttemptsNow = 0;
        int numToGuess = random.nextInt(bound);
        int numUser;
        int answerOfUser = 0;
        String tempS;
        System.out.println("'Угадай число'\nКоличество попыток - " + numOfAttempts);
        do {
            numOfAttemptsNow++;
            if (numOfAttemptsNow == 1) {
                System.out.println("Введите число:");
            }
            numUser = scanner.nextInt();
            if (numUser == numToGuess){
                System.out.println("Вы выиграли. Сыграем заново? 1 - да, 0 - нет:");
                answerOfUser = scanner.nextInt();
                if (answerOfUser == 0){
                    break;
                } else {
                    numOfAttemptsNow = 0;
                    numToGuess = random.nextInt(bound);
                    continue;
                }
            } else {
                if (numOfAttemptsNow < numOfAttempts) {
                    tempS = (numUser > numToGuess) ?
                            "Введите число меньше. ":
                            "Введите число больше. ";
                    System.out.println(tempS + "Осталось попыток: " + (numOfAttempts - numOfAttemptsNow));
                    continue;
                } else {
                    System.out.println("Вы проиграли. Сыграем заново? 1 - да, 0 - нет:");
                    answerOfUser = scanner.nextInt();
                    if (answerOfUser == 0){
                        break;
                    } else {
                        numOfAttemptsNow = 0;
                        numToGuess = random.nextInt(bound);
                        continue;
                    }
                }
            }
        }while (numOfAttemptsNow < numOfAttempts);
        System.out.println("Игра окончена");
    }
}
