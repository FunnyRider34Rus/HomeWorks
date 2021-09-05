package Lesson8.Participant;

public class Human implements Participant {
    private String name;
    private boolean isContinue = true;
    private int maxLength;
    private double maxHeight;

    public Human(String name, int maxLength, double maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    public boolean isContinue(){
        return isContinue;
    }

    @Override
    public void running(int length) {
        if (isContinue) {
            if (length <= maxLength) {
                System.out.println(name + " пробежал");
            } else {
                isContinue = false;
                System.out.println(name + " не пробежал");
            }
        }
    }

    @Override
    public void jumping(double height) {
        if (isContinue) {
            if (height <= maxHeight) {
                System.out.println(name + " перепрыгнул");
            } else {
                isContinue = false;
                System.out.println(name + " не перепрыгнул");
            }
        }
    }
}
