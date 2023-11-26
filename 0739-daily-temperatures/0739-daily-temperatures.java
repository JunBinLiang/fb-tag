class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stk = new Stack<>();
        int res[] = new int[n];
        for(int i = 0; i < n; i++) {
            while(stk.size() > 0 && temperatures[i] > temperatures[stk.peek()]) {
                res[stk.peek()] = i - stk.pop();
            }
            stk.push(i);
        }
        return res;
    }
}