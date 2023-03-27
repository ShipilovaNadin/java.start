package lesson1.homework;

import java.util.Arrays;
import java.util.Random;

public class MainClassFromLessonOne {
    public static void main(String[] args) {
        //MinAndMaxValueFromArr(30);
        SortArray(10);
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

    //2. Дан массив nums = [3,2,2,3] и число val = 3.
//Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
//Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
// а остальные - равны ему.

    private static void SortArray(int size) {
        //int[] arr = new int[] {3, 2, 2, 3};
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 4);
        }
        System.out.println(Arrays.toString(arr));

        int val = 3;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                if(i != j) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}




