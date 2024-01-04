class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        for(char c : tasks) {
            count[c - 'A']++;
            max = Math.max(max, count[c - 'A']);
        }
        
        int slots = (max - 1) * (n + 1);
        for(int i = 0; i < 26; i++) {
            if(count[i] == max) {
                slots++;
            }
        }
        
        return Math.max(tasks.length, slots);
    }
}