package binary_search;

public class BinarySearch {
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
            int zh = (right - left)/2 + left;
            if(target > arr[zh]){
                left = zh+1;
            }else if(target < arr[zh]){
                right = zh-1;
            }else{
                return zh;
            }
        }
        return -1;
    }
}