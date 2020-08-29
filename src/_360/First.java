package _360;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        int account = 0;
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            if(handle(line)){
                account++;
            }
        }
        System.out.println(account);
    }

    private static boolean handle(String line) {
        if(line.length() >= 10) return false;
        if(line.length() == 0) return false;

        char[] chars = line.toCharArray();
        boolean flag = true;
        for(char ch: chars){
            if(!((ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A'))){
                flag = false;
            }
        }
        return flag;
    }
}
