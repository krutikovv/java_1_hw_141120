package hw6;

public class Dog extends Animal {
    static int count = 0;

    public Dog(String name) {
        super(name);
        this.runLimit = 500;
        this.swimLimit = 10;
        this.count++;
    }

    @Override
    public void run(int length){
        if (length <= this.runLimit) {
            System.out.println(this.name + " пробежал " + length + " метров");
        } else {
            System.out.println(this.name + " не может бежать более " + this.runLimit + " метров");
        }
    }

    @Override
    public void swim(int length){
        if (length <= this.swimLimit) {
            System.out.println(this.name + " проплыл " + length + " метров");
        } else {
            System.out.println(this.name + " не может плыть более " + this.swimLimit + " метров");
        }
    }

    public static int getCount() {
        return count;
    }
}
