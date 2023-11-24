class Solution {
    public int lengthOfLongestSubstring(String s) {
        int cnt[] = new int[256];
        int j = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c]++;
            while(cnt[c] > 1) {
                cnt[s.charAt(j++)]--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}