class WordFilter {
    class TrieNode {
        TrieNode next[];
        Map<String, Integer> map;
        public TrieNode() {
            next = new TrieNode[26];
            map = new HashMap<>();
        }
    }
    
    TrieNode root;
    
    public WordFilter(String[] words) {
        root = new TrieNode();
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            TrieNode u = root;
            for(char c : s.toCharArray()) {
                if(u.next[c - 'a'] == null) {
                    u.next[c - 'a'] = new TrieNode();
                }
                u = u.next[c - 'a'];
                for(int j = 0; j < s.length(); j++) {
                    u.map.put(s.substring(j, s.length()), i);
                }
            }
        }
    }
    
    public int f(String pref, String suff) {
        TrieNode u = root;
        for(int i = 0; i < pref.length(); i++) {
            u = u.next[pref.charAt(i) - 'a'];
            if(u == null) {
                return -1;
            }
        }
        
        if(u.map.containsKey(suff)) {
            return u.map.get(suff);
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */