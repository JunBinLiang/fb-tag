class MagicDictionary {
    class Trie {
        Trie next[];
        boolean end = false;
        public Trie() {
            next = new Trie[26];
        }
    }
    
    Trie root;
    public MagicDictionary() {
        root = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s : dictionary) {
            Trie u = root;
            for(int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if(u.next[c] == null) {
                    u.next[c] = new Trie();
                }
                u = u.next[c];
            }
            u.end = true;
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, 1);
    }
    
    public boolean dfs(Trie u, String s, int index, int change) {
        if(index >= s.length()) {
            return change == 0 && u.end;
        }
        
        int c = s.charAt(index) - 'a';
        boolean ans = false;
        if(u.next[c] != null) {
            ans |= dfs(u.next[c], s, index + 1, change);
        }
        if(change > 0) {
            for(int i = 0; i < 26; i++) {
                if(i == c) continue;
                if(u.next[i] != null) {
                    ans |= dfs(u.next[i], s, index + 1, 0);
                }
            }
        }
        return ans;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */