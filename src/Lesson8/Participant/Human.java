package Lesson8.Participant;

public class Human implements Participant {
    private String name;
    private int maxLength;
    private double maxHeight;

    public Human(String name, int maxLength, double maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    @Override
    public void running(int maxLength) {

    }

    @Override
    public void jumping(double maxHeight) {

    }
}
