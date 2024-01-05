class Solution {
    public int totalSteps(int[] nums) {
        int res = 0;
        int[] next = new int[nums.length];
        int[] pre = new int[nums.length];
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            next[i] = i + 1;
            pre[i] = i - 1;
            if(i > 0 && nums[i] < nums[i - 1]) {
                list.add(i);
            }
        }
        
        boolean[] remove = new boolean[nums.length];
        while(list.size() > 0) {
            res++;
            List<Integer> nextList = new ArrayList<>();
            for(int index : list) {
                int prenode = pre[index];
                int nextnode = next[index];
                if(prenode != -1) {
                    next[prenode] = nextnode;
                }
                if(nextnode != nums.length) {
                    pre[nextnode] = prenode;
                }
                remove[index] = true;
                
                if(nextnode != nums.length && prenode != -1 && nums[nextnode] < nums[prenode]) {
                    nextList.add(nextnode);
                }
            }
            
            list = new ArrayList<>();
            for(int index : nextList) {
                if(!remove[index]) {
                    list.add(index);
                }
            }
        }
        return res;
    }
}