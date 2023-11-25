class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while(stk.size() > 0 && c < stk.peek() && k > 0) {
                k--;
                stk.pop();
            }
            stk.push(c);
        }
        
        while(stk.size() > 0 && k > 0) {
            stk.pop();
            k--;
        }
        
        List<Character> list = new ArrayList<>();
        while(stk.size() > 0) {
            list.add(stk.pop());
        }
        
        Collections.reverse(list);
        StringBuilder str = new StringBuilder();
        boolean leadZero = true;
        
        for(int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            if(c == '0' && leadZero) continue;
            else {
                leadZero = false;
                str.append(c);
            }
        }
        
        if(str.length() == 0) return "0";
        return str.toString();
    }
}