package imooc.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = SortTestHelper.generate(90000000, 0, 8000000);
        int[] arr = SortTestHelper.generate(90000000, 0, 8000000);
        long start = System.currentTimeMillis();
        mergeSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void mergeSort(int[] arr){
        mergeChild(arr, 0, arr.length-1);
    }

    //使用递归进行归并排序，对arr[start, end]的范围进行排序
    private static void mergeChild(int[] arr, int start, int end){
        //代表我们处理的数据集为空
        //if(start >= end) return;
        if(end - start <= 5){
            insertionSort(arr, start, end);
            return;
        }

        int mid = (end - start) / 2 + start;
        mergeChild(arr, start, mid);
        mergeChild(arr, mid + 1, end);
        //优化点：优化掉不必要的merge操作
        if(arr[mid] > arr[mid] + 1)
            merge(arr, start, mid, end);
    }

    //将arr[start ... mid]和arr[mid+1 ... end] 两部分进行归并
    private static void merge(int[] arr, int start, int mid, int end) {
        //创建临时数组
        int[] aux = new int[end - start + 1];
        System.arraycopy(arr, start, aux, 0, end - start + 1);
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end ; k++) {
            //左部分的已经归并完毕
            if(i > mid){
                arr[k] = aux[j - start];
                j++;
            //右部分的已经归并完毕
            }else if(j > end){
                arr[k] = aux[i - start];
                i++;
            }else if(aux[i - start] < aux[j - start]){
                arr[k] = aux[i - start];
                i++;
            }else{
                arr[k] = aux[j - start];
                j++;
            }
        }
    }

    //优化点：在数据规模小的时候直接使用插入排序（对arr[start, end]范围的插入数据排序）
    private static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int e = arr[i];
            int j;
            for (j = i; j > start && arr[j - 1] < e; j--) {
                arr[i] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
