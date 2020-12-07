package hw6;

public class Main {
    public static void main(String[] args) {
       Cat cat = new Cat("Пуфик");
       Cat cat2 = new Cat("Васька");
       Cat cat3 = new Cat("Мурзик");
       Dog dog = new Dog ("Барсик");
       Dog dog2 = new Dog ("Шарик");

       cat.run(300);
       cat.swim(50);
       cat2.run(100);
       cat2.swim(40);
       cat3.run(30);
       cat3.swim(10);
       dog.run(520);
       dog.swim(8);
       dog2.run(400);
       dog2.swim(20);
       System.out.println("Кошек " + cat.getCount());
       System.out.println("Собак " + dog.getCount());
       System.out.println("Животных " + Animal.getCount());

    }
}
