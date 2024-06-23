/*Day24 Task 4: 
Lambda Expressions
Implement a Comparator for a Person class using a lambda expression, and sort 
a list of Person objects by their age..
*/

//Solution:

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class PersonComparatorExample {
    public static void main(String[] args) {
        // Creating a list of Person objects
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 30));
        personList.add(new Person("Bob", 25));
        personList.add(new Person("Charlie", 35));

        // Sorting the list of Person objects by age using a Comparator with lambda expression
        Collections.sort(personList, Comparator.comparingInt(Person::getAge));

        // Printing the sorted list
        System.out.println("Sorted List by Age:");
        for (Person person : personList) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }
}
