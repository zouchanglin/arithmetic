package imooc.sort;

import java.time.Duration;
import java.time.Instant;

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
            retArray[i] = ((int)(Math.random() * 100) % (rangeR - rangeL)) + rangeL;
        }
        return retArray;
    }

    /**
     * 计算一段排序所用的时间
     * @param name 排序的名称
     * @param sortTestHelp 排序执行接口
     * @return 执行时间
     */
    public static double runningTime(String name, SortTestHelp sortTestHelp){
        Instant start = Instant.now();
        sortTestHelp.execSort();
        Instant end = Instant.now();
        return Duration.between(start, end).toMillis() / 1000.0;
    }
}
