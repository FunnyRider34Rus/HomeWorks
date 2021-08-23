package Lesson6;

public class Cats extends Animals {

    /*public Cats(){
        this("#cat");
    }*/

    public Cats(String id, String name, int distance) {
        super(id, name, distance);
    }

    @Override
    public void run() {
        if (getDistance() <= 200) {
            System.out.print(getName() + " пробежал " + getDistance() + " метров");
        } else {
            System.out.print(getName() + " сдох не пробежав " + getDistance() + " метров");
        }
    }

    @Override
    public void swim() {
        if (getDistance() > 0) {
            System.out.println(" и утонул");
        } else {
            System.out.println(" и в воду не полез)))");
        }
    }
}
