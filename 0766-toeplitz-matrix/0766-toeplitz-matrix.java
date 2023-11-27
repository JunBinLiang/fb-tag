class Solution {
    public boolean isToeplitzMatrix(int[][] a) {
        int n = a.length, m = a[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i + 1 < n && j + 1 < m && a[i][j] != a[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}