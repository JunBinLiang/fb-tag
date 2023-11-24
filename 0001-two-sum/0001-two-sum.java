class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(complement.containsKey(target - nums[i])) {
                return new int[]{complement.get(target - nums[i]), i};
            }
            complement.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}