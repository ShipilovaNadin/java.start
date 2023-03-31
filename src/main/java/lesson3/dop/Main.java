package lesson3.dop;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Первый");
        list.add("Второй");
        list.add("Третий");
        list.add("Четвертый");
        list.add("Пятый");
        list.add("Щ");
        list.add("Се");
        list.add("Вос");
        list.add("Девят");
        System.out.println(list);
        for (String el : list) {
            System.out.println(el);
        }
        System.out.println("*".repeat(10));


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("*".repeat(10));


        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String el = iterator.next();
            System.out.println(el);
        }

        ArrayList<String> list2 = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            list2.add(list.get(i));
        }
        list2.add("новое");
        list2.add("новое2");
        list2.add("что-нибудь");
        System.out.println(list2);

        ArrayList<String> list3 = new ArrayList<>();
        iterator = list.listIterator(list.size());

/* while (iterator.hasPrevious()){
list3.add(iterator.previous());
}
System.out.println(list3);*/

        list.forEach(n -> list3.add(0, n));
        System.out.println(list3);

        int sum = 0;
        iterator = list.listIterator();
        while (iterator.hasNext()) {
            String el = iterator.next();
            sum += el.length();
        }
        int average = sum / list.size();
        System.out.println(average);
        iterator = list.listIterator();
        while (iterator.hasNext()) {
            String el = iterator.next();
            if (el.length() < average) {
                iterator.remove();
            }
        }
        System.out.println(list);

        list2.removeAll(list);

        System.out.println(list2);
    }
}