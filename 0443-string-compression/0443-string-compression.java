class Solution {
    public int compress(char[] chars) {
        int res = 0;
        for(int i = 0; i < chars.length; i++) {
            int j = i;
            while(j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            chars[res++] = chars[i];
            String cnt = (j - i) + "";
            if(j - i > 1) {
                for(char c : cnt.toCharArray()) {
                    chars[res++] = c;
                }
            }
            i = j - 1;
        }
        return res;
    }
}