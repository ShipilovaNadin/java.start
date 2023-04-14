package lesson4.dop.homework;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class MainFromLesson4 {
    public static void main(String[] args) {
        // ex1();
        ex2();

    }

    private static void ex1() {

        // 1. Реализовать консольное приложение, которое:
        //Принимает от пользователя и “запоминает” строки.
        //Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
        //Если введено revert, удаляет предыдущую введенную строку из памяти.

        Scanner scanner = new Scanner(System.in);
        Stack<String> list = new Stack<>();

        while (true) {
            System.out.println("Введите строку (print/revert/stop для выполнения команд):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("print")) {
                System.out.println("Строки в обратном порядке:");

                while (!list.isEmpty()) {
                    System.out.println(list.pop());
                }
            } else if (input.equalsIgnoreCase("stop")) {
                break;
            } else if (input.equalsIgnoreCase("revert")) {
                if (!list.isEmpty()) {
                    list.pop();
                    System.out.println("Последняя введенная строка удалена из памяти.");
                } else {
                    System.out.println("Нет сохраненных строк для удаления.");
                }
            } else {
                list.add(input);
            }
        }
    }


    private static void ex2() {
        // 2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        Collections.reverse(list);
        // System.out.println(list); // [c, b, a];
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}

