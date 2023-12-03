class Solution {
    final int MARK = 2000000000;
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        
        int i = n - 1, j = m - 1;
        int index = n + m - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = MARK;
                j--;
            }
        }
        
        while(i >= 0) {
            nums1[index--] = nums1[i--];
        }
        
        while(j >= 0) {
            nums1[index--] = MARK;
            j--;
        }
        
        j = 0;
        for(i = 0; i < n + m; i++) {
            if(nums1[i] == MARK) {
                nums1[i] = nums2[j++];
            }
        }
    }
}