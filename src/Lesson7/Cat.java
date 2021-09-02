package Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private static boolean satiety = false;

    public Cat(String name, int appetite) {//конструктор
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {//задаем геттеры, так как сеттеры здесь не пригодились
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void eat(Plate p){
        satiety = p.decreaseFood(appetite);
    }
}
