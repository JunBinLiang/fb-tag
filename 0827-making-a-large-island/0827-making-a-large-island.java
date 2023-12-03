class Solution {
    int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        int id = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int count = dfs(grid, i, j, id);
                    map.put(id, count);
                    res = Math.max(res, count);
                    id++;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int count = 1;
                    for(int d[] : dir) {
                        int r = i + d[0], c = j + d[1];
                        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) {
                            continue;
                        }
                        if(!set.contains(grid[r][c])) {
                            set.add(grid[r][c]);
                            count += map.get(grid[r][c]);
                        }
                    }
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }
    
    public int dfs(int grid[][], int i, int j, int id) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == id) {
            return 0;
        }
        
        int res = 1;
        grid[i][j] = id;
        res += dfs(grid, i + 1, j, id);
        res += dfs(grid, i - 1, j, id);
        res += dfs(grid, i, j + 1, id);
        res += dfs(grid, i, j - 1, id);
        return res;
    }
}