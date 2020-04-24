package imooc.heap;

public class MaxHeap {
    protected int[] data;

    //堆里有多少元素
    protected int count;

    //堆的容量
    protected int capacity;

    //因为0号位置不使用，所以capacity + 1
    public MaxHeap(int capacity) {
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(int[] arr){
        data = new int[arr.length + 1];
        capacity = arr.length + 1;
        for (int i = 0; i < arr.length; i++) {
            data[i + 1] = arr[i];
        }
        count = arr.length;
        //从第一个不是叶子节点的位置开始
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    //获取现存元素个数
    public int size(){
        return count;
    }


    //判断是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    //插入数据
    public void insert(int item){
        //判断容量知否超出
        if(count + 1 >= capacity){
            //开始扩容
            resize();
        }
        //先存储到末尾
        data[count + 1] = item;
        count++;
        //开始向上调堆
        shiftUp(count);
    }

    //取出数据
    public int extractMax(){
        if(count == 0) throw new RuntimeException("Heap is null");
        int ret = data[1];
        swap(1, count);
        count--;
        //开始向下调堆
        shiftDown(1);
        return ret;
    }

    //向下调堆
    private void shiftDown(int k) {
        while (2 * k <= count){
            int j = 2 * k; //在此轮循环中，data[k]和data[j]交换位置
            if(j + 1 <= count && data[j+1] > data[j]){
                j++;
            }
            if(data[k] >= data[j]){
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    //向上调堆
    private void shiftUp(int k) {
        while(k > 1 && data[k / 2] < data[k]){
            swap(k/2, k);
            k /= 2;
        }
    }

    //交换对应两个位置的值
    private void swap(int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    //扩充容量
    private void resize() {
        int[] newData = new int[capacity * 2];
        System.arraycopy(data, 0, newData, 0, count);
        data = newData;
        capacity *= 2;
    }
}