package haiweilai;

import java.util.Scanner;

public class SecondTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(handle(sc.nextLine()));
    }

    private static long handle(String nextLine) {
        if(nextLine.equals("0")) return 0L; // 0
        if(nextLine.equals("1")) return 0L; // 1
        if(nextLine.equals("10")) return 1L; // 2
        if(nextLine.equals("11")) return 1L; // 3
        if(nextLine.equals("100")) return 1L; // 4

        StringBuilder binStr = new StringBuilder("100");
        long count = 1L;
        while (true){
            if(nextLine.length() > binStr.length()){
                binStr.append("00");
                count++;
            }else if(nextLine.length() == binStr.length()){
                if(nextLine.equals(binStr.toString())){
                    return count;
                }else{
                    return count + 1;
                }
            }else {
                return count;
            }
        }
    }
}
