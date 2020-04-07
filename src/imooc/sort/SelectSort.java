package imooc.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 6, 10, 1, 4, 9, 7, 2};

        selectSort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] integers= IntStream.of(arr).boxed().toArray(Integer[]::new);
        new SelectSortTemplate<Integer>().selectSort(integers);
        for(Integer integer: integers) System.out.print(integer + " ");
        System.out.println();

        Student[] students = {
                new Student("BBB", 22),
                new Student("AAA", 26),
                new Student("DDD", 24),
                new Student("CCC", 20)};
        new SelectSortTemplate<Student>().selectSort(students);
        for (Student student: students){
            System.out.println(student);
        }
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp;
            //寻找[i,n]之间的最小值
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}