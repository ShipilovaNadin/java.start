package lesson1.homework;

import java.util.Arrays;
import java.util.Random;

public class MainClassFromLessonOne {
    public static void main(String[] args) {
        MinAndMaxValueFromArr(30);
    }

    // 1. Задать одномерный массив и найти в нем минимальный и максимальный элементы
    private static void MinAndMaxValueFromArr(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int max = 0;
        int min = 0;

        for (int num : arr) {
            if(num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max + "- максимальное значение\n" + min + "- минимальное значение" );

    }

}


