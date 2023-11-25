class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1, neg = 0, pos = 0;
        int res = nums[0];
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                prefix = 1;
                neg = 0;
                pos = 0;
                res = Math.max(res, 0);
                continue;
            }
            prefix *= nums[i];
            res = Math.max(res, prefix);
            //System.out.println(prefix + "  " + neg + " " + pos);
            if(prefix > 0) {
                if(pos == 0) {
                    pos = prefix;
                } else {
                    pos = Math.max(pos, prefix);
                }
            } else {
                if(pos != 0) res = Math.max(res, prefix / pos);
                if(neg != 0) res = Math.max(res, prefix / neg);
                
                if(neg == 0) {
                    neg = prefix;
                } else {
                    neg = Math.max(neg, prefix);
                }
            }
        }
        
        return res;
    }
}