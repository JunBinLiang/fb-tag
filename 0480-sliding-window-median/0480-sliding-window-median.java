class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double res[] = new double[nums.length - k + 1];
        MedianFinder medianFinder = new MedianFinder();
        for(int i = 0; i < nums.length; i++) {
            medianFinder.add(nums[i]);
            if(i + 1 >= k) {
                res[i - k + 1] = medianFinder.getMedian();
                medianFinder.delete(nums[i + 1 - k]);
            }
        }
        return res;
    }
    
    class MedianFinder {
        TreeMap<Integer, Integer> left;
        TreeMap<Integer, Integer> right;
        int leftSize = 0, rightSize = 0;
        
        public MedianFinder() {
            left = new TreeMap<>();
            right = new TreeMap<>();
        }
        
        public void add(int num) {//[last   first]
            if(leftSize == 0 && rightSize == 0) {
                leftSize++;
                addToMap(left, num);
            } else if(leftSize == 0) {
                rightSize++;
                addToMap(right, num);
            } else if(rightSize == 0) {
                leftSize++;
                addToMap(left, num);
            } else {
                Integer last = left.lastKey();
                Integer first = right.firstKey();
                if(num <= last) {
                    leftSize++;
                    addToMap(left, num);
                } else {
                    rightSize++;
                    addToMap(right, num);
                }
            }
            adjust();
        }
        
        public void delete(int num) {
            if(left.containsKey(num)) {
                deleteFromMap(left, num);
                leftSize--;
            } else {
                deleteFromMap(right, num);
                rightSize--;
            }
            adjust();
        }
        
        public double getMedian() {
            if((leftSize + rightSize) % 2 == 0) {
                Integer last = left.lastKey();
                Integer first = right.firstKey();
                return (last + 0.0 + first) / 2;
            } else {
                if(leftSize > rightSize) return left.lastKey();
                else return right.firstKey();
            }
        }
        
        public void adjust() {
            if(leftSize > rightSize) {
                while(Math.abs(leftSize - rightSize) > 1) {
                    Integer last = left.lastKey();
                    deleteFromMap(left, last);
                    addToMap(right, last);
                    leftSize--;
                    rightSize++;
                }
            } else {
                while(Math.abs(leftSize - rightSize) > 1) {
                    Integer first = right.firstKey();
                    deleteFromMap(right, first);
                    addToMap(left, first);
                    leftSize++;
                    rightSize--;
                }
            }
        }
        
        public void addToMap(TreeMap<Integer, Integer> map, int k) {
            if(map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }
        
        public void deleteFromMap(TreeMap<Integer, Integer> map, int k) {
            int oldCnt = map.get(k);
            if(oldCnt == 1) {
                map.remove(k);
            } else {
                map.put(k, oldCnt - 1);
            }
        }
    } 
}