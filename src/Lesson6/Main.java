package Lesson6;

public class Main { //начинаем анималсную (аномальную?))) олимпиаду!!!
    public static void main(String[] args) {// Звучит свисток и
        ride(createAnimals()); //отправляем всех на сдачу нормативов!
        printStat(createAnimals()); //Немного черного юмора, а почему бы и... да! Задание то необычное!)))
    }

    static void ride(Animals[] animals){
        for (int i = 0; i < animals.length; i++) {
            animals[i].run(); //побежали
            animals[i].swim(); //поплыли
        }
    }

    static Animals[] createAnimals(){ //создаем массив наших спортсменов
        return new Animals[] {
                new Dogs("#dog","Шарик", 10),
                new Dogs("#dog","Тузик", 500),
                new Dogs("#dog","Полкан", 800),
                new Cats("#cat", "Мурзик", 50),
                new Cats("#cat", "Барсик", 500),
                new Cats("#cat", "Тишка", 0)
        };
    }

    static void printStat(Animals[] animals) {//теперь всех посчитаем
        int dogCount = 0, catCount = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].getId() == "#dog"){
                dogCount++;
            }
            if (animals[i].getId() == "#cat"){
                catCount++;
            }
        }
        /*так как класс животные абстрактен, то мы не можем создать его экземпляр напрямую,
        следовательно, количество экземпляров класса энималс равняется сумме объектов дочерних классов
        */
        System.out.println("Всего животных: " + (dogCount + catCount));
        System.out.println("Из них " + dogCount + " собак " + catCount + " и кошек");
    }
}
