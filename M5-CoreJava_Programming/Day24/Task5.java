/*Day 24 Task 5: 
Functional Interfaces
Create a method that accepts functions as parameters using Predicate, 
Function, Consumer, and Supplier interfaces to operate on a Person object.
*/

//Solution:

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class FunctionInterfaceExample {
    // Method that accepts functions as parameters
    public static void operateOnPerson(Person person,
                                       Predicate<Person> predicate,
                                       Function<Person, Person> function,
                                       Consumer<Person> consumer,
                                       Supplier<Person> supplier) {

        // Applying the Predicate
        if (predicate.test(person)) {
            // Applying the Function
            Person modifiedPerson = function.apply(person);

            // Applying the Consumer
            consumer.accept(modifiedPerson);
        } else {
            // Using the Supplier
            Person newPerson = supplier.get();
            consumer.accept(newPerson);
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 30);

        // Example usage of operateOnPerson method
        operateOnPerson(person,
                p -> p.getAge() >= 18,                            // Predicate: Check if age is greater than or equal to 18
                p -> new Person(p.getName().toUpperCase(), p.getAge() + 1),  // Function: Convert name to uppercase and increment age
                p -> System.out.println("Modified Person: " + p.getName() + ", " + p.getAge()), // Consumer: Print modified person
                () -> new Person("Unknown", 0));                  // Supplier: Create a new default person

        // Example of using Supplier if Predicate fails
        operateOnPerson(new Person("Bob", 15),
                p -> p.getAge() >= 18,
                p -> new Person(p.getName().toUpperCase(), p.getAge() + 1),
                p -> System.out.println("Modified Person: " + p.getName() + ", " + p.getAge()),
                () -> new Person("Unknown", 0));
    }
}
