class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l[] = new int[n];
        int r[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            l[i] = height[i];
            if(i > 0) l[i] = Math.max(l[i], l[i - 1]);
        }
        
        for(int i = n - 1; i >= 0; i--) {
            r[i] = height[i];
            if(i + 1 < n) r[i] = Math.max(r[i], r[i + 1]);
        }
        
        int res = 0;
        for(int i = 1; i < n - 1; i++) {
            int minH = Math.min(l[i - 1], r[i + 1]);
            res += Math.max((minH - height[i]), 0);
        }
        
        return res;
    }
}