class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        while(l < nums.length && nums[l] == nums[0]) {
            l++;
        }
        
        if(l >= nums.length) {
            return nums[0];
        }
        
        int r = nums.length - 1;
        int index = -1;
        int start = nums[l];
        if(start < nums[l - 1]) {
            return start;
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
            return nums[0];
        }
        
        return nums[index];
    }
}

//2 2 2 2 3 2 2 2 2 2
//2 2 2 2 1 2 2 2 2 2