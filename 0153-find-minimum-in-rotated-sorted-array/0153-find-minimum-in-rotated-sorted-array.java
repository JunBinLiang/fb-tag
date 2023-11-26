class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(nums[n - 1] >= nums[0]) { //no rotation
            return nums[0];
        }
        
        int l = 0, r = n - 1;
        int index = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[0]) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return nums[index];
    }
}