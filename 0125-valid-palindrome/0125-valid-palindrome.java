class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        s = s.toUpperCase();
        while(l <= r) {
            if(!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if(!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if(s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        
        return true;
    }
}