package lesson2.homework;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainClassFromLessonTwo {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ввведите строку: ");
//        String str = scanner.nextLine();
//        System.out.println(checkPalindrome(str));
        String text = makeStringFrom("TEST");
        makeFile(text);

    }

    // 1. Напишите метод, который принимает на вход строку (String) и
// определяет является ли строка палиндромом (возвращает boolean значение).
    private static boolean checkPalindrome(String str) {
        return str.equals((new StringBuilder(str)).reverse().toString());
    }

    // 2. Напишите метод, который составит строку, состоящую из 100 повторений слова TEST
// и метод, который запишет эту строку в простой текстовый файл, обработайте исключения.
    private static String makeStringFrom(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(str).append(System.lineSeparator());
        }
        return sb.toString();
    }
    private static void makeFile(String text) {
        try(PrintWriter pw = new PrintWriter("src/main/java/lesson2/files/output.txt")) {
            pw.print(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
