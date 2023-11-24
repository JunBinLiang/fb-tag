class Solution {
    final int INF = 1000000000;
    public int ladderLength(String s, String t, List<String> a) {
        if(s.equals(t)) {
            return 0;
        }
        int n = a.size();
        a.add(s);
        List<Integer> g[] = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        
        for(int i = 0; i < a.size(); i++) {
            for(int j = i + 1; j < a.size(); j++) {
                if(connect(a.get(i), a.get(j))) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }
        
        Queue<Integer> frontQ = new LinkedList<>();
        Queue<Integer> endQ = new LinkedList<>();
        int d1[] = new int[n + 1]; int d2[] = new int[n + 1];
        Arrays.fill(d1, INF); Arrays.fill(d2, INF);
        d1[n] = 1;
        frontQ.add(n);
        for(int i = 0; i < n; i++) {
            if(a.get(i).equals(t)) {
                endQ.add(i);
                d2[i] = 1;
                break;
            }
        }
        
        int times = 1;
        int res = INF;
        while(frontQ.size() > 0 && endQ.size() > 0) {
            Queue<Integer> curQ;
            int D1[], D2[];
            if(times % 2 == 1) {
                curQ = frontQ;
                D1 = d1;
                D2 = d2;
            } else {
                curQ = endQ;
                D1 = d2;
                D2 = d1;
            }
            
            int u = curQ.poll();
            for(int nxt : g[u]) {
                if(D1[nxt] == INF && D2[nxt] == INF) {
                    D1[nxt] = 1 + D1[u];
                    curQ.add(nxt);
                    continue;
                }
                
                if(D2[nxt] != INF) {
                    res = Math.min(res, D1[u] + D2[nxt]);
                }
                
            }
            times++;
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