package meituan;

import java.util.Scanner;

public class FirstTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        int oneIndex = 0;
        int twoIndex = 0;
        int MT = 0;
        boolean flagM = true;
        boolean flagT = true;
        int startIndex = 0;
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if('M' == charArray[i] && flagM){
                MT++;
                flagM = false;
            }
            if('T' == charArray[i] && MT == 1 && flagT){
                MT++;
                flagT = false;
                startIndex = i + 1;
            }
        }
        if(MT == 2){
            oneIndex = startIndex;
        }

        //MMATSATMMT
        //TMMTASTAMM
        String line2 = new StringBuffer(line).reverse().toString();
        MT = 0;
        flagM = true;
        flagT = true;
        startIndex = 0;
        charArray = line2.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if('T' == charArray[i] && flagT){
                MT++;
                flagT = false;
            }
            if('M' == charArray[i] && MT == 1 && flagM){
                MT++;
                flagM = false;
                startIndex = i;
            }
        }
        if(MT == 2){
            twoIndex = line2.length() - startIndex - 1;
        }
        System.out.println(line.substring(oneIndex, twoIndex));
    }
}
