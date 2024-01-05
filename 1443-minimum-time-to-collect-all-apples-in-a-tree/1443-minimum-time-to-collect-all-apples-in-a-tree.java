class Solution {
    List<Integer> graph[];
    public int minTime(int n, int[][] edges, List<Boolean> has) {
        graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for(int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        return dfs(has, -1, 0);
    }
    
    public int dfs(List<Boolean> has, int pa, int u) {
        int res = 0;
        for(int nxt : graph[u]) {
            if(nxt != pa) {
                int v = dfs(has, u, nxt);
                if(has.get(nxt) || v > 0) {
                    res += (v + 2);
                }
            }
        }
        return res;
    }
}