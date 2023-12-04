class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int res = Integer.MAX_VALUE;
        LinkedList<long[]> mono = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sum >= k) {
                res = Math.min(res, i + 1);
            }
            
            while(mono.size() > 0 && sum - mono.getFirst()[0] >= k) {
                long p[] = mono.removeFirst();
                res = Math.min(res, (int)(i - p[1]));
            }
            
            while(mono.size() > 0 && sum <= mono.getLast()[0]) {
                mono.removeLast();
            }
            
            mono.add(new long[]{sum, i});
        }
        
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}