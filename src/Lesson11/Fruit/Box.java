package Lesson11.Fruit;

import java.util.*;

public class Box <CONTENT extends Fruit>{

    private List<CONTENT> fruits = new ArrayList<>();

    public void setBox(CONTENT fruit) {
        fruits.add(fruit);
    }

    public float getWeight(){
        float weight = 0.0f;
        for (int i = 0; i < fruits.size(); i++) {
            weight += fruits.get(i).weight();
        } return weight;
    }

    public boolean compare(Box<?> anotherBox){
        return this.getWeight() == anotherBox.getWeight();
    }

    public void moveToAnotherBox (Box<Fruit> anotherBox){
        if (anotherBox.fruits.isEmpty()){
            anotherBox.fruits.addAll(this.fruits);
            this.fruits.clear();
        }
    }

    public void addFruit(CONTENT fruit){
        if (fruits.contains(fruit)){                                                                                    //это костыль, так как еще не придумал
            fruits.add(fruit);                                                                                          //как защититься от добавления разных фруктов в одну коробку
        }
    }
}

