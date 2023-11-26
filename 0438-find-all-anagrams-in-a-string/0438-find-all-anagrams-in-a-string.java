class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        
        List<Integer> res = new ArrayList<>();
        int cnt1[] = new int[26];
        int cnt2[] = new int[26];
        int k = t.length();
        
        for(int i = 0; i < t.length(); i++) {
            cnt2[t.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            cnt1[s.charAt(i) - 'a']++;
            if(i + 1 >= k) {
                if(same(cnt1, cnt2)) {
                    res.add(i + 1 - k);
                }
                cnt1[s.charAt(i + 1 - k) - 'a']--;
            }
        }
        return res;
    }
    
    public boolean same(int cnt1[], int cnt2[]) {
        for(int i = 0; i < cnt1.length; i++) {
            if(cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }
}