package string;

import java.util.*;

//字符串数组的所有序列
public class AllSequence {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        LinkedList<Character> list = new LinkedList<>();
        for(char ch: arr) list.add(ch);
        List<String> retList = new ArrayList<>();

        getSequence(list, new StringBuilder(), retList);

        for(String str: retList) System.out.println(str);
    }

    private static void getSequence(List<Character> list, StringBuilder builder, List<String> retList){
        for (Character character: list){
            List<Character> other = list;
            builder.append(character);
            other.remove(character);

            if(other.size() == 0) {
                retList.add(builder.toString());
                return;
            }else{
                for(Character charOther: other){
                    builder.append(charOther);
                    other.remove(character);
                    getSequence(other, builder, retList);
                }
            }
        }
    }
}
