package Lesson5;

public class Person {

    private String fullName;
    private String position;
    private String eMail;
    private int telephone;
    private int salary;
    private int age;

    public Person(String fullName, String position, String eMail, int telephone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    void showBase() {
            System.out.println("Person:" + fullName);
            System.out.println("Position:" + position);
            System.out.println("e-mail:" + eMail);
            System.out.println("Telephone:" + telephone);
            System.out.println("Salary:" + salary);
            System.out.println("Age:" + age);
        }
}

