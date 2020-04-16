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
        //开始调堆
        shiftUp(count);
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