class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        List<String> list = new ArrayList<>();
        for(int x : nums) list.add(x + "");
        Collections.sort(list, (x, y) -> {
            String s = x + y;
            String t = y + x;
            return t.compareTo(s);
        });
        
        if(Integer.parseInt(list.get(0)) == 0) {
            return "0";
        }
        
        for(String s : list) {
            res.append(s);
        }
        return res.toString();
    }
}