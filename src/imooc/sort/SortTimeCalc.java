package imooc.sort;

public class SortTimeCalc {
    public static void main(String[] args) {
        //int[] arr1 = SortTestHelper.generate(500000, 0, 300000);
        int[] arr1 = SortTestHelper.generateNearlyOrderly(10000000, 10);
        int[] arr2 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        long start1 = System.currentTimeMillis();
        InsertionSort.insertionSortOptimize(arr1);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        MergeSort.mergeSort(arr2);
        long end2 = System.currentTimeMillis();

        System.out.println((end1 - start1) / 1000.0 + "s");
        System.out.println((end2 - start2) / 1000.0 + "s");
    }
}
