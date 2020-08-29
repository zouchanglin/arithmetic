package meituan;

import java.util.*;

public class SecondTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> retList = new ArrayList<>();
        int account = Integer.parseInt(scanner.nextLine());
        int[][] data = new int[account][account];
        for (int i = 0; i < account; i++) {
            handle(scanner.nextLine(), data, i);
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i <= account; i++) {
            map.put(i, true);
        }

        for (int i = 0; i < account; i++) {
            for (int j = 0; j < account; j++) {
                int first = data[i][j];
                if(map.get(first)){
                    map.put(first, false);
                    retList.add(first);
                    break;
                }
            }
        }
        for(Integer ret: retList) System.out.print(ret + " ");
    }

    private static void handle(String nextLine, int[][] data, int line) {
        String[] s = nextLine.split(" ");
        for (int i = 0; i < s.length; i++) {
            data[line][i] = Integer.parseInt(s[i]);
        }
    }
}
