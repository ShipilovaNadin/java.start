package lesson1.homework;

import java.time.LocalTime;
import java.util.*;

public class MainClassFromLessonOne {
    public static void main(String[] args) {
        //minAndMaxValueFromArr(30);
        //sortArray(10);
        helloNameFromTime();
    }

    // 1. Задать одномерный массив и найти в нем минимальный и максимальный элементы
    private static void minAndMaxValueFromArr(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int max = 0;
        int min = 0;

        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max + "- максимальное значение\n" + min + "- минимальное значение");

    }

    //2. Дан массив nums = [3,2,2,3] и число val = 3.
//Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
//Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
// а остальные - равны ему.

    private static void sortArray(int size) {
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
                if (i != j) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //3*. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
    //"Доброе утро, <Имя>!", если время от 05:00 до 11:59
    //"Добрый день, <Имя>!", если время от 12:00 до 17:59;
    //"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
    //"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    private static void helloNameFromTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar);
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 5
                && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 12) {
            System.out.println("Доброе утро, " + name + "!");
        } else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 12
                && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 18) {
            System.out.println("Добрый день, " + name + "!");
        } else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 18
                && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 23) {
            System.out.println("Добрый вечер, " + name + "!");
        } else if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 23
                && Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 5) {
            System.out.println("Доброй ночи, " + name + "!");
        }
    }
}




