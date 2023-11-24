class Solution {
    final int INF = 1000000000;
    public int ladderLength(String s, String t, List<String> a) {
        if(s.equals(t)) {
            return 0;
        }
        
        int n = a.size();
        a.add(s);
        Set<Integer> frontSet = new HashSet<>();
        Set<Integer> endSet = new HashSet<>();
        for(int i = 0; i < n; i++) {
            frontSet.add(i);
            endSet.add(i);
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
                endSet.remove(i);
                break;
            }
        }
        
        int times = 1;
        int res = INF;
        while(frontQ.size() > 0 && endQ.size() > 0) {
            Queue<Integer> curQ;
            Set<Integer> curS, otherS;
            int D1[], D2[];
            if(times % 2 == 1) {
                curQ = frontQ;
                curS = frontSet;
                otherS = endSet;
                D1 = d1;
                D2 = d2;
            } else {
                curQ = endQ;
                curS = endSet;
                otherS = frontSet;
                D1 = d2;
                D2 = d1;
            }
            
            int u = curQ.poll();
            List<Integer> adds = new ArrayList<>();
            for(int nxt : curS) {
                if(!connect(a.get(u), a.get(nxt))) continue;
                if(!otherS.contains(nxt)) {
                    //System.out.println(u + "  " + nxt + "     |" + D1[u] + "  "+ D2[nxt]);
                    res = Math.min(res, D1[u] + D2[nxt]);
                    continue;
                }
                D1[nxt] = 1 + D1[u];
                curQ.add(nxt);
                adds.add(nxt);
            }
            
            for(int add : adds) {
                curS.remove(add);
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