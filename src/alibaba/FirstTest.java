package alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        scanner.nextLine();
        List<String> strArray = new ArrayList<>();
        while (nextInt-- > 0){
            strArray.add(scanner.nextLine());
        }
        List<String> addStringList = getAddStringList(strArray);
        StringBuffer stringBuffer = new StringBuffer();
        String ret = getMaxLongString(stringBuffer, addStringList);
        System.out.println(ret);
    }

    private static String getMaxLongString(StringBuffer stringBuffer, List<String> addStringList) {
        //起始字母最小 && 长度最长
        char start = 'a';
        while (addStringList.size() > 0){
            String first = getCharMinAndLengthMax(addStringList, start);
            stringBuffer.append(first);
            addStringList.remove(first);
            start++;
        }
        return stringBuffer.toString();
    }

    private static String getCharMinAndLengthMax(List<String> addStringList, char start) {
        String ret = "";
        return myGet(addStringList, ret, start);
    }

    private static String myGet(List<String> addStringList, String ret, char min){
        List<String> remove = new ArrayList<>();
        for (String str: addStringList){
            if(str.charAt(0) == min){
                if(str.length() > ret.length()){
                    ret = str;
                    remove.add(ret);
                }else{
                    remove.add(str);
                }
            }
        }
        addStringList.removeAll(remove);
        return ret;
    }

    private static List<String> getAddStringList(List<String> stringList){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str: stringList){
            if(isAddString(str)){
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static boolean isAddString(String string){
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            //a b c c d
            if(charArray[i] > charArray[i+1]){
                return false;
            }
        }
        return true;
    }
}
