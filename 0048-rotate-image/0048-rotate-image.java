class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //(r, c)  =>  (c, n - r - 1)
        //For each shift, a outter cycle is filled
        for(int r = 0; r < n / 2; r++) {
            for(int c = r; c < n - r - 1; c++) {
                int r1 = r, c1 = c;
                int r2 = c1, c2 = n - r1 - 1;
                int r3 = c2, c3 = n - r2 - 1;
                int r4 = c3, c4 = n - r3 - 1;
                int v1 = matrix[r1][c1];
                int v2 = matrix[r2][c2];
                int v3 = matrix[r3][c3];
                int v4 = matrix[r4][c4];
                matrix[r1][c1] = v4;
                matrix[r2][c2] = v1;
                matrix[r3][c3] = v2;
                matrix[r4][c4] = v3;
                
            }
        }
    }
}