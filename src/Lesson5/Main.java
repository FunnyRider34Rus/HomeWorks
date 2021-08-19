package Lesson5;

public class Main {
    public static void main(String[] args) {

        Person[] personArray = new Person[5];
        personArray[0] = new Person("Ivan Ivanov", "Engneer", "ivivan@mailbox.com", 892312312, 30000, 30);
        personArray[1] = new Person("Aleksnder Petrov", "Traveler", "alxp.etrov@mailbox.com", 892312310, 45000, 39);
        personArray[2] = new Person("Ruslan Boshirov", "Traveler", "bosh.rus@mailbox.com", 892312311, 45000, 40);
        personArray[3] = new Person("Ivan Petrov", "Astronaut", "iv.petrov@mailbox.com", 892312309, 50000, 25);
        personArray[4] = new Person("Peter Ivanov", "Miner", "pt.ivanov@mailbox.com", 892312308, 60000, 45);

        for (int i = 0; i < personArray.length; i++) {
            if (personArray[i].getAge() >= 40) {
                personArray[i].showBase();
            }
        }
    }
}