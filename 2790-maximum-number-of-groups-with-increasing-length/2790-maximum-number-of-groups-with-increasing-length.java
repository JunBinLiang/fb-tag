class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        int n = usageLimits.size();
        int res = 0; long count = 0;
        for(int x : usageLimits) {
            count += x;
            if(count >= (res + 1l) * (res + 2) / 2) res++;
        }
        return res;
    }
}
