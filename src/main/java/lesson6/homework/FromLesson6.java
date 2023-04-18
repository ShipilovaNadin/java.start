package lesson6.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//Создать множество ноутбуков (ArrayList).
//Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям. Например, спросить у пользователя
// минимальный размер оперативной памяти или конкретный цвет. Выводить только те ноутбуки, что соответствуют условию
public class FromLesson6 {
    static List<Notebook> notebookList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        creatNotebook();
        getResult(showMenu());
    }
    public static String showMenu() {
        System.out.println("""
                Выберите действие: 
                1 - фильтр по размеру экрана
                2 - фильтр по цвету ноутбука
                3 - фильтр по фирме
                """);
        return scanner.nextLine();
    }
    public static void getResult(String input) {
        switch (input) {
            case ("1") -> {
                System.out.println("Введите размер экрана: ");
                int size = scanner.nextInt();
                filterBySize(size);
            }
            case("2") -> {
                System.out.println("Введите цвет ноутбука: ");
                String color = scanner.nextLine();
                filterByColor(color);
            }
            case("3") -> {
                System.out.println("Введите фирму изготовителя ноутбука: ");
                filterByBrand(scanner.nextLine());
            }
            default -> System.out.println("Ошибка ввода!");
        }
    }

    private static void filterByBrand(String brand) {
        for (Notebook notebook : notebookList) {
            if (notebook.brand.equalsIgnoreCase(brand)){
                System.out.println(notebook);
            }
        }
    }
    private static void filterByColor(String color) {
        for (Notebook notebook : notebookList) {
            if(notebook.color.equalsIgnoreCase(color)) {
                System.out.println(notebook);
            }
        }
    }
    private static void filterBySize(int size) {
        for (Notebook notebook : notebookList) {
            if(notebook.screenSize == size){
                System.out.println(notebook);
            }
        }
    }
    public static void creatNotebook (){
        Notebook notebook1 = new Notebook(10);
        notebook1.brand = "Lenovo";
        notebook1.color = "Black";
        notebook1.screenSize = 15;

        Notebook notebook2 = new Notebook(20);
        notebook2.brand = "Acer";
        notebook2.color = "Black";
        notebook2.screenSize = 17;

        Notebook notebook3 = new Notebook(30);
        notebook3.brand = "Xiaomi";
        notebook3.color = "Silver";
        notebook3.screenSize = 15;

        Notebook notebook4 = new Notebook(40);
        notebook4.brand = "Lenovo";
        notebook4.color = "Silver";
        notebook4.screenSize = 15;

        notebookList.add(notebook1);
        notebookList.add(notebook2);
        notebookList.add(notebook3);
        notebookList.add(notebook4);
    }
}
