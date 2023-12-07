class Solution {
    public int minSwaps(String s) {
        int res = 0;
        int open = 0;
        char a[] = s.toCharArray();
        
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(a[i] == '[') {
                stk.push(i);
            }
        }
                
        for(int i = 0; i < s.length(); i++) {
            if(a[i] == '[') {
                open++;
            } else {
                if(open > 0) open--;
                else {
                    int pos = stk.pop();
                    a[pos] = '[';
                    a[i] = ']';
                    open++;
                    res++;
                }
            }
        }
        
        return res;
    }
}