package _58;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hang = Integer.parseInt(sc.nextLine());
        int lie = Integer.parseInt(sc.nextLine());
        String[] hangs = new String[hang];
        for (int i = 0; i < hang; i++) {
            String oneLine = sc.nextLine();
            hangs[i] = oneLine;
        }
        char[][] arr = createJZ(hang, lie, hangs);

        // 遍历产生的二维数组
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println(" ");
        }

        int ret = calcJZ(arr);
        System.out.println(ret);
    }

    private static int calcJZ(char[][] arr) {
        int ret = 0;
        HashSet<HashSet<String>> accountSet = new HashSet<>();
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                char point = arr[i][j];
                if(point == '0') continue;
                // 遍历HashSet中的点，确定此点不在之前的HashSet中
                String p1 = String.format("(%d,%d)", i-1, j);
                String p2 = String.format("(%d,%d)", i+1, j);
                String p3 = String.format("(%d,%d)", i, j+1);
                String p4 = String.format("(%d,%d)", i, j-1);
                Set<String> findRet = getPointInSet(String.format("(%d,%d)", i, j), accountSet);
                if(findRet == null){
                    // 开辟新的Set
                    ret++;
                    HashSet<String> hashSet = new HashSet<>(Arrays.asList(p1, p2, p3, p4));
                    hashSet.add(String.format("(%d,%d)", i, j));
                    accountSet.add(hashSet);
                }else{
                    findRet.addAll(Arrays.asList(p1, p2, p3, p4));
                }
            }
        }
        return ret;
    }

    private static Set<String> getPointInSet(String format, HashSet<HashSet<String>> accountSet) {
        for(Set<String> set: accountSet){
            if(set.contains(format)) return set;
        }
        return null;
    }

    private static char[][] createJZ(int hang, int lie, String[] hangs) {
        char[][] chars = new char[hang+2][lie+2];
        for (int i = 0; i < hang+2; i++) {
            for (int j = 0; j < lie+2; j++) {
                chars[i][j] = '0';
            }
        }
        for (int i = 1, j = 0; i < hang + 1; i++,j++) {
            String[] strings = hangs[j].split(" ");
            int index = 1;
            for(String s: strings){
                chars[i][index++] = s.charAt(0);
            }
        }
        return chars;
    }
}
