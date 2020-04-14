package imooc.sort;

/**
 * 插入排序和选择排序的效率比较
 */
public class InsertCompareSelectSort {
    public static void main(String[] args) {
        //int[] arr_01 = SortTestHelper.generate(1000000, 0, 10000);
        int[] arr_01 = SortTestHelper.generateNearlyOrderly(100000000, 0);
        int[] arr_02 = new int[arr_01.length];
        System.arraycopy(arr_01, 0, arr_02, 0, arr_01.length);

        //未优化前
        //SortTestHelper.runningTime(arr_01, new SelectSort()); //4.934s
        //SortTestHelper.runningTime(arr_02, new InsertionSort()); //1.662s

        //优化后
        //SortTestHelper.runningTime(arr_01, new SelectSort()); //4.492s
//        for (int i: arr_01) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        //SortTestHelper.runningTime(arr_02, new InsertionSort()); //0.814s
    }
}