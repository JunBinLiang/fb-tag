class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> stk = new Stack<>();
        boolean good[] = new boolean[s.length()];
        Arrays.fill(good, true);
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stk.push(i);
            } else if(s.charAt(i) == ')') {
                if(stk.size() == 0) {
                    good[i] = false;  
                }  else {
                    stk.pop();
                }
            }
        }
        
        while(stk.size() > 0) good[stk.pop()] = false;
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(good[i]) {
                res.append(s.charAt(i));
            }
        }
        
        return res.toString();
    }
}