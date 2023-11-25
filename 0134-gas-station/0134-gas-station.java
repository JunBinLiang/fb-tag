class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int d[] = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = gas[i] - cost[i];
        }
        
        int sum = 0;
        int j = 0;
        for(int i = 0; i < 2 * n; i++) {
            if(sum + d[i % n] < 0) {
                sum = 0;
                j = i + 1;
                continue;
            }
            sum += d[i % n];
            if(i - j + 1 >= n) {
                return j;
            }
        }
        return -1;
    }
}