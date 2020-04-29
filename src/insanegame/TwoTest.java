package insanegame;

import java.util.Scanner;

/**
 *
 */
public class TwoTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        if(nextLine.length() == 1|| nextLine.length() == 0) {
            System.out.println(0);
            return;
        }
        int max = 0;
        for (int i = 0; i < nextLine.length(); i++) {
            max = Math.max(getLength(nextLine.substring(i)), max);
        }
        System.out.println(max);
    }

    private static int getLength(String s){
        if(s.length() == 1) {
            return 0;
        }
        int count = 0;
        boolean flag = false;
        char[] chars = s.toCharArray();
        for (char ch: chars){
            if(flag) count++;
            if(ch == '2'){
                flag = true;
            }
            if(ch == '5'){
                return count + 1;
            }
        }
        if(flag){
            return 0;
        }else{
            count += 2;
        }
        return count;
    }
}