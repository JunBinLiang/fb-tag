class Solution {
    public double myPow(double x, int n) {
        return mypow(x, n);
    }
    
    public double mypow(double x, long n) {
        if(n < 0) {
            return 1.0 / mypow(x, -n);
        }
        
        double res = 1.0;
        for(int i = 0; i < 32; i++) {
            if((n & (1l << i)) > 0) {
                res *= x;
            }
            x *= x;
        }
        return res;
    }
}