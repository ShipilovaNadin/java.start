package lesson3;

import java.util.*;

public class MainClassLessonThree {

    public static void main(String[] args) {
        ex0();
        ex1();
        ex2();
    }

    private static void ex0() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});

        System.out.println(s1 == s5);
        System.out.println(s1.equals(s5));
    }

    private static void ex1() {
        List<Integer> list = new ArrayList<>();
//        "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto"
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(20)); //0 - 19
        }

        System.out.println(list);
        Collections.sort(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }

    public static void ex2() {
        String[] arrPlanet = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto"};
        Random random = new Random();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(arrPlanet[random.nextInt(9)]); //0-8
        }
        System.out.println(list);

        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                count++;
            } else {
                sb.append(list.get(i))
                        .append(": ")
                        .append(count)
                        .append("; ");
                count = 1;
            }
        }
        sb.append((list.get(list.size() - 1) + ": ")).append(count).append(".");
        System.out.println(sb);
    }

}
