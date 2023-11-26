class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(nums[n - 1] >= nums[0]) { //no rotation
            return binSearch(nums, 0, n - 1, target);
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
        
        int index1 = binSearch(nums, 0, index - 1, target);
        int index2 = binSearch(nums, index, n - 1, target);
        if(index1 != -1) return index1;
        if(index2 != -1) return index2;
        return -1;
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