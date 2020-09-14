package shunfeng;

import java.util.Scanner;

public class FirstTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(handle(scanner.nextLine()));
    }

    private static int handle(String line) {
        int a = 0;
        int b = 0;
        int ret = 0;
        char[] array = line.toCharArray();
        for (int i = 0; i < line.length(); i++) {
            if(array[i] == '(') a++;
            else if(array[i] == ')') b++;

            if(b > a){
                a = 0;
                b = 0;
            }

            if(a == b){
                ret = Math.max(ret, 2 * a);
            }
        }

        a = 0;
        b = 0;
        int ret2 = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if(array[i] == ')') b++;
            else if(array[i] == '(') a++;

            if(b < a){
                a = 0;
                b = 0;
            }

            if(a == b){
                ret2 = Math.max(ret2, 2 * a);
            }
        }
        return Math.max(ret, ret2);
    }
}
