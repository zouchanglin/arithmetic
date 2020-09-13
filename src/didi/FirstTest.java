package didi;

import java.util.Scanner;

public class FirstTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        System.out.println(handle(sc.nextLine(), length));
    }

    private static String handle(String nextLine, int length) {
        if(nextLine.length() > 1000 || length > 100){
            return "";
        }
        if(length <= 0) return nextLine;
        if(length == 1) return reverse(nextLine);
        int tmp = 0;
        StringBuilder stringBuffer = new StringBuilder();
        int i;
        for (i = 0; i < nextLine.length();) {
            String newStr = reverse(nextLine.substring(tmp, i));
            stringBuffer.append(newStr);
            tmp = i;
            if(i + length > nextLine.length()){
                break;
            }
            i+=length;
        }
        if(i < nextLine.length()){
            stringBuffer.append(reverse(nextLine.substring(i)));
        }
        return stringBuffer.toString();
    }

    private static String reverse(String substring) {
        char[] chars = substring.toCharArray();
        char[] chars1 = new char[chars.length];
        int index = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            chars1[index++] = chars[i];
        }
        return new String(chars1);
    }
}
