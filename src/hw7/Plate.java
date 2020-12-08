package hw7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (amount < 0){
            System.out.println("Enter positive number");
            return;
        }
        food -= amount;
    }

    public void addFood(int amountFood){
        if (amountFood > 0) {
            food += amountFood;
            System.out.println("Food is after: ");
        } else {
            System.out.println("Enter positive number");
        }

    }

    public void info() {
        System.out.println("Food: " + food);
    }
}
