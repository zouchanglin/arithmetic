package imooc.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class SortTestHelper {
    /**
     * 生成长度为length且每个元素都在[rangeL, rangeR]之间的数组
     * @param length 数组长度
     * @param rangeL 左区间
     * @param rangeR 右区间
     * @return 生成的数组
     */
    public static int[] generate(int length, int rangeL, int rangeR){
        int[] retArray = new int[length];
        for (int i = 0; i < length; i++) {
            retArray[i] = ((int)(Math.random() * 100000) % (rangeR - rangeL)) + rangeL;
        }
        return retArray;
    }

    /**
     * 生成长度为length且每个元素都在[rangeL, rangeR]之间的接近有序的数组
     * @param length 数组长度
     * @param swapTimes 交换次数
     * @return 生成的数组
     */
    public static int[] generateNearlyOrderly(int length, int swapTimes){
        int[] retArray = new int[length];
        for (int i = 2; i < length; i++) {
            retArray[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int indexOne = (int)(Math.random() * 10000)%length;
            int indexTwo = (int)(Math.random() * 10000)%length;
            int tmp = retArray[indexOne];
            retArray[indexOne] = retArray[indexTwo];
            retArray[indexTwo] = tmp;
        }
        return retArray;
    }

    /**
     * 计算一段排序所用的时间
     * @param arr 排序数组
     * @param sortTestHelp 排序执行接口
     * @return 执行时间
     */
    public static double runningTime(int[] arr, SortTestHelp sortTestHelp){
        Instant start = Instant.now();
        sortTestHelp.execSort(arr);
        Instant end = Instant.now();
        double ret = Duration.between(start, end).toMillis() / 1000.0;
        System.out.println("执行时间：" + ret + "s");
        return ret;
    }
}
