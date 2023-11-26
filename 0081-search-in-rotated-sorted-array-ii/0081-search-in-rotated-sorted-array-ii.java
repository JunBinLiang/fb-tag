class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        while(l < nums.length && nums[l] == nums[0]) {
            l++;
        }
        
        if(l >= nums.length) {
            return nums[0] == target;
        }
        
        int r = nums.length - 1;
        int index = -1;
        int start = nums[l];
        if(start < nums[l - 1]) {
            int index1 = binSearch(nums, 0, l - 1, target);
            int index2 = binSearch(nums, l, nums.length - 1, target);
            if(index1 != -1) return true;
            if(index2 != -1) return true;
            return false;
        }
        
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < start) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        if(index == -1) {
            return binSearch(nums, 0, nums.length - 1, target) != -1;
        }
        
        int index1 = binSearch(nums, 0, index - 1, target);
        int index2 = binSearch(nums, index, nums.length - 1, target);
        if(index1 != -1) return true;
        if(index2 != -1) return true;
        return false;
        
    }
    
    public int binSearch(int nums[], int l, int r, int target) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
