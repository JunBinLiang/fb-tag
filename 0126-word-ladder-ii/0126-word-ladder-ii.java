class Solution {
    final int INF = 1000000000;
    int len;
    int dest = -1;
    List<Integer> graph[];
    List<List<String>> ans;
    List<List<String>> dp[];
    boolean visit[];
    public List<List<String>> findLadders(String s, String t, List<String> a) {
        int n = a.size();
        a.add(s);
        List<Integer> g[] = new ArrayList[n + 1];
        List<int[]> con = new ArrayList<>();
        dp = new ArrayList[n + 1];
        ans = new ArrayList<>();
        graph = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        Arrays.setAll(graph, e -> new ArrayList<>());
        
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
                dest = i;
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
            
            int sz = curQ.size();
            for(int i = 0; i < sz; i++) {
                int u = curQ.poll();
                for(int nxt : g[u]) {
                    if(D1[nxt] == INF && D2[nxt] == INF) {
                        D1[nxt] = 1 + D1[u];
                        curQ.add(nxt);
                        if(curQ == frontQ) {
                            graph[u].add(nxt);
                        }
                        else {
                            graph[nxt].add(u);
                        }

                        continue;
                    }

                    if(D2[nxt] != INF) {
                        res = Math.min(res, D1[u] + D2[nxt]);
                        if(curQ == frontQ) con.add(new int[]{u, nxt});
                        else con.add(new int[]{nxt, u});
                    }

                    if(D1[nxt] == D1[u] + 1) {
                        if(curQ == frontQ) {
                            graph[u].add(nxt);
                        }
                        else {
                            graph[nxt].add(u);
                        }
                    }
                }
            }
            
            
            times++;
        }
        
        //System.out.println(frontQ);
        //System.out.println(endQ);
        
        if(res == INF) return ans;
        
        len = res;
        Set<String> set = new HashSet<>();
        for(int e[] : con) {
            if(d1[e[0]] + d2[e[1]] == res) {
                if(set.contains(e[0] + "," + e[1])) continue;
                set.add(e[0] + "," + e[1]);
                graph[e[0]].add(e[1]);
            }
        }
        
        dfs(a, n);
        return dp[n];
        
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
    
    public void dfs(List<String> a, int u) {
        if(dp[u] != null) {
            return;
        }
        
        dp[u] = new ArrayList<>();
        if(u == dest) {
            List<String> cur = new ArrayList<>();
            cur.add(a.get(u));
            dp[u].add(cur);
            return;
        }
        
        for(int nxt : graph[u]) {
            dfs(a, nxt);
            for(List<String> list : dp[nxt]) {
                if(list.size() > 0 && list.get(list.size() - 1).equals(a.get(dest))) {
                    List<String> newlist = new ArrayList<>();
                    newlist.add(a.get(u));
                    newlist.addAll(list);
                    dp[u].add(newlist);
                }
                
            }
        }
    }
}