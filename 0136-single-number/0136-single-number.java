class Solution {
    public int singleNumber(int[] nums) {
        int xo = 0;
        for(int x : nums) xo ^= x;
        return xo;
    }
}