package ctrip;

import java.util.*;

public class SecondTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        handle(line);
    }

    private static void handle(String line) {
        List<char[]> list = new ArrayList<>();
        String[] tiers = line.split(" ");
        if(tiers.length == 0) return;
        if(tiers.length == 1) {
            char[] chars = tiers[0].toCharArray();
            for(char ch: chars){
                System.out.println(ch);
            }
            return;
        }
        for (String tier : tiers) {
            char[] points = tier.toCharArray();
            list.add(points);
        }

        Set<StringBuilder> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            char[] chars = list.get(i);
            if(i == 0){
                for(char ch: chars){
                    StringBuilder builder = new StringBuilder();
                    builder.append(ch);
                    set.add(builder);
                    break;
                }
            }else{
                if(chars.length == 1){
                    for(StringBuilder sb: set) sb.append(chars[0]);
                }else{
                    List<StringBuilder> tmp = new ArrayList<>();
                    for(StringBuilder sb: set){
                        for (char aChar : chars) tmp.add(new StringBuilder(sb).append(aChar));
                    }
                    set.addAll(tmp);
                }
            }
        }

        List<StringBuilder> tmpList = new ArrayList<>();
        for (StringBuilder str: set)
            if(str.length() == tiers.length) tmpList.add(str);


        String[] descStrArray = new String[tmpList.size()];
        int index = 0;
        for (StringBuilder str: tmpList) descStrArray[index++] = str.toString();

        Arrays.sort(descStrArray);
        for (String s : descStrArray) {
            if (isCircular(s)) {
                System.out.println(s + "--circular dependency");
            } else {
                System.out.println(s);
            }
        }
    }

    private static boolean isCircular(String str){
        HashSet<Character> set = new HashSet<>();
        char[] charArray = str.toCharArray();
        for(Character s: charArray){
            if(!set.add(s)){
                return true;
            }
        }
        return false;
    }
}
