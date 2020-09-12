package wangyi;

import java.util.Scanner;

public class FirstTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println();
    }

    // 123
    // 322 -> 223
    // 没有则返回-1
    private static void handle(String str1, String str2, int length) {
        int one = Integer.parseInt(str1);
        int two = Integer.parseInt(str2);
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        String[] allStr = general(str2, length);

    }

    private static String[] general(String str, int length) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            // 找到最小的值
            for (int j = 0; j < str.length(); j++) {
                System.out.println(j);
            }
        }
        return null;
    }
}
