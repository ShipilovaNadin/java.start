package lesson6;

import java.util.*;

public class MainClassLesson6 {
    public static void main(String[] args) {
        ex0(); // заполняем разные сеты данными и выводим на печать, чтобы посмотреть где сохраняется порядок
        int n = 1000;
        Integer[] arr = fillArray(n);
        System.out.println(Arrays.toString(arr));
        System.out.println(uniqueValuesInArray(arr));
    }


    private static void ex0() {
        List<String> data = List.of("Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять");
//        List<?> data = List.of(1, 2, 3, 4, 5, 6, 2, 1, 4, 1, 12, 1, 14, 5, 16, 17, 33, 45, 65, 22, 13);
        var dataNew = new ArrayList<>(data);
        Collections.reverse(dataNew);

        System.out.println(new HashSet<>(dataNew));
        System.out.println(new LinkedHashSet<>(dataNew));
        System.out.println(new TreeSet<>(dataNew));
    }

    private static Integer[] fillArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size]; // создаем массив из чисел размером на сайз
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // заполняем массив случайными числами от 0 до 999
        }
        return array;
    }

    // Создайте метод в который передайте заполненный массив и с помощью set вычислите процент уникальных чисел по формуле
// %  = кол-во уник.чисел *100/общее кол-во чисел в массиве.
    private static double uniqueValuesInArray(Integer[] array) {
        Set<Integer> set = new HashSet<>(Arrays.asList(array)); // создаем сет на остове массива
       // for (int i = 0; i < array.length; i++) {
         //   set.add(array[i]); // заполяем сет элементами из массива с помощью цикла
        //}
        System.out.println(set);
        return 1.0 * set.size() * 100 / array.length; // обязательно надо привести правую часть к дробному формату
    }
}

