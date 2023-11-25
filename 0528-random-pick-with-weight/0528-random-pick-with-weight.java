class Solution {
    int p[];
    Random random;
    public Solution(int[] w) {
        this.random = new Random();
        p = new int[w.length];
        for(int i = 0; i < w.length; i++) {
            p[i] = w[i];
            if(i > 0) p[i] += p[i - 1];
        }
    }
    
    public int pickIndex() {
        int idx = random.nextInt(p[p.length - 1]) + 1;
        int l = 0, r = p.length - 1;
        int res = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(idx <= p[mid]) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */