package imooc.heap;

public class MaxHeapTest {
    public static void main(String[] args) {
        PrintableMaxHeap maxHeap = new PrintableMaxHeap(10);
        for (int i = 0; i < 15; i++) {
            maxHeap.insert((int)(Math.random() * 100));
        }
        maxHeap.treePrint();

        int max = maxHeap.extractMax();
        System.out.println("Max is " + max);

        maxHeap.treePrint();
    }
}