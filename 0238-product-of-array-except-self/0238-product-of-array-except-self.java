class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int res[] = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            left[i] = nums[i];
            if(i > 0) left[i] *= left[i - 1];
        }
        
        for(int i = nums.length - 1; i >= 0; i--) {
            right[i] = nums[i];
            if(i + 1 < nums.length) right[i] *= right[i + 1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            int p = 1;
            if(i > 0) p *= left[i - 1];
            if(i + 1 < nums.length) p *= right[i + 1];
            res[i] = p;
        }
        
        return res;
    }
}