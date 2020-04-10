package imooc.sort;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = SortTestHelper.generate(300000, 0, 1000000);
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        long start = System.currentTimeMillis();
        InsertionSort.insertionSortOptimize(arr);
        long end = System.currentTimeMillis();

        shellSort(arr2);
        long end2 = System.currentTimeMillis();
        System.out.println("InsertionSort " + (end - start) + "ms");
        System.out.println("ShellSort " + (end2 - end) + "ms");
    }

    public static void shellSort(int[] arr){
        //每次都缩小增量
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int tmp = arr[j];
                //注意这里不是结构上的前一个元素，而是对于组而言的，所以减去step
                while(j - step >= 0 && arr[j - step] > tmp){
                    arr[j] = arr[j - step];
                    j = j - step;
                }
                arr[j] = tmp;
            }
        }
    }
}
