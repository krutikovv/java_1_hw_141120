package hw6;

public class Animal {
    String name;
    int runLimit;
    int swimLimit;
    static int count = 0;

    public Animal(String name){
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.count++;
    }

    public void run(int length){
        System.out.println(name + " пробежал " + length);
    }

    public void swim(int length){
        System.out.println(name + " проплыл " + length);
    }

    public static int getCount() {
        return count;
    }
}
