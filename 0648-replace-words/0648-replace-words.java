class Solution {
    class Trie {
        Trie next[];
        boolean isEnd = false;
        public Trie() {
            next = new Trie[26];
        }
    }
    Trie root;
    public String replaceWords(List<String> dictionary, String sentence) {
        String words[] = sentence.split(" ");
        root = new Trie();
        for(String s : dictionary) {
            Trie u = root;
            for(int i = 0; i < s.length(); i++) {
                int d = s.charAt(i) - 'a';
                if(u.next[d] == null) {
                    u.next[d] = new Trie();
                }
                u = u.next[d];
            }
            u.isEnd = true;
        }
        
        for(int i = 0; i < words.length; i++) {
            Trie u = root;
            String word = words[i];
            StringBuilder str = new StringBuilder();
            boolean found = false;
            for(int j = 0; j < word.length(); j++) {
                int d = word.charAt(j) - 'a';
                if(u.next[d] != null) {
                    str.append(word.charAt(j));
                    u = u.next[d];
                    if(u.isEnd) {
                        found = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            
            if(!found) {
                str = new StringBuilder();
            }
            
            if(str.length() > 0) {
                words[i] = str.toString();
            }
        }
        
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            res.append(words[i]);
            if(i != words.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}