package imooc.heap;

import imooc.sort.SortTestHelper;

public class HeapSort {
    public static void heapSort_01(int[] arr){
        MaxHeap maxHeap = new MaxHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void heapSort_02(int[] arr){
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int[] testArray = SortTestHelper.generate(100, 0, 100);
        heapSort_02(testArray);
        for (int value : testArray) {
            System.out.print(value + " ");
        }
        System.out.println();

    }
}
