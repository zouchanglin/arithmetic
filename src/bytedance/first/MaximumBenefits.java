package bytedance.first;

public class MaximumBenefits {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int ret = calc(arr);
        System.out.println(ret);
    }

    private static int calc(int[] arr) {
        if(arr.length < 2) return 0;
        int maxBenefits = Integer.MIN_VALUE;
        int minPrice = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            int oldMaxBenefits = maxBenefits;
            maxBenefits = Math.abs(minPrice - arr[i]);
            maxBenefits = Math.max(maxBenefits, oldMaxBenefits);
        }
        return maxBenefits;
    }
}
