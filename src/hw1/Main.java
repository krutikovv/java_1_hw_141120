package hw1;

public class Main {

    public static void main(String[] args) {
        boolean bl = false;
        byte bt = 111;
        short sh = 22222;
        int i = 333333333;
        long l = 4444444444444444444L;
        float f = 0.1234567F;
        double d = 0.1234567890123456;
        char c = 'a';

        System.out.println(usd (3,2,8,4));

        System.out.println(f(5, 10));

        posOrNegString(0);

        System.out.println(posOrNegBoolean(0));

        hello("Влад");

        year(1700);
    }

    public static float usd(float a, float b, float c, float d){
        return a * (b + c / d);
    }

    public static boolean f(int a, int b){
        return ((a + b >= 10) && (a + b <= 20));
    }

    public static void posOrNegString (int a){
        System.out.printf(a >= 0 ? "Положительное\n" : "Отрицательное\n");
    }

    public static boolean posOrNegBoolean (int a){
        return a < 0;
    }

    public static void hello(String a){
        System.out.println("Привет, " + a);
    }

    public static void year(int a){
        boolean tempBool;
        tempBool = (a % 4 == 0) && !(a % 100 == 0) || (a % 400 == 0);
        System.out.printf(tempBool ? "Высокосный" : "Невысокосный");
    }
}


