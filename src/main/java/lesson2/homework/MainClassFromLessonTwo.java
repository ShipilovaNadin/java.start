package lesson2.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

public class MainClassFromLessonTwo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввведите строку: ");
        String str = scanner.nextLine().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        System.out.println(checkPalindrome(str));
       // String text = makeStringFrom("TEST");
       // makeFile(text);
        //       showTypeOfFilesInDir();
    }
    // 1. Напишите метод, который принимает на вход строку (String) и
// определяет является ли строка палиндромом (возвращает boolean значение).
    private static boolean checkPalindrome(String str) {
        return str.equals((new StringBuilder()).reverse().toString());
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
        try (PrintWriter pw = new PrintWriter("src/main/java/lesson2/files/output.txt")) {
            pw.print(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // 3*.Напишите метод, который определит тип (расширение) файлов из текущей папки
    // и выведет в консоль результат вида:
    //        1 Расширение файла: txt
    //        2 Расширение файла: pdf
    //        3 Расширение файла:
    //        4 Расширение файла: jpg

    private static void showTypeOfFilesInDir() {
        File file = new File("C:\\Users\\nadin\\OneDrive\\Рабочий стол\\studies\\linux");
        String[] dirListNames = file.list();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dirListNames.length; i++) {
            String fileName = dirListNames[i];
            if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) { // если в имени файла есть точка и она не является первым символом в названии файла
                sb.append(i+1).append(" Расширение файла: ").
                        append(fileName.substring(fileName.lastIndexOf(".") + 1)).
                        append(System.lineSeparator()); // вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            } else sb.append(i+1).append(" Расширение файла: ").append("").append(System.lineSeparator());
        }
       System.out.println(sb);


    }
    // вариант решения последней задачи учителя
    private static void ex6(String path) {
        File dir = new File(path);
        int count = 1;
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            String ext = "";
            if (file.isDirectory()) {
                ext = "dir";
            } else {
                String[] parts = file.getName().split("\\.");
                if (parts.length > 1) {
                    ext = parts[parts.length - 1];
                }
            }

            System.out.printf("%2s) Расширение файла: %s%n", count++, ext);
        }
    }

}
