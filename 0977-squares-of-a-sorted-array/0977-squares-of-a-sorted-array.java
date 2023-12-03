class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int pIndex = n;
        int nIndex = n - 1;
        for(int i = 0; i < n; i++) {
            if(nums[i] >= 0) {
                pIndex = i;
                nIndex = i - 1;
                break;
            }
        }
        
        int j = 0;
        while(pIndex < n && nIndex >= 0) {
            if(nums[pIndex] * nums[pIndex] < nums[nIndex] * nums[nIndex]) {
                res[j++] = nums[pIndex] * nums[pIndex];
                pIndex++;
            } else {
                res[j++] = nums[nIndex] * nums[nIndex];
                nIndex--;
            }
        }
        
        while(pIndex < n) {
            res[j++] = nums[pIndex] * nums[pIndex];
            pIndex++;
        }
        
        while(nIndex >= 0) {
            res[j++] = nums[nIndex] * nums[nIndex];
            nIndex--;
        }
        
        return res;
    }
}