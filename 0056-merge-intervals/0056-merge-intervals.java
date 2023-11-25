class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            return x[0] - y[0];
        });
        
        Stack<int[]> stk = new Stack<>();
        for(int i = 0; i < intervals.length; i++) {
            if(stk.size() == 0 || intervals[i][0] > stk.peek()[1]) {
                stk.push(intervals[i]);
            } else {
                stk.peek()[1] = Math.max(stk.peek()[1], intervals[i][1]);
            }
        }
        
        int res[][] = new int[stk.size()][2];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = stk.pop();
        }
        return res;
    }
}