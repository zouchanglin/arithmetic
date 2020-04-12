package imooc.sort;

import java.util.LinkedList;

/**
 * 自底向上的归并排序
 */
public class BottomUpMergeSort {
    public static void main(String[] args) {
        int[] arr = SortTestHelper.generate(100, 0, 100);
        long start = System.currentTimeMillis();
        bottomUpMergeSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        for(int i : arr) System.out.print(i + " ");
    }

    public static void bottomUpMergeSort(int[] arr){
        for (int size = 1; size <= arr.length; size += size) {
            //i + size < arr.length 防止越界
            for (int i = 0; i + size < arr.length; i += size + size) {
                int index = i + size + size - 1;
                //取i + size + size - 1 和 arr.length的最小值
                merge(arr, i, i + size - 1, index > arr.length ? arr.length - 1: index);
            }
        }
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
}
