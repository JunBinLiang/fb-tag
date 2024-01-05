class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1, count = 1;
        for(int i = 1; i < nums.length; i++) {
            res = Math.max(res, count = (nums[i] > nums[i - 1]) ? count + 1 : 1);
        }
        return res;
    }
}