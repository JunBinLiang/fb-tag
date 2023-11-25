//5:00
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cnt[] = new int[26];
        int mx = 0;
        for(char c : tasks) {
            cnt[c - 'A']++;
            mx = Math.max(mx, cnt[c - 'A']);
        }
        
        int slots = (n + 1) * (mx - 1);
        for(int i = 0; i < 26; i++) {
            if(cnt[i] == mx) {
               slots++; 
            }
        }
        return Math.max(slots, tasks.length);
    }
}