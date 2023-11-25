class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        for(int c = 'A'; c <= 'Z'; c++) {
            int non = 0;
            for(int i = 0, j = 0; i < s.length(); i++) {
                if(s.charAt(i) != c) non++;
                while(non > k) {
                    if(s.charAt(j) != c) non--;
                    j++;
                }
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}