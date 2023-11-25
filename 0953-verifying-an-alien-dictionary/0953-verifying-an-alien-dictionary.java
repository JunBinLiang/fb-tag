class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int rank[] = new int[26];
        for(int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }
        
        for(int i = 0; i < words.length; i++) {
            char a[] = words[i].toCharArray();
            for(int j = 0; j < a.length; j++) {
                a[j] = (char)(rank[a[j] - 'a'] + 'a');
            }
            words[i] = new String(a);
        }
        
        for(int i = 1; i < words.length; i++) {
            if(words[i].compareTo(words[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
}