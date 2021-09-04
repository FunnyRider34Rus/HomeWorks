package Lesson8.Participants;

public class Robot implements Participants{
    private String name;
    private int maxLength;
    private double maxHeight;

    public Robot(String name, int maxLength, double maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }
}
