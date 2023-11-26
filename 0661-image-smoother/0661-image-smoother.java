class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int res[][] = new int[n][m];
        int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int sum = img[i][j], cnt = 1;
                for(int d[] : dir) {
                    int r = i + d[0], c = j + d[1];
                    if(r < 0 || r >= n || c < 0 || c >= m) {
                        continue;
                    }
                    sum += img[r][c];
                    cnt++;
                }
                res[i][j] = sum / cnt;
            }
        }
        return res;
    }
}