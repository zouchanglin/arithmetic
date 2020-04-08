package imooc.sort;

public class SelectSort implements SortTestHelp{
    private static void selectSort(int[] arr) {
        int tmp;
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            //寻找[i,n]之间的最小值
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    @Override
    public void execSort(int[] arr) {
        selectSort(arr);
    }
}