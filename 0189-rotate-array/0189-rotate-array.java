class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if(k <= n - k) {
            reverse(nums, 0, n - k - 1);
            //System.out.println(Arrays.toString(nums));
            for(int i = 0; i < k; i++) {
                int t = nums[i];
                nums[i] = nums[n - k + i];
                nums[n - k + i] = t;
            }
            reverse(nums, n - k , n - 1);
            reverse(nums, k, n - k - 1);
        } else {
            k = n - k;
            reverse(nums, n - k, n - 1);
            reverse(nums, k, n - k - 1);
            for(int i = 0; i < k; i++) {
                int t = nums[i];
                nums[i] = nums[n - k + i];
                nums[n - k + i] = t;
            }
            reverse(nums, 0, n - k - 1);
        }
    }
    
    public void reverse(int nums[], int l, int r) {
        while(l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}