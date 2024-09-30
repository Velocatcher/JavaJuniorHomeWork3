package org.example;
/*
Разработайте класс Student с полями name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса.
Создайте объект класса Student и инициализируйте данными.
Сериализовать и десериализовать объект в файл.
Выведите все поля объекта, включая GPA.
 */

import java.io.*;

public class Main {
    public static void main(String[] args)  {
        String name = "Bob";
        int age = 25;
        double gpa = 4.5;
        Person personOne = new Person(name, age, gpa);

//        Сериализация
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("person.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(personOne);
            objectOutputStream.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

//        Десериализация
        try {
            FileInputStream fileInputStream = new FileInputStream("person.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}