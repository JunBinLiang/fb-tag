class Solution {
    public int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        
        return sum;
    }
    
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        
        int slow = n, fast = n;
        while(true) {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            if(fast == 1) {
                return true;
            }
            fast = digitSquareSum(fast);
            if(fast == slow) {
                break;
            }
        }
        return false;
    }
}