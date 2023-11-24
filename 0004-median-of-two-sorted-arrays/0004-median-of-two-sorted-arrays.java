//12: 45
class Solution {
    final int INF = 1000000000;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int n = nums1.length, m = nums2.length;
        if(n == 0) {
            if(m % 2 == 1) {
                return nums2[m / 2];
            } else {
                return (nums2[m / 2] + 0.0 + nums2[m / 2 - 1]) / 2.0;
            }
        }

        if((n + m) % 2 == 1) {
            return getK(nums1, nums2, (n + m) / 2 + 1);
        } else {
            return (getK(nums1, nums2, (n + m) / 2) + getK(nums1, nums2, (n + m) / 2 + 1)) / 2;
        }
    }
    
    public int get(int[] nums, int i) {
        if(i >= nums.length) return INF;
        if(i < 0) return -INF;
        return nums[i];
    }
    
    public double getK(int[] nums1, int[] nums2, int k) {
        int l = 1, r = Math.min(k, nums1.length);
        int res = 0;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(mid + nums2.length < k) {
                l = mid + 1;
                continue;
            }
            int len1 = mid, len2 = k - mid;
            int lastA = get(nums1, len1 - 1), lastB = get(nums2, len2 - 1);
            int nextA = get(nums1, len1), nextB = get(nums2, len2);
            if(lastA <= nextB) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int len1 = res, len2 = k - len1;
        return Math.max(get(nums1, len1 - 1), get(nums2, len2 - 1));
    }
}