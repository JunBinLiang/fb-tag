class Solution {
    public String removeOuterParentheses(String s) {
        boolean[] remove = new boolean[s.length()];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stk.push(i);
            } else {
                int left = stk.pop();
                if(stk.size() == 0) {
                    remove[i] = remove[left] = true;
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!remove[i]) {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}