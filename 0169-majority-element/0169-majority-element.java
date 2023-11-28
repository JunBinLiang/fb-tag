class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
            if(map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        
        int n = nums.length;
        for(int x : nums) {
            if(map.get(x) > n / 2) {
                return x;
            }
        }
        
        return -1;
    }
}