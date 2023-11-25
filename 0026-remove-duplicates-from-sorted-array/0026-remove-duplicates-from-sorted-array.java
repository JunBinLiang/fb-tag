class Solution {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = i;
            while(j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            nums[res++] = nums[i];
            i = j - 1;
        }
        return res;
    }
}