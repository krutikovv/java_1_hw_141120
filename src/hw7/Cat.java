package hw7;

public class Cat {
    private String name;
    private int satiety; //Сытость
    private int eatDegreaseAmount; //Скорость поедания

    public Cat(String name, int satiety, int eatDegreaseAmount) {
        this.name = name;
        this.satiety = satiety;
        this.eatDegreaseAmount = eatDegreaseAmount;
    }

    public String getName() {
        return name;
    }

    public int getSatiety() {
        return satiety;
    }

    public int getEatDegreaseAmount() {
        return eatDegreaseAmount;
    }

    public void eat(Plate plate) {
        //System.out.println("Cat " + name + " eat...");
        if (plate.getFood() >= eatDegreaseAmount) {
            plate.decreaseFood(eatDegreaseAmount);
            setSatiety(satiety - eatDegreaseAmount);
        } else {
            System.out.println("Not enough food(");
        }
    }

    public void setSatiety(int satiety) {
        if (satiety <= 0){
            this.satiety = 0;
            System.out.println("Cat " + name + " is full");
            return;
        }
        this.satiety = satiety;
    }

    public void info() {
        System.out.println(name + " | Satiety : " + satiety);
    }

    public void fear(Dog dog){
        System.out.println("Cat "+ name + " fear dog "+ dog.getName());
    }


}
