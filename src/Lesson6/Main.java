package Lesson6;

public class Main {
    public static void main(String[] args) {
        ride(createAnimals());
    }

    static void ride(Animals[] animals){
        for (int i = 0; i < animals.length; i++) {
            animals[i].run();
            animals[i].swim();
        }
    }

    static Animals[] createAnimals(){
        return new Animals[] {
                new Dogs("#dog","Шарик", 10),
                new Dogs("#dog","Тузик", 500),
                new Dogs("#dog","Полкан", 800),
                new Cats("#cat", "Мурзик", 50),
                new Cats("#cat", "Барсик", 500),
                new Cats("#cat", "Тишка", 0)
        };
    }
}
