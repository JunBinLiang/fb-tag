class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder();
        int len1 = strs[0].length();
        for(String s : strs) {
            len1 = Math.min(len1, s.length());
        }
        
        for(int i = 0; i < len1; i++) {
            boolean same = true;
            for(int j = 0; j < strs.length; j++) {
                if(strs[j].charAt(i) != strs[0].charAt(i)) {
                    same = false;
                }
            }
            if(!same) break;
            str.append(strs[0].charAt(i));
        }
        
        return str.toString();
    }
}