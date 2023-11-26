class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall) {
            int psum = 0;
            for(int i = 0; i < list.size() - 1; i++) {
                psum += list.get(i);
                if(!map.containsKey(psum)) {
                    map.put(psum, 1);
                } else {
                    map.put(psum, map.get(psum) + 1);
                }
                res = Math.max(res, map.get(psum));
            }
        }
        return wall.size() - res;
    }
}