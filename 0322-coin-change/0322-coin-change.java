class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 0; i < dp.length; i++) {
            if(dp[i] == -1) continue;
            for(int x : coins) {
                if((i + 0l + x) < dp.length) {
                    if(dp[i + x] == -1) dp[i + x] = 1 + dp[i];
                    else {
                        dp[i + x] = Math.min(dp[i + x], 1 + dp[i]);
                    }
                }
            }
        }
        
        return dp[amount];
    }
}