package imooc.heap;

import imooc.sort.SortTestHelper;

public class HeapSort {
    public static void heapSort_03(int[] arr){
        //heapify
        for (int i = (arr.length - 1)/2; i >= 0; i--) {
            shiftDown(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    private static void shiftDown(int[] arr, int length, int k) {
        while (2 * k + 1 < length){
            int j = 2 * k + 1; //在此轮循环中，data[k]和data[j]交换位置
            if(j + 1 < length && arr[j+1] > arr[j]){
                j++;
            }
            if(arr[k] >= arr[j]){
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

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
        heapSort_03(testArray);
        for (int value : testArray) {
            System.out.print(value + " ");
        }
        System.out.println();

    }
}
