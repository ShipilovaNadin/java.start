package lesson3.homework;

import java.util.*;

public class MainClassFromLessonThree {
    public static void main(String[] args) {
        //cutEvenNumFromList();
        //findMinMaxAverageNumsFromList();
        //ex2();
        cutNumFromStringList();
    }

    // Пусть дан произвольный список целых чисел, удалить из него четные числа
    // (в языке уже есть что-то готовое для этого)
    private static void cutEvenNumFromList() {
        ArrayList<Integer> numList = new ArrayList<>();
        Random random = new Random();
        int size = 20;
        for (int i = 0; i < size; i++) {
            numList.add(random.nextInt(30)); //0-29
        }
        System.out.println("Произвольный список целых чисел" + numList);
        numList.removeIf(i -> (i % 2 == 0));
        System.out.println("Список только нечетных целых чисел: " + numList);
    }

    // 2. Задан целочисленный список ArrayList. Найти минимальное,
    // максимальное и среднее арифметическое из этого списка.
    private static void findMinMaxAverageNumsFromList() {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        int size = 20;
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(-23, 30));
        }
        System.out.println("Целочисленный список: " + list);
        int min = Collections.min(list);
        int max = Collections.max(list);
        int sumElement = 0;
        for (int i = 0; i < list.size(); i++) {
            sumElement += list.get(i);
        }
        int average = sumElement / list.size();
        System.out.println("Минимальное значение в списке " + min);
        System.out.println("Максимальное значение в списке " + max);
        System.out.println("Среденее арифметическое значение в списке " + average);
    }

    // 3. Доделать начатое на семинаре. Пройтись по списку из задания 2 и
    // удалить повторяющиеся элементы.
    public static void ex2() {
        String[] arrPlanet = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto"};
        Random random = new Random();
        List<String> list = new ArrayList<>();
        int size = 30;
        for (int i = 0; i < size; i++) {
            list.add(arrPlanet[random.nextInt(9)]); //0-8
        }
        System.out.println(list);
        Set<String> res = new LinkedHashSet<>(list);
        ArrayList resList = new ArrayList<>(res);
        System.out.println(resList);
    }

    // 4*. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
    // Пройти по списку, найти и удалить целые числа.
    private static void cutNumFromStringList() {
        List<String> list = new ArrayList<>();
        list.add("f");
        list.add("s");
        list.add("4");
        list.add("pmkn");
        list.add("332");
        list.add("f");
        list.add("f");
        list.add("s");
        list.add("4");
        list.add("pmkn");
        list.add("332");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            try {
                Integer.parseInt(list.get(i));
                list.remove(i);
            } catch (NumberFormatException e) {
                /// нормально ли что этот блок пустой? хоть и все работает...
            }
        }
        System.out.println(list);
    }
}
