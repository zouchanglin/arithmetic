package imooc.sort;

/**
 * 插入排序
 */
public class InsertionSort implements SortTestHelp{

    public static void insertionSortOptimize(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            int j; //用来保存元素e应该插入的位置
            for (j = i; j > 0 && arr[j-1] > e; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void insertionSort(int[] arr){
        int tmp;
        for (int i = 1; i < arr.length; i++) {
            //寻找元素arr[i]合适的插入位置,下面是更简洁的写法
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }
    }

    @Override
    public void execSort(int[] arr) {
        insertionSortOptimize(arr);
    }
}
