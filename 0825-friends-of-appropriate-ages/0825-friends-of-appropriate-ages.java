class Solution {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        Arrays.sort(ages);
        
        //age[y] <= age[x]
        //age[y] > age[x] * 0.5 + 7
        //ignore
        for(int i = 0; i < ages.length; i++) {
            int j = i;
            int count = 0;
            while(j < ages.length && ages[j] == ages[i]) {
                count++;
                j++;
            }
            
            if(count > 1 && (ages[i] - 7) * 2 > ages[i]) {
                res += (count * (count - 1));
            }
            
            int x = ages[i];
            int l = 0, r = i - 1;
            int p = i;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                int y = ages[mid];
                if((y - 7) * 2 > x) {
                    p = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            res += ((i - p) * count);
            i = j - 1;
        }
        return res;
    }
}