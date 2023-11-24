class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }
        if(x < 0) {
            return -reverse(-x);
        }
        
        int res = 0;
        while(x > 0) {
            int d = x % 10;
            x /= 10;
            if(!ok(res, d)) return 0;
            res = res * 10 + d;
        }
        
        return res;
    }
    
    public boolean ok(int x, int d) {
        int limit = Integer.MAX_VALUE;
        for(int i = 0; i < 10; i++) {
            limit -= x;
            if(limit < 0) return false;
        }
        limit -= d;
        return limit >= 0;
    }
}