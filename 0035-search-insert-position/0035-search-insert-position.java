class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int p = nums.length;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(target <= nums[mid]) {
                p = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return p;
    }
}