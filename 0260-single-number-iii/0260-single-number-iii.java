class Solution {
    public int[] singleNumber(int[] nums) {
        int res[] = new int[2];
        int xo = 0;
        for(int x : nums) xo ^= x;
        
        int index = -1;
        for(int i = 0; i < 32; i++) {
            if((xo & (1 << i)) > 0) {
                index = i;
            }
        }
        
        
        for(int x : nums) {
            if((x & (1 << index)) > 0) {
                res[0] ^= x;
            }
        }
        
        res[1] = (xo ^ res[0]);
        return res;
    }
}