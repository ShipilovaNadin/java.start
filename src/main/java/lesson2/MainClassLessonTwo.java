package lesson2;

public class MainClassLessonTwo {
    public static void main(String[] args) {
        //test();
        //returnLengthN();
        //countChar();
        testTime();

    }


    // задача называется сжатие строки - считаем количество букв и выводим букву и число повторов
    private static void countChar() {
        String str = "aaaabbcddr";
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                res.append(str.charAt(i));
                if (count > 1) {
                    res.append(count);
                }
                count = 0;
            }
            count++;
        }
        res.append(str.charAt(str.length() - 1)).append(count > 1 ? count : "");
        //res.append(count > 1 ? count : ""); тернальны оператор позволяет не писать 1 после символа если символ встречается 1 раз
        System.out.println(res); // результат a4b2cd2r
    }

    private static void returnLengthN() {
        int num = 7;
        String a = "a";
        String b = "B";
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                c.append(a);
            } else {
                c.append(b);
            }
        }
        System.out.println(c);
    }

    private static void test() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append("i: ").append(i).append(" -> ").append((char) i).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void testTime() {
        StringBuilder builder = new StringBuilder();
        String str = "";

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            str += Character.getName(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        begin = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(Character.getName(i));
        }
        end = System.currentTimeMillis();
        System.out.println(end - begin);

    }
}
