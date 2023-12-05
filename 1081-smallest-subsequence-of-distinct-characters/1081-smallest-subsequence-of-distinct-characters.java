class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stk = new Stack<>();
        int count1[] = new int[26];
        int count2[] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count1[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            while(stk.size() > 0 && count2[c - 'a'] == 0 && c <= stk.peek() && count1[stk.peek() - 'a'] > 0) {
                count2[stk.pop() - 'a']--;
            }
            
            if(count2[c - 'a'] == 0) {
                count2[c - 'a']++;
                stk.push(c);
            }
            count1[c - 'a']--;
        }
        
        StringBuilder str = new StringBuilder();
        while(stk.size() > 0) str.append(stk.pop());
        return str.reverse().toString();
    }
}