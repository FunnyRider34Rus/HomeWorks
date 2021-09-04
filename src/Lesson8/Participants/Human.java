package Lesson8.Participants;

public class Human implements Participants{
    private String name;
    private int maxLength;
    private double maxHeight;

    public Human(String name, int maxLength, double maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }
}
