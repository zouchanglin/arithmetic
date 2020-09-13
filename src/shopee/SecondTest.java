package shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SecondTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        handle(scanner.nextLine());
    }

    private static void handle(String input) {
        char[] chars = input.toCharArray();
        int[] chi = convert(chars);
        //
        int max = Integer.MIN_VALUE;
        List<Integer> tmpList = new ArrayList<>();
        int i;
        int[] arr = null;
        for (i = chi.length - 2; i > 0 ; i--) {
            if(chi[i] > max){
                tmpList.add(chi[i]);
                max = Math.max(max, chi[i]);
                tmpList.add(chi[i]);
                arr = func(tmpList);
                Arrays.sort(arr);
                break;
            }
        }
        String s = input.substring(0, i);
        StringBuffer append = new StringBuffer(s).append(arr[arr.length - 2] + "");
        int[] ints = new int[arr.length - 1];
        System.arraycopy(arr, 0, ints, 0, arr.length - 1);
        Arrays.sort(ints);
        for (int j = ints.length - 1; j >= 0 ; j--) {
            append.append(ints[j] + "");
        }
        System.out.println(append.toString());

    }

    private static int[] func(List<Integer> tmpList) {
        int index = 0;
        int[] ret = new int[tmpList.size()];
        for(Integer i: tmpList){
            ret[index++] = i;
        }
        return ret;
    }

    private static int[] convert(char[] chars) {
        int[] ints = new int[chars.length];
        int index = 0;
        for(char c: chars){
            ints[index++] = Integer.parseInt(c + "");
        }
        return ints;
    }
}
