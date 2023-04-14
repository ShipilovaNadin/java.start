package lesson4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MainClassLessonFour {

    // Сортировка данных по возрасту от меньшего к большему
    public static void bubleSortAge(ArrayList<Integer> age, LinkedList<Integer> index) {
        ArrayList<Integer> ageTemp = new ArrayList<>(age); // создаем копию списка возраста

        boolean sort = true;
        int k = ageTemp.size(); // вводим индекс k чтобы можо было ограничить цикл. Так как сортировка должна идти до предпоследнего элемента
        while (sort) {
            sort = false; // выход из цикла
            for (int i = 0; i < k - 1; i++) {
                if (ageTemp.get(i) > ageTemp.get(i + 1)) { // сравниваем два рядом стоящих возраста
                    // сортируем возраст
                    int temp = ageTemp.get(i); // ввовим переменную для сохрания того возраста, который нужно переставить
                    ageTemp.set(i, ageTemp.get(i + 1)); // ставим с помощью set на место с индексом i значние i+1
                    ageTemp.set(i + 1, temp); // на место i+1 ставим зачение под индексом i
                    // если поменяли место возраста в списке, то по аналогии меняем место индекса
                    int temp2 = index.get(i);
                    index.set(i, index.get(i + 1));
                    index.set(i + 1, temp2);
                    sort = true; // если мы дошли до сюда то индекс k еще не кончился и выходить из цикла рано
                }
            }
            k--;
        }
        System.out.println(index);
    }

    public static void sortGender(ArrayList<Boolean> gender, LinkedList<Integer> index) {
        int cnt = index.size() - 1;
        while (cnt > - 1) {
            if (! gender.get(index.get(cnt))) { // берем значение из списка пола по номеру счетчика из списка индексов и проверяем не муж ли род. если не муж то заходим в иф
                int temp = index.get(cnt);
                index.remove(cnt);
                index.add(temp);
                cnt--;
            }
            cnt--;
        }

    }

    public static void main(String[] args) {
        // ввод с консоли в формате ФИО возраст и пол
        System.out.println("Введите через пробел: ФИО, возаст, пол. Для остановки ввода нажать: =");
        Scanner scanner = new Scanner(System.in);

        // создаем отдельные списки для сбора данных (для каждого типа данных свой список)
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> patronomic = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>(); // создаем список для индексов (один человек - один индекс)

        // ввыд из режима ввода по горячей кнопке
        boolean run = true;
        while (run) {
            String in = scanner.nextLine();
            if (in.equals("=")) {
                run = false;
            } else { // собираем данные в соответсвующие списки
                String[] data = in.split(" ");
                lastName.add(data[0]);
                firstName.add(data[1]);
                patronomic.add(data[2]);
                age.add(Integer.parseInt(data[3])); // т.к. список ао возрасту у нас цифровой то при добавлении данных мы их переводим в формат цифр
                gender.add(data[4].contains("м"));
                index.add(lastName.size()-1); // за каждую итерацию будет добавляться цифра. Первая итерация - 1, вторая -2. Получится список из индексов, количество которых будет совпадать с количеством фамилий

            }
        }

        // вывод списка ФИО в формате Иванов И. И.
        for (int i = 0; i < lastName.size(); i++) { // перебираем каждую фамилию в списке фамилий
            StringBuilder str = new StringBuilder();
            str.append(lastName.get(i)) // чтобы добавить фамилию используем get
                    .append(" ")
                    .append(firstName.get(i).charAt(0)) // добавляем первую букву имени
                    .append(". ")
                    .append(patronomic.get(i).charAt(0)) // первую букву отчества
                    .append(".");
            System.out.println(str);
        }
        System.out.println("*".repeat(10));
        // сортируем по возрасту и выводим отсортированный список
        bubleSortAge(age, index);

        for (Integer integer : index) {
            StringBuilder str = new StringBuilder();
            str.append(lastName.get(integer)).append(" ").append(firstName.get(integer).charAt(0)).append(". ").append(patronomic.get(integer).charAt(0)).append(".");
            System.out.println(str);
        }
        // сортируем по гендеру и выводим
        System.out.println("*".repeat(10));
        sortGender(gender, index);

        for (Integer integer : index) {
            StringBuilder str = new StringBuilder();
            str.append(lastName.get(integer))
                    .append(" ")
                    .append(firstName.get(integer).charAt(0))
                    .append(". ").append(patronomic.get(integer).charAt(0))
                    .append(". ")
                    .append(age.get(integer))
                    .append(", ")
                    .append(gender.get(integer));
            System.out.println(str);
        }
    }
}
