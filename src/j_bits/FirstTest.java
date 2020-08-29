package j_bits;

import java.util.Scanner;

public class FirstTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strings = line.split(" ");
        String s = strings[0];
        int ret = 0;
        int startIndex = 0;
        int endIndex = 0;
        char s1 = strings[1].toCharArray()[0];
        char s2 = strings[2].toCharArray()[0];
        char[] charArray = s.toCharArray();
        boolean flag = true;
        int exitsFlag = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(fun(charArray[i], s1) && flag){
                startIndex = i;
                flag = false;
                exitsFlag++;
            }
            if(fun(charArray[i], s2)){
                endIndex = i;
                int tmp = Math.abs(endIndex - startIndex);
                ret = Math.max(ret, tmp);
                exitsFlag++;
            }
        }

        if(exitsFlag != 2){
            System.out.println(-1);
            return;
        }

        flag = true;
        int retOther = 0;
        startIndex = 0;
        endIndex = 0;
        exitsFlag = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(fun(charArray[i], s2) && flag){
                startIndex = i;
                flag = false;
                exitsFlag++;
            }
            if(fun(charArray[i], s1)){
                endIndex = i;
                int tmp = Math.abs(endIndex - startIndex);
                retOther = Math.max(retOther, tmp);
                exitsFlag++;
            }
        }

        if(exitsFlag != 2){
            System.out.println(-1);
            return;
        }
        ret = Math.max(ret, retOther);
        System.out.println(ret);
    }

    private static boolean fun(char c, char s1) {
        int x = 'a' - 'A';
        return c + x == s1 || c - x == s1;
    }
}
