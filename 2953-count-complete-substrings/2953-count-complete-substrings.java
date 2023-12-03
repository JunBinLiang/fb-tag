class Solution {
    public int countCompleteSubstrings(String s, int k) {
        int res = 0;
        //At most i distinct characters
        
        for(int x = 1; x <= 26; x++) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            int difCount[] = new int[3];
            
            int len = x * k;
            if(len == 1) {
                res += s.length();
                continue;
            }
            
            if(len > s.length()) break;
            
            for(int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                
                add(map1, c);
                int count = map1.get(c);
                if(count == 1) {
                    add(map2, 1);
                } else {
                    add(map2, count);
                    delete(map2, count - 1);
                }
                
                if(i > 0) {
                    int dif = Math.abs(s.charAt(i) - s.charAt(i - 1));
                    if(dif <= 2) {
                        difCount[dif]++;
                    }
                }
                
                if(i + 1 >= len) {
                    if((difCount[0] + difCount[1] + difCount[2]) == len - 1 && map2.size() == 1 && map1.size() == x) {
                        res++;
                    }
                    
                    //delete the first
                    c = s.charAt(i + 1 - len) - 'a';
                    int dif = Math.abs(s.charAt(i + 1 - len) - s.charAt(i + 2 - len));
                    if(dif <= 2) {
                        difCount[dif]--;
                    }
                    
                    int oldCount = map1.get(c);
                    delete(map1, c);
                    delete(map2, oldCount);
                    if(oldCount - 1 > 0) {
                        add(map2, oldCount - 1);
                    }
                }
            }
        }
        
        return res;
    }
    
    public void add(Map<Integer, Integer> map, int k) {
        if(!map.containsKey(k)) {
            map.put(k, 1);
        } else {
            map.put(k, map.get(k) + 1);
        }
    }
    
    public void delete(Map<Integer, Integer> map, int k) {
        int count = map.get(k);
        if(count == 1) {
            map.remove(k);
        } else {
            map.put(k, count - 1);
        }
    }
}