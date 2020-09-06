package tencent_02;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class FirstTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lengthOne = Integer.parseInt(sc.nextLine());
        String[] arrOne = sc.nextLine().split(" ");

        int lengthTwo = Integer.parseInt(sc.nextLine());
        String[] arrTwo = sc.nextLine().split(" ");

        Set<String> tmp = new HashSet<>();
        List<String> ret = new ArrayList<>();
        for(String s: arrOne){
            tmp.add(s);
        }

        for(String s: arrTwo){
            if(!tmp.add(s)){
                ret.add(s);
            }
        }
        for(String s: ret) System.out.print(s + " ");
    }
}
