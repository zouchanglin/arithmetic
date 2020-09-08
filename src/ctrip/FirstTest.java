package ctrip;

import java.util.Arrays;
import java.util.Scanner;

public class FirstTest {
    private static String key;
    private static String newKey;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        key = scanner.nextLine();
        String line = scanner.nextLine();
        newKey = scanner.nextLine();

        String handle = handle(line);
        System.out.println(handle);
    }

    private static String handle(String line) {
        StringBuilder sb = new StringBuilder();
        line = line + ",";
        String[] lines = line.split(",");
        for (int k = 0; k < lines.length; k++) {
            String[] worlds = lines[k].split(" ");
            for (int i = 0; i < worlds.length; i++) {
                if(isKey(worlds[i]))
                    sb.append(newKey);
                else
                    sb.append(worlds[i]);
                if(i != worlds.length - 1) sb.append(" ");
            }
            if(k != lines.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    private static boolean isKey(String world) {
        if(world.length() != key.length()) return false;
        boolean flag = true;
        char[] wordArr = world.toCharArray();
        char[] keyArr = key.toCharArray();

        Arrays.sort(wordArr);
        Arrays.sort(keyArr);
        for (int i = 0; i < keyArr.length; i++) {
            if (wordArr[i] != keyArr[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
