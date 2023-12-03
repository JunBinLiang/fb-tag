class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stk = new Stack<>();
        int res = 0;
        
        for(int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int count = 0;
            while(stk.size() > 0 && h <= stk.peek()[0]) {
                int p[] = stk.pop();
                count += p[1];
                res = Math.max(res, count * p[0]);
            }
            stk.push(new int[]{h, count + 1});
        }
        
        int count = 0;
        while(stk.size() > 0) {
            int p[] = stk.pop();
            count += p[1];
            res = Math.max(res, count * p[0]);
        }
        
        return res;
    }
}