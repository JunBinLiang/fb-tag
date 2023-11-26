class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int to[] = new int[26];
        Arrays.fill(to, -1);

        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            to[c] = i;
        }
        
        for(int i = 0; i < s.length(); i++) {
            int j = i;
            int cur = to[s.charAt(i) - 'a'];
            while(j < s.length() && j <= cur) {
                cur = Math.max(cur, to[s.charAt(j) - 'a']);
                j++;
            }
            res.add(j - i);
            i = j - 1;
        }
        return res;
    }
}