/*Day-24
Task 3: Reflection API 
Use reflection to inspect a class's methods, fields, and constructors, and
modify the access level of a private field, setting its value during runtime
*/

//Solution:

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class ReflectionExample {

    private String privateField = "Original Value";

    public ReflectionExample() {
        // Default constructor
    }

    public ReflectionExample(String privateFieldValue) {
        this.privateField = privateFieldValue;
    }

    public void publicMethod() {
        System.out.println("Inside publicMethod");
    }

    private void privateMethod() {
        System.out.println("Inside privateMethod");
    }

    public static void main(String[] args) throws Exception {
        ReflectionExample obj = new ReflectionExample();

        // Get the class of the object
        Class<?> objClass = obj.getClass();

        // Inspect methods
        System.out.println("Methods:");
        Method[] methods = objClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // Inspect fields
        System.out.println("\nFields:");
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        // Inspect constructors
        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = objClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        // Modify the access level of the private field and set its value
        Field privateField = objClass.getDeclaredField("privateField");
        privateField.setAccessible(true);
        privateField.set(obj, "Modified Value");

        // Verify the modification
        System.out.println("\nModified privateField: " + obj.privateField);
    }
}
