package replace_space;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toString().toCharArray();
        for (char c : arr) {
            if (c != ' ') {
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}