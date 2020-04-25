package imooc.heap;

public class MaxIndexHeapOptimize {
    protected int[] data;
    protected int[] indexes;
    protected int[] reverse;

    //堆里有多少元素
    protected int count;

    //堆的容量
    protected int capacity;

    //因为0号位置不使用，所以capacity + 1
    public MaxIndexHeapOptimize(int capacity) {
        data = new int[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        count = 0;
        for (int i = 0; i <= capacity ; i++) {
            reverse[i] = 0;
        }
        this.capacity = capacity;
    }

    public MaxIndexHeapOptimize(int[] arr){
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

    //插入数据(传入的i对于用户而言，是从0开始索引的)
    public void insert(int i, int item){
        assert i + 1 >= 1;
        i++; //i += 1
        //判断容量知否超出
        if(count + 1 >= capacity){
            //开始扩容
            resize();
        }
        //先存储到末尾
        data[i] = item;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        //开始向上调堆
        shiftUp(count);
    }

    //取出数据的索引
    public int extractIndexMax(){
        if(count == 0) throw new RuntimeException("Heap is null");
        int ret = indexes[1] - 1;
        swapIndexes(1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        //开始向下调堆
        shiftDown(1);
        return ret;
    }

    //取出数据的索引
    public int extractMax(){
        if(count == 0) throw new RuntimeException("Heap is null");
        int ret = data[indexes[1]];
        swapIndexes(1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        //开始向下调堆
        shiftDown(1);
        return ret;
    }

    //根据索引获得元素
    public int getItemByIndex(int index){
        if(contain(index)){
            throw new RuntimeException("This index is not in heap!");
        }
        return data[index];
    }

    //根据索引修改某个元素
    public void changeItemOld(int index, int newValue){
        index++;
        data[index] = newValue;
        //找到indexes[j] = index; j表示data[index]在堆中的位置
        //找到shiftUp(j)，再shiftDown(j)
        for (int j = 1; j <= count; j++) {
            if(indexes[j] == index){
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    //根据索引修改某个元素
    public void changeItem(int index, int newValue){
        if(contain(index)){
            throw new RuntimeException("This index is not in heap!");
        }
        index++;
        data[index] = newValue;
        //找到indexes[j] = index; j表示data[index]在堆中的位置
        int j = reverse[index]; //O(1)的时间复杂度
        shiftUp(j);
        shiftDown(j);
    }

    private boolean contain(int index) {
        if(!(index + 1 >= 0 && index + 1 <= capacity)){
            throw new RuntimeException("This index is illegal");
        }
        return reverse[index + 1] == 0;
    }

    //向下调堆
    private void shiftDown(int k) {
        while (2 * k <= count){
            int j = 2 * k;
            if(j + 1 <= count && data[indexes[j+1]] > data[indexes[j]]){
                j++;
            }
            if(data[indexes[k]] >= data[indexes[j]]){
                break;
            }
            swapIndexes(k, j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }

    //向上调堆
    private void shiftUp(int k) {
        while(k > 1 && data[indexes[k / 2]] < data[indexes[k]]){
            swapIndexes(k/2, k);
            reverse[indexes[k/2]] = k/2;
            reverse[indexes[k]] = k;
            k /= 2;
        }
    }

    //交换对应两个位置的值(这是其实是交换索引的位置)
    private void swapIndexes(int i, int j){
        int tmp = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = tmp;
    }

    //扩充容量
    private void resize() {
        int[] newData = new int[capacity * 2];
        System.arraycopy(data, 0, newData, 0, count);
        data = newData;
        capacity *= 2;

        int[] newIndexes = new int[capacity * 2];
        System.arraycopy(indexes, 0, newIndexes, 0, count);
        indexes = newIndexes;
    }
}