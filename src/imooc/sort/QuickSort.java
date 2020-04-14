package imooc.sort;

public class QuickSort {
    public static void main(String[] args) {
        //int[] arr1 = SortTestHelper.generate(5000000, 0, 1000000);
        //int[] arr1 = SortTestHelper.generateNearlyOrderly(100000, 10);
        int[] arr1 = SortTestHelper.generate(1000000, 0, 20);
        int[] arr2 = new int[arr1.length];
        int[] arr3 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);

        long start = System.currentTimeMillis();
        quickSort(arr1);
        long end = System.currentTimeMillis();

        System.out.println("QuickSort：" + (start- end)/1000.0 + "s");
    }

    public static void quickSort(int[] arr){
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r){
        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1 );
        sort(arr, p+1, r);
    }

    /**
     * 将arr[start...end]部分进行partition操作
     * 返回p,使得arr[start...p-1] < arr[p]; arr[p+1...end] > arr[p]
     */
    private static int partition(int[] arr, int l, int r){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );
        int v = arr[l];
        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if(arr[i] < v){
                j++;
                swap(arr, j, i);
            }
        swap(arr, l, j);
        return j;
    }


    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
