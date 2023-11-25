class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double res = -1000000000;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(i + 1 >= k) {
                res = Math.max(res, (sum + 0.0) / k);
                sum -= nums[i - k + 1];
            }
        }
        return res;
    }
}