package binary_search;

import imooc.sort.SortTestHelper;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = SortTestHelper.generate(10, 0, 10);
        int ret = binarySearchTwo(arr, 3);
        if(ret != -1){
            System.out.println("arr[" + ret + "] = " + arr[ret]);
        }else{
            System.out.println("Not Exist");
        }
    }
    public boolean Find(int target, int [][] array) {
        if(array.length == 0) return false;
        for (int[] ints : array) {
            if (ints.length == 0) continue;
            if (ints[0] <= target && ints[ints.length - 1] >= target) {
                System.out.println(ints[0] + "..." + ints[ints.length - 1]);
                if (binary_search(ints, target) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private int binary_search(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (right - left)/2 + left;
            if(target > arr[mid]){
                left = mid + 1;
            }else if(target < arr[mid]){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    private static int binarySearchTwo(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (right - left)/2 + left;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}