package hw6;

public class Cat extends Animal {
    static int count = 0;

    public Cat(String name) {
        super(name);
        this.runLimit = 200;
        this.count++;
    }

    @Override
    public void run(int length){
        if (length <= runLimit) {
            System.out.println(this.name + " пробежал " + length + " метров");
        } else {
            System.out.println(this.name + " не может бежать более " + this.runLimit + " метров");
        }
    }

    @Override
    public void swim(int length){
        System.out.println(this.name + " не умеет плавать");
    }

    public static int getCount() {
        return count;
    }
}
