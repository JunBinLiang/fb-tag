class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        int n = nums.length;
        for(String num : nums) {
            set.add(num);
        }
        
        for(int i = 0; i < (1 << n); i++) {
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) > 0) {
                    str.append("1");
                } else {
                    str.append("0");
                }
            }
            if(!set.contains(str.toString())) {
                return str.toString();
            }
        }
        return "";
    }
}