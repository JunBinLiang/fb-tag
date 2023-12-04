class Solution {
    List<Integer> g[];
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) {
            return Arrays.asList(0);
        }
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int in[] = new int[n];
        int d[] = new int[n];
        for(int e[] : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
            in[e[0]]++;
            in[e[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(in[i] == 1) {
                q.add(i);
                d[i] = 1;
            }
        }
        
        int max = 1;
        while(q.size() > 0) {
            int sz = q.size();
            for(int i = 0; i < sz; i++) {
                int u = q.poll();
                for(int nxt : g[u]) {
                    in[nxt]--;
                    if(in[nxt] == 1) {
                        q.add(nxt);
                        d[nxt] = d[u] + 1;
                        max = Math.max(max, d[nxt]);
                    }
                }
            }
        }
        
        int curH = n;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(d[i] == max) {
                int h = getH(-1, i);
                if(h < curH) {
                    curH = h;
                    res.add(i);
                } else if(h == curH) {
                    res.add(i);   
                }
            }
        }
        return res;
    }
    
    public int getH(int pa, int u) {
        int h = 1;
        for(int nxt : g[u]) {
            if(nxt != pa) {
                h = Math.max(h, 1 + getH(u, nxt));
            }
        }
        return h;
    }
}