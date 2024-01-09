class Solution {
    boolean touch = false;
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    touch = false;
                    int count = dfs(grid, i, j);
                    if(!touch) {
                        res += count;
                    }
                }
            }
        }
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            touch = true;
            return 0;
        }
        
        if(grid[i][j] == 0) {
            return 0;
        }
        
        grid[i][j] = 0;
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
        
    }
}