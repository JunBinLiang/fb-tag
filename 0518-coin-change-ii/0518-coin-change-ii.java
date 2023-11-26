class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int x : coins) {
            for(int i = 0; i < dp.length; i++) {
                if(i >= x) {
                    dp[i] += dp[i - x];
                }
            }
        }
        return dp[amount];
    }
}