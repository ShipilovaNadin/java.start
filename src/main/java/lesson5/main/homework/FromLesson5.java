package lesson5.main.homework;

import java.util.*;
import java.util.Map.Entry;

public class FromLesson5 {
    public static void main(String[] args) {

        addNames();
        //ex2();
        //exerciseThree();
    }

    private static List<String> addPhoneNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество номеров телефона: ");
        int quantityNumbers = sc.nextInt();
        List<String> listPhoneNumber = new ArrayList<>();
        for (int i = 0; i < quantityNumbers; i++) {
            System.out.println("Введите номер телефона: ");
            String phoneNumber = sc.next();
            try {
                Integer.parseInt(phoneNumber);
                listPhoneNumber.add(phoneNumber);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return listPhoneNumber;
    }

    // 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    private static void addNames() {
        Map<String, List<? extends String>> phoneBook = new HashMap<>();
        //while (true) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя для добавления в телефонную книгу: ");
        String name = sc.next();
        phoneBook.put(name, addPhoneNumbers());
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Введите имя для добавления в телефонную книгу: ");
        String name2 = sc2.next();
        phoneBook.put(name2, addPhoneNumbers());
        // }
        System.out.println(phoneBook);
    }

    // 2. Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
    // Отсортировать по убыванию популярности.
    private static void ex2() {
        String[] fullNames = new String[]{
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"
        };
        List<String> listNames = getName(fullNames);
        Map<String, Integer> mapNames = getMap(listNames);
        System.out.println("Повторяющиеся имена: ");
        duplicateNames(mapNames);
        System.out.println("Отсортированный по популярности список имен: ");
        sortNames(mapNames);
    }
    private static List<String> getName(String[] list) { // создаем список из имен (индекс ноль каждой строки во входящем массиве строк
        List<String> listNames = new ArrayList<>();
        for (String item : list) {
            String[] listItems = item.split(" ");
            listNames.add(listItems[0]);
        }
        return listNames;
    }
    private static Map<String, Integer> getMap(List<String> list) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            String element = list.get(i);
            for (String item : list) {
                if (element.equals(item)) {
                    count++;
                }
            }
            if (!stringIntegerMap.containsKey(element)) {
                stringIntegerMap.put(element, count);
            }
        }
        return stringIntegerMap;
    }
    private static void duplicateNames(Map<String, Integer> map) {
        for (var item : map.entrySet()) {
            if (item.getValue() > 1) {
                System.out.printf("%s: %d \n", item.getKey(), item.getValue());
            }
        }
    }
    private static void sortNames(Map<String, Integer> map) {
        Map<String, Integer> sortMap = new LinkedHashMap<>();
        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> item : list) {
            sortMap.put(item.getKey(), item.getValue());
        }
        for (var item : sortMap.entrySet()) {
            System.out.printf("%s\n", item.getKey());
        }
    }

    // Написать метод, который переведёт данное целое число в римский формат.
    private static void exerciseThree() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число (от 1 до 3999): ");
        int num = scan.nextInt();
        if (num > 0 && num < 4000) {
            System.out.printf("Метод 1: %d -----> %s\n", num, numToRoman(num));
            System.out.printf("Метод 2: %d -----> %s", num, getRomanNumber(num));
        } else System.out.println("Введено некоректное число");
    }
    private static String numToRoman(int number) {
        TreeMap<Integer, String> romanNumbers = new TreeMap<>();
        romanNumbers.put(1000, "M");
        romanNumbers.put(900, "DM");
        romanNumbers.put(500, "D");
        romanNumbers.put(400, "CD");
        romanNumbers.put(100, "C");
        romanNumbers.put(90, "XC");
        romanNumbers.put(50, "L");
        romanNumbers.put(40, "XL");
        romanNumbers.put(10, "X");
        romanNumbers.put(9, "IX");
        romanNumbers.put(5, "V");
        romanNumbers.put(4, "IV");
        romanNumbers.put(1, "I");
        int maxKey = romanNumbers.floorKey(number);
        if (number == maxKey) {
            return romanNumbers.get(number);
        }
        return romanNumbers.get(maxKey) + numToRoman(number - maxKey);
    }
    public static String getRomanNumber(int number) {
        return "I".repeat(number)
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }
}



