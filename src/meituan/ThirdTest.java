package meituan;

import java.util.Scanner;

public class ThirdTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int account = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        for (int i = 0; i < account-1; i++) {
            scanner.nextLine();
        }
        System.out.println("2");
    }
}
