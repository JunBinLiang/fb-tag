class Solution {
    public int smallestRangeII(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0; 
        }
        
        Arrays.sort(nums);

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            list.add(new int[]{nums[i] - k, i});
            list.add(new int[]{nums[i] + k, i});
        }
        
        Collections.sort(list, (x, y) -> {
            return x[0] - y[0];
        });
        Map<Integer, Integer> map = new HashMap<>();
        int res = nums[nums.length - 1] - nums[0];
        for(int i = 0, j = 0; i < list.size(); i++) {
            add(map, list.get(i)[1]);
            while(map.size() == nums.length) {
                delete(map, list.get(j)[1]);
                res = Math.min(res, list.get(i)[0] - list.get(j)[0]);
                j++;
            }
        }
        return res;
    }
    
    public void add(Map<Integer, Integer> map, int k) {
        if(!map.containsKey(k)) {
            map.put(k, 1);
        } else {
            map.put(k, map.get(k) + 1);
        }
    }
    
    public void delete(Map<Integer, Integer> map, int k) {
        int count = map.get(k);
        if(count == 1) {
            map.remove(k);
        } else {
            map.put(k, count - 1);
        }
    }
}