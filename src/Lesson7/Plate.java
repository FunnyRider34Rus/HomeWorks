package Lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        } else {
            System.out.println("В тарелке не хватает еды!");
            return false;
        }
    }

    public void addFood(int n){
        this.food = food + n;
    }

    public void info(){
        System.out.println("В тарелке: " + food + " единиц еды");
    }
}
