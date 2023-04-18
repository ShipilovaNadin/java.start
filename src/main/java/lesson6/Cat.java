package lesson6;

import java.util.Objects;

public class Cat {
    int id;
    String name;
    int age;
    String type;
    String ownerName;

    public Cat(int id, String name, int age, String type, String ownerName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.ownerName = ownerName;
    }
    public Cat(int id) {
        this.id = id;
    }
    public String toString() {
       return String.format("%d %s %d %s %s", id, name, age, type, ownerName);
    }
    public static void meow() {
        System.out.println("meow");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;
        return id == cat.id && age == cat.age && Objects.equals(name, cat.name) && Objects.equals(type, cat.type) && Objects.equals(ownerName, cat.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, type, ownerName);
    }
}
