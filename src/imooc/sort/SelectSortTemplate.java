package imooc.sort;

public class SelectSortTemplate<T extends Comparable<T>> {
    public void selectSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            T tmp;
            //寻找[i,n]之间的最小值
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j]) > 0){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}