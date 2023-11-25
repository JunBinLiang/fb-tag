class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < 2 * n; i++) {
            while(stk.size() > 0 && nums[i % n] > nums[stk.peek() % n]) {
                int index = stk.pop();
                if(index < n) {
                    res[index] = nums[i % n];
                }
            }
            stk.push(i);
        }
        
        return res;
    }
}