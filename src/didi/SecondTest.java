package didi;

import java.util.*;

public class SecondTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> ret = new ArrayList<>();
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String[] oneLine = sc.nextLine().split(" ");
            int n = Integer.parseInt(oneLine[0]);
            int m = Integer.parseInt(oneLine[1]);
            int k = Integer.parseInt(oneLine[2]);
            String[] input = new String[m];
            for (int j = 0; j < m; j++) {
                input[j] = sc.nextLine();
            }
            if(handle(n, m, k, input)) {
                ret.add("Yes");
            }else {
                ret.add("No");
            }
        }

        ret.forEach(System.out::println);
    }

    private static boolean handle(int n, int m, int k, String[] input) {
        // 通不能连接到所有的桥
        //3    2
        if(n-1 > m) return false;
        Set<Character> set = new HashSet<>();
        for (String line: input){
            String[] args = line.split(" ");
            set.add(args[0].charAt(0));
            set.add(args[1].charAt(0));
        }
        for (int i = 1; i <= m; i++) {
            if(set.add(String.valueOf(i).charAt(0))){
                return false;
            }
        }

        int moneyCount = 0;
        for (String line: input){
            String[] args = line.split(" ");
            moneyCount += Integer.parseInt(args[2]);
        }

        return k * m >= moneyCount;
    }
}
