class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        Set<String> visit = new HashSet<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            return x[n] - y[n];
        });
        
        int[] firstCol = new int[n + 1];
        for(int i = 0; i < n; i++) {
            firstCol[n] += mat[i][0];
        }
        pq.add(firstCol);
        visit.add(Arrays.toString(firstCol));
        int ith = 0;
        int res = 0;
        
        while(pq.size() > 0 && ith < k) {
            int sz = pq.size();
            for(int i = 0; i < sz && ith < k; i++) {
                sz--;
                ith++;
                int[] col = pq.poll();
                int curSum = col[n];
                res = curSum;
                for(int j = 0; j < n; j++) {
                    int c = col[j];
                    int cur = (c >= m) ? 1000000000 : mat[j][c];
                    int next = (c + 1 >= m) ? 1000000000 : mat[j][c + 1];
                    int newSum = curSum - cur + next;
                    int[] newcol = new int[n + 1];
                    for(int x = 0; x < newcol.length; x++) {
                        newcol[x] = col[x];
                    }
                    newcol[j]++;
                    newcol[n] = newSum;
                    String arrS = Arrays.toString(newcol);
                    if(!visit.contains(arrS)) {
                        pq.add(newcol);
                        visit.add(arrS);
                    }
                }
            }
        }
        return res;
    }
}
