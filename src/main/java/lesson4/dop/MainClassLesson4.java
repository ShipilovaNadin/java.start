package lesson4.dop;

import java.util.*;

public class MainClassLesson4 {
    public static void main(String[] args) {
        // ex0(); // метод сверяющей время добавления 100_000 элементов в линкет лист и эррей лист
        ex1(); //
    }

    private static void ex0() {
        final int SIZE = 100_000;
        Random random = new Random();

        // сверяет добавление пустых значений

        List<Random> linkedList = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(null);
        }
        System.out.println("LinkedList: " + (System.currentTimeMillis() - start));

        List<Random> arrayList = new ArrayList<>(SIZE);
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(null);
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));

        // сверяет добавление на рандомную позицию объекта рэндом
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(random.nextInt(SIZE), new Random());
        }
        System.out.println("LinkedList: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(random.nextInt(SIZE), new Random());
        }
        System.out.println("ArrayList: " + (System.currentTimeMillis() - start));
    }

    private static void ex1() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> wordsList = new LinkedList<>();
        Collections.addAll(wordsList, "apple", "orange", "banana", "tomato", "strawberry", "melon");


        while (true) {
            System.out.println();
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();

            if (inputString.trim().length() == 0) { // метод трим удаляет все пробелы и знаки переноса в начале и конце строки, после чего мы проверяем а остались ли еще какие то символы
//            if (inputString.isBlank()) { // отдельный метода в джаве с 10 версии делает тоже самое
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("каша не вари")) { // при вводе этой фрзы завершится работа цикла - брейк!
                break;
            }
            if (inputString.equalsIgnoreCase("print~all")) { // метод иквалсИгнорКейс проверет на равенство строки не учитывая регистры
                printAllNotNullValues(wordsList);
                continue;
            }
            if (!inputString.contains("~")) {
                System.out.println("Строка не содержит тильду");
                continue;
            }

            String[] parts = inputString.split("\\~");

            if (parts.length != 2) {
                System.out.println("Ошибка ввода шаблона. Должно быть \"word~num\". Пример: apple~6");
                continue;
            }

            String word = parts[0];
            int num = 0;

            try {
                num = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Выражение не содержит числа");
                continue;
            }

            if (num < 1) {
                System.out.println("Введите num более 1");
                continue;
            }

            if (word.equalsIgnoreCase("print")) {
                if (!isNumberInRange(num, wordsList.size()) || valueIsNull(wordsList, num)) { // проверяем попал ли номер который мы хотим распечтать в диапазон листа или не пустое ли под этим номером значение
                    System.out.println("Указанного значения не существует");
                } else {
                    System.out.printf("Под номером %d находится слово: %s%n", num, wordsList.get(num - 1));
                    wordsList.remove(num - 1);
                }
            } else if (isNumberInRange(num, wordsList.size())) {
                String oldWord = wordsList.get(num - 1);

                if (valueIsNull(wordsList, num)) {
                    printAddMessage(word, num);
                } else {
                    printSetMessage(word, num, oldWord);
                }
                wordsList.set(num - 1, word);
            } else {
                int nullCount = num - wordsList.size() - 1;
                addNulls(wordsList, nullCount);
                wordsList.add(word);
                printAddMessage(word, num);
            }
        }
    }

    private static void addNulls(LinkedList<String> wordsList, int count) {
        for (int i = 0; i < count; i++) {
            wordsList.add(null);
        }
    }

    private static void printAllNotNullValues(LinkedList<String> wordsList) {
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i) != null) {
                System.out.printf("%d) %s%n", i + 1, wordsList.get(i));
            }
        }
    }

    private static void printSetMessage(String word, int num, String oldWord) {
        System.out.printf("Слово %s заменило на позиции %d слово %s%n", word, num, oldWord);
    }

    private static void printAddMessage(String word, int num) {
        System.out.printf("Слово %s добавлено на позицию %d%n", word, num);
    }

    private static boolean valueIsNull(LinkedList<String> wordsList, int num) {
        return wordsList.get(num - 1) == null;
    }

    private static boolean isNumberInRange(int num, int size) {
        return num >= 1 & num <= size;
    }
}

