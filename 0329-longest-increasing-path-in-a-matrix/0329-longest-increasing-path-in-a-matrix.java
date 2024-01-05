class Solution {
    public int longestIncreasingPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int res = 0;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[] in = new int[n * m];
        int[] depth = new int[n * m];
        List<Integer>[] g = new ArrayList[n * m];
        Arrays.setAll(g, e -> new ArrayList<>());
    
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int id1 = i * m + j;
                for(int[] d: dir) {
                    int r = i + d[0], c = j + d[1];
                    if(r < 0 || c < 0 || r >= n || c >= m || mat[i][j] >= mat[r][c]) continue;
                    g[id1].add(r * m + c);
                    in[r * m + c]++;
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n * m; i++) {
            if(in[i] == 0) {
                q.add(i);
                depth[i] = 1;
            }
        }
        
        while(q.size() > 0) {
            int u = q.poll();
            res = Math.max(res, depth[u]);
            for(int v : g[u]) {
                in[v]--;
                depth[v] = Math.max(depth[v], 1 + depth[u]);
                if(in[v] == 0) {
                    q.add(v);
                }
            }
        }
        return res;
    }
}