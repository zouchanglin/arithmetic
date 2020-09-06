package baidu;

import java.util.*;

public class FirstTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = Integer.parseInt(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        List<String> retList = new LinkedList<>();
        listAll(Arrays.asList(strings), "");
    }

    private static void listAll(List<String> list, String prefix){
        for (int i = 0; i < list.size(); ++i) {
            List<String> tmp = new LinkedList<>(list);
            listAll(tmp, prefix + tmp.remove(i));
        }
    }
}
