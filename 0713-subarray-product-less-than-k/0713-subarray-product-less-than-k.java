class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) {
            return 0;
        }
        int p = 1, res = 0;
        for(int i = 0, j = 0; i < nums.length; i++) {
            p *= nums[i];
            while(j <= i && p >= k) {
                p /= nums[j++];
            }
            res += (i - j + 1);
        }
        return res;
    }
}