package haiweilai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine());
        ArrayList<Long> ret = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            handle(sc.nextLine().split(" "), ret);
        }

        ret.forEach(System.out::println);
    }

    private static void handle(String[] s, List<Long> ret) {
        long lengthOne = Long.parseLong(s[0]);
        long lengthTwo = Long.parseLong(s[1]);
        long count = Integer.parseInt(s[2]);

        long x = count / 2;
        long tmpSite = lengthOne * x - lengthTwo * x;
        if(count % 2 != 0){
            //奇数
            tmpSite += lengthOne;
        }
        ret.add(tmpSite);
    }
}
