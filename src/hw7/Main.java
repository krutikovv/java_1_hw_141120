package hw7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat cat[] = {
                new Cat("Tiger", 50, 50),
                new Cat("Puma", 100, 20),
                new Cat("Leopard", 150, 30),
                new Cat("Pantera", 200, 40)
        };

        Plate plate = new Plate(100);

        for (int i = 0; i < 4; i++) {
            cat[i].eat(plate);
            cat[i].info();
            plate.info();
            plate.addFood(10);
            plate.info();
            separator();
        }
    }
    public static void separator(){
        System.out.println("********************");
    }
}
