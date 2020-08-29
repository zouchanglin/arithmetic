package douyu;

import java.util.HashSet;
import java.util.Set;

public class FirstTest {
    public static int[] remove(int[] arr){
        int index = 0;
        Set<Integer> arrSet = new HashSet<>();
        for (int value : arr) {
            arrSet.add(value);
        }
        int[] ints = new int[arrSet.size()];
        for (Integer i: arrSet){
            ints[index++] = i;
        }
        return ints;
    }
    public static void main(String[] args) {

    }
}
