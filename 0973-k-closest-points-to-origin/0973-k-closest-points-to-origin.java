class Solution {
    public int[][] kClosest(int[][] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        int res[][] = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }
    
    public void quickSort(int nums[][], int l, int r) {
        if(l >= r) {
            return;
        }
        int pivotD = (nums[l][0] * nums[l][0]) + (nums[l][1] * nums[l][1]);
        int index = l;
        for(int i = l; i <= r; i++) {
            int d = (nums[i][0] * nums[i][0]) + (nums[i][1] * nums[i][1]);
            if(d <= pivotD) {
                int t[] = nums[index];
                nums[index] = nums[i];
                nums[i] = t;
                index++;
            }
        }
        
        int t[] = nums[l];
        nums[l] = nums[index - 1];
        nums[index - 1] = t;
        
        quickSort(nums, l, index - 2);
        quickSort(nums, index, r);
    }
}