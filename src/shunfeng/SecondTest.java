package shunfeng;

import java.util.Scanner;

public class SecondTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        handle(Long.parseLong(sc.nextLine()));
    }

    private static void handle(long parseInt) {
        int oneNumber = func(Long.toBinaryString(parseInt).toCharArray());
        long[] ret = find(parseInt, oneNumber);
        for(long i: ret) System.out.println(i);
    }
    // 1 -> 1
    private static long[] find(long parseInt, long oneNumber) {
        long[] retArr = new long[2];
        if(parseInt >= 2147483647L ){
            //retArr[0] = -1;
            retArr[1] = -1;
            //return retArr;
        }
        for (long i = parseInt - 1; i > Long.MIN_VALUE; i--) {
            if(i > 0) {
                if (func(Long.toBinaryString(i).toCharArray()) == oneNumber) {
                    retArr[1] = i;
                    break;
                }
            }else{
                if (func(Long.toBinaryString(-1 * i).toCharArray()) == oneNumber) {
                    retArr[1] = i;
                    break;
                }
            }
        }



        for (long i = parseInt + 1; i < Long.MAX_VALUE; i++) {
            if(i > 0) {
                if(func(Long.toBinaryString(i).toCharArray()) == oneNumber){
                    retArr[0] = i;
                    break;
                }
            }else{
                if(func(Long.toBinaryString(-1 * i).toCharArray()) == oneNumber){
                    retArr[0] = i;
                    break;
                }
            }
        }
        return retArr;
    }

    private static int func(char[] toCharArray) {
        int ret = 0;
        for(char c: toCharArray){
            if(c == '1') ret++;
        }
        return ret;
    }

    public static void main2(String[] args) {
        System.out.println(Long.toBinaryString(2147483647));
        //System.out.println(func(Long.toBinaryString(-1 * -1).toCharArray()));
    }
}
