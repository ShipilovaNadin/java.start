package lesson6.homework;

public class Notebook {
    int id;
    String brand;
    String color;
    int screenSize;

    public Notebook(int id) {
        this.id = id;
    }
    public String toString() {
        return String.format("id: %d%n brand: %s%n color: %s%n screenSize: %d%n" , id, brand, color, screenSize);
    }
}
