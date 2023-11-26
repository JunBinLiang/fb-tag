class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, Integer> tr = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < buildings.length; i++) {
            int l = buildings[i][0], r = buildings[i][1], h = buildings[i][2];
            list.add(new int[]{l, h});
            list.add(new int[]{r, -h});
        }
        
        Collections.sort(list, (x, y) -> {
            if(x[0] == y[0]) {
                return y[1] - x[1];
            }  
            return x[0] - y[0];
        });
        
        add(tr, 0);
        
        for(int p[] : list) {
            int x = p[0], h = p[1];
            if(h > 0) {
                if(h > last(tr)) {
                    res.add(Arrays.asList(new Integer[]{x, h}));
                }
                add(tr, h);
            } else {
                h = -h;
                delete(tr, h);
                int maxH = last(tr);
                if(h > maxH) {
                    res.add(Arrays.asList(new Integer[]{x, maxH}));
                } 
            }
        }
        return res;
    }
    
    public void add(TreeMap<Integer, Integer> tr, int k) {
        if(!tr.containsKey(k)) {
            tr.put(k, 1);
        } else {
            tr.put(k, tr.get(k) + 1);
        }
    }
    
    public void delete(TreeMap<Integer, Integer> tr, int k) {
        int count = tr.get(k);
        if(count == 1) {
            tr.remove(k);
        } else {
            tr.put(k, count - 1);
        }
    }
    
    public int last(TreeMap<Integer, Integer> tr) {
        return tr.lastKey();
    }
}