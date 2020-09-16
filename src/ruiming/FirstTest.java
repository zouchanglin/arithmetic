package ruiming;

import java.util.HashSet;

public class FirstTest {
    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring("abcdef"));
        System.out.println(lengthOfLongestSubstring("welcome To Streamax"));
        //lengthOfLongestSubstring("welcome To Streamax");
    }

    public static int lengthOfLongestSubstring (String str) {
        char[] chars = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int tmpIndex = 0;
        char tmpCh = '\u8982';
        for (char aChar : chars) {
            if (set.add(aChar)) {
                maxLength++;
            } else {
                tmpCh = aChar;
                break;
            }
        }
        if(maxLength == str.length()) return maxLength;

        for (int i = 0; i < chars.length; i++) {
            if(tmpCh == chars[i]){
                tmpIndex = i;
                break;
            }
        }

        if(tmpIndex != 0){
            return Math.max(maxLength, lengthOfLongestSubstring(str.substring(tmpIndex+1)));
        }
        return 0;
    }
}
