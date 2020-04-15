package imooc.sort;

public class QuickSortTopK {

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    // partition 过程, 和快排的partition一样
    private static int partition(int[] arr, int l, int r){
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l , (int)(Math.random()*(r-l+1))+l );

        int v = arr[l];
        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if( arr[i] < v){
                j ++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    // 求出nums[l...r]范围里第k小的数
    private static int solve(int[] nums, int l, int r, int k){
        if( l == r ) return nums[l];

        // partition之后, nums[p]的正确位置就在索引p上
        int p = partition(nums, l, r);

        // 如果 k == p, 直接返回nums[p]
        if( k == p )
            return nums[p];
        // 如果 k < p, 只需要在nums[l...p-1]中找第k小元素即可
        else if( k < p )
            return solve( nums, l, p-1, k);
        else// 如果 k > p, 则需要在nums[p+1...r]中找第k-p-1小元素
            // 注意: 由于我们传入__selection的依然是nums, 而不是nums[p+1...r],
            // 所以传入的最后一个参数依然是k, 而不是k-p-1
            return solve( nums, p+1, r, k );
    }

    // 寻找nums数组中第k小的元素
    // 注意: 在我们的算法中, k是从0开始索引的, 即最小的元素是第0小元素, 以此类推
    // 如果希望我们的算法中k的语意是从1开始的, 只需要在整个逻辑开始进行k--即可, 可以参考solve2
    public static int solve(int[] nums, int k) {
        assert nums != null && k >= 0 && k < nums.length;
        return solve(nums, 0, nums.length - 1, k);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 Selection
    public static void main(String[] args) {
        // 生成一个大小为n, 包含0...n-1这n个元素的随机数组arr
        int N = 10;
        int[] arr = SortTestHelper.generate(N, 0, N);
        for(int i: arr) System.out.print(i + " ");
        System.out.println();
        int solve = solve(arr, 3);
        System.out.println(solve);
    }
}
