class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            return x[0] - y[0];
        });
        
        int n = intervals.length;
        int res = 0, preMax = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            return x[0] - y[0];
        });
        
        for(int i = 0; i < n; i++) {
            while(pq.size() > 0 && pq.peek()[0] <= intervals[i][0]) {
                preMax = Math.max(preMax, pq.poll()[1]);
            }
            pq.add(new int[]{intervals[i][1], preMax + 1});
            res = Math.max(res, preMax + 1);
        }
        
        return n - res;
    }
}