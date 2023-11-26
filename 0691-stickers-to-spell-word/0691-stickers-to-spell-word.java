class Solution {
    public int minStickers(String[] stickers, String target) {
        int dp[] = new int[1 << target.length()];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int st = 0; st < dp.length; st++) {
            if(dp[st] == -1) continue;
            for(String s : stickers) {
                int cnt[] = new int[26];
                for(char c : s.toCharArray()) {
                    cnt[c - 'a']++;
                }
                int newst = st;
                for(int i = 0; i < target.length(); i++) {
                    if((st & (1 << i)) == 0) {
                        if(cnt[target.charAt(i) - 'a'] > 0) {
                            cnt[target.charAt(i) - 'a']--;
                            newst |= (1 << i);
                        }
                    }
                }
                
                if(dp[newst] == -1) {
                    dp[newst] = dp[st] + 1;
                } else {
                    dp[newst] = Math.min(dp[newst], dp[st] + 1);
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}