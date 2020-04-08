package imooc.sort;

public class BubbleSort implements SortTestHelp{
    public static void main(String[] args) {
        //int[] arr = SortTestHelper.generate(10000, 0, 100000);
        int[] arr = SortTestHelper.generateNearlyOrderly(200000, 10);
        int[] arr1 = new int[arr.length];
        int[] arr2 = new int[arr.length];
        int[] arr3 = new int[arr.length];
        System.arraycopy(arr, 0, arr1, 0, arr.length);
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        System.arraycopy(arr, 0, arr3, 0, arr.length);
        long millis1 = System.currentTimeMillis();
        bubbleSort(arr1);
        long millis2 = System.currentTimeMillis();
        bubbleSortOptimize(arr2);
        long millis3 = System.currentTimeMillis();
        bubbleSortOptimizePlus(arr3);
        long millis4 = System.currentTimeMillis();
        System.out.println(millis2 - millis1);
        System.out.println(millis3 - millis2);
        System.out.println(millis4 - millis3);
    }
    
    @Override
    public void execSort(int[] arr) {
        bubbleSort(arr); //16.217s
//        bubbleSortOptimize(arr);
//        bubbleSortOptimizePlus(arr);
    }

    public static void bubbleSortOptimizePlus(int[] arr) {
        int pos; //用来记录最后一次交换的位置
        int k = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            pos = 0;
            //用来表示当前第i趟是否有交换，
            //如果有则要进行i+1趟，如果没有则说明当前数组已经完成排序
            boolean flag = true;
            for (int j = 0; j < k; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                    pos = j;
                }
            }
            if(flag) return;
            k = pos;
        }
    }

    public static void bubbleSortOptimize(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //用来表示当前第i趟是否有交换，
            //如果有则要进行i+1趟，如果没有则说明当前数组已经完成排序
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag) return;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
