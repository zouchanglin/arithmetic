package imooc.sort;

/**
 * 插入排序
 */
public class InsertionSort{
    // 对整个arr数组使用InsertionSort排序
    public static void sort(int[] arr){

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1] > e; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(int[] arr, int l, int r){

        for( int i = l + 1 ; i <= r ; i ++ ){
            int e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1] > e; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
}
