package lesson3.homework;

import java.util.ArrayList;
import java.util.Random;

public class MainClassFromLessonThree {
    public static void main(String[] args) {
        cutEvenNumFromList();
        findMinMaxMidlNumsFromList();

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
    private static void findMinMaxMidlNumsFromList() {

    }

}
