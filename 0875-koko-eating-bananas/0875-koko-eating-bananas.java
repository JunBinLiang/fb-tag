class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = piles[0];
        int l = 1;
        for(int p : piles) {
            r = Math.max(r, p);
        }
        
        int res = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            long need = 0;
            for(int p : piles) {
                need += (p / mid);
                if(p % mid != 0) {
                    need++;
                }
            }
            if(need <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return res;
    }
}