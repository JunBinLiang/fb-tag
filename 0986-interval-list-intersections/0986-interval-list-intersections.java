class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> inter = new ArrayList<>();
        int n = a.length, m = b.length;
        int i = 0, j = 0;
        
        while(i < n && j < m) {
            int p[] = cross(a[i], b[j]);
            if(p != null) {
                inter.add(p);
            }
            
            if(a[i][1] <= b[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        int res[][] = new int[inter.size()][2];
        for(i = 0; i < inter.size(); i++) {
            res[i] = inter.get(i);
        }
        return res;
    }
    
    public int[] cross(int a[], int b[]) {
        if(b[0] > a[1] || b[1] < a[0]) return null;
        return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }
}