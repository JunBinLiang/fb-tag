class Solution {
    final int INF = 1000000000;
    public int ladderLength(String s, String t, List<String> a) {
        if(s.equals(t)) {
            return 0;
        }
        int n = a.size();
        a.add(s);
        List<Integer> g[] = new ArrayList[n + 2];
        Arrays.setAll(g, e -> new ArrayList<>());
        
        for(int i = 0; i < a.size(); i++) {
            for(int j = i + 1; j < a.size(); j++) {
                if(connect(a.get(i), a.get(j))) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int d[] = new int[n + 2];
        Arrays.fill(d, INF);
        d[n] = 1;
        while(q.size() > 0) {
            int u = q.poll();
            for(int nxt : g[u]) {
                if(d[nxt] > d[u] + 1) {
                    d[nxt] = d[u] + 1;
                    q.add(nxt);
                }
            }
        }
        
        int res = INF;
        for(int i = 0; i < n; i++) {
            if(a.get(i).equals(t)) {
                res = Math.min(res, d[i]);
            }
        }
        return res == INF ? 0 : res;
    }
    
    public boolean connect(String s, String t) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                cnt ++;
            }
        }
        return cnt == 1;
    }
} 