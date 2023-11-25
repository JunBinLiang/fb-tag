//12:20
class Solution {
    int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    PriorityQueue<int[]> pq;
    boolean vis[][];
    public int trapRainWater(int[][] a) {
        int n = a.length, m = a[0].length;
        vis = new boolean[n][m];
        pq = new PriorityQueue<>((x, y) -> {
            return x[2] - y[2];
        });
        
        for(int i = 0; i < n; i++) {
            add(a, i, 0);
            add(a, i, m - 1);
        }
        
        for(int i = 0; i < m; i++) {
            add(a, 0, i);
            add(a, n - 1, i);
        }
        
        int res = 0;
        while(pq.size() > 0) {
            int p[] = pq.poll();
            int r = p[0], c = p[1], h = p[2];
            for(int d[] : dir) {
                int newr = r + d[0], newc = c + d[1];
                if(newr < 0 || newr >= n || newc < 0 || newc >= m || vis[newr][newc]) continue;
                vis[newr][newc] = true;
                pq.add(new int[]{newr, newc, Math.max(h, a[newr][newc])});
                res += Math.max(0, h - a[newr][newc]);
            }
        }
        return res;
    }
    
    public void add(int nums[][], int r, int c) {
        if(r < 0 || c < 0 || r >= nums.length || c >= nums[0].length) return;
        if(vis[r][c]) return;
        vis[r][c] = true;
        pq.add(new int[]{r, c, nums[r][c]});
    }
}