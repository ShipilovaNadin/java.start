package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainClassLessonOne {
    public static void main(String[] args) {
        // exOne();
        // exTwo();
        int n = getRandomArrMaxCount(1000);
        System.out.println(n);
    }


    //Дан массив двоичных чисел, например [1,1,0,1,1,1],
//вывести максимальное количество подряд идущих 1.

    private static void exTwo() {
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1};
        int k = 0;
        int max = 0;
        for (int num : arr) { // переберем все числа в массиве и все их будем называть num
            if (num == 1) {
                k++;
                if (k > max) {
                    max = k;
                }
            } else {
                k = 0;
            }
        }
        System.out.printf("Большая последовтельность насчитыает %s единиц.", max);
    }

    private static void exOne() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввведите имя: ");
        String name = scanner.nextLine();
        System.out.printf("Привет, %s!", name);
        scanner.close();
    }


    private static int getRandomArrMaxCount(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2); //0-1
//            arr[i] = random.nextInt(3, 10); //3-9
        }

/*        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            System.out.println(num);
        }*/

        int count = 0;
        int maxCount = 0;
        for (int num : arr) {
            if (num == 1) {
                count++;

                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
        return maxCount;
    }
}


