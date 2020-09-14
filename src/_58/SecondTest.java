package _58;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SecondTest {
    public static void main(String[] args) {
        int[] ints = {1, -1, 2, 5, 4};
        System.out.println(firstMissingPositive(ints));

//        HashSet<String> set = new HashSet<>();
//        for (int i = 0; i < ints.length; i++) {
//            String x = ints[i] + "";
//            System.out.println(x);
//            set.add(x);
//        }
//
//        System.out.println(set.add("-1"));
    }


    public static int firstMissingPositive (int[] nums) {
        Arrays.sort(nums);

        HashSet<String> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]+"");
        }

        for (int i = nums[0]; i < nums[nums.length - 1]; i++) {
            if(integers.add(i + "")){
                if(i > 0) return i;
            }
        }
        return 0;
    }
}
