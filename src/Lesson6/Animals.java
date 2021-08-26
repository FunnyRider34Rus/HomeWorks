package Lesson6;

public abstract class Animals {

    private String id;
    private String name;
    private int distance;

    public Animals(String id,String name, int distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public abstract void run();
    public abstract void swim();
}
