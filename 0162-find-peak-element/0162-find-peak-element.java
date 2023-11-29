class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        
        int n = nums.length;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            
            if(mid == n - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            
            if(mid == 0) {
                l = mid + 1;
                continue;
            }
            
            if(mid == n - 1) {
                r = mid - 1;
                continue;
            }
            
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            
            if(nums[mid] > nums[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return -1;
    }
}