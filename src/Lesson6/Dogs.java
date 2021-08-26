package Lesson6;

public class Dogs extends Animals {

    /*public Dogs(){
        this("#dog");
    }*/

    public Dogs(String id, String name, int distance) {
        super(id, name, distance);
    }

    @Override
    public void run() {
        if (getDistance() <= 500) {
            System.out.print(getName() + " пробежал " + getDistance() + " метров");
        } else {
            System.out.print(getName() + " сдох не пробежав " + getDistance() + " метров");
        }
    }

    @Override
    public void swim() {
        if (getDistance() <= 10) {
            System.out.println(" и проплыл " + getDistance() + " метров");
        } else {
            System.out.println(" и утонул не проплыв " +  + getDistance() + " метров");
        }
    }
}
