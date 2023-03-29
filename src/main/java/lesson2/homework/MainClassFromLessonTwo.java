package lesson2.homework;

import java.util.Scanner;

public class MainClassFromLessonTwo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввведите строку: ");
        String str = scanner.nextLine();
        boolean n = checkPalindrome(str);
        System.out.println(n);
    }
    private static boolean checkPalindrome(String str) {
        return str.equals((new StringBuilder(str)).reverse().toString());
    }
}
