//8:23
class Solution {
    List<Integer>[] g;
    Map<Integer, Integer> map;
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for(int i = 1; i < parent.size(); i++) {
            g[parent.get(i)].add(i);
        }
        
        map = new HashMap<>();
        dfs(s, 0, 0);
        
        long res = 0;
        for(Integer key : map.keySet()) {
            int mask = key;
            long count = map.get(key);
            //res += (count * (count - 1) / 2);
            for(int i = 0; i < 26; i++) {
                int complement = mask ^ (1 << i);
                if(map.containsKey(complement)) {
                    res += count * map.get(complement);
                }
            }
        }

        res /= 2;
        for(Integer key : map.keySet()) {
            long count = map.get(key);
            res += (count * (count - 1) / 2);
        }
        
        return res;
    }
    
    public void dfs(String s, int u, int mask) {
        if(map.containsKey(mask)) {
            map.put(mask, 1 + map.get(mask));
        } else {
            map.put(mask, 1);
        }
        for(int nxt : g[u]) {
            int d = s.charAt(nxt) - 'a';
            dfs(s, nxt, mask ^ (1 << d));
        }
    }
}