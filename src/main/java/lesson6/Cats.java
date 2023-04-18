package lesson6;

public class Cats {
    public static void main(String[] args) {

        Cat cat1 = new Cat(1);
        cat1.name = "Boolia";
        cat1.age = 2;
        cat1.type = "russian";
        cat1.ownerName = "Vernina";

        Cat cat2 = new Cat(2, "Nina", 3, "britiesh", "Miretish");

        System.out.println(cat1);
        System.out.println(cat2);
    }

}
