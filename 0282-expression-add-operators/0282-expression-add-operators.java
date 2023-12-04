class Solution {
    int t;
    List<String> res = new ArrayList<>();
    public List<String> addOperators(String s, int target) {
        t = target;
        for(int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if(sub.charAt(0) == '0' && sub.length() > 1) continue;
            List<String> list = new ArrayList<>();
            list.add(sub);
            long v = Long.parseLong(sub);
            dfs(list, s, i + 1, v, v);
        }
        
        return res;
    }
    
    public void dfs(List<String> list, String s, int index, long pval, long total) {
        if(index >= s.length()) {
            if(total == t) {
                res.add(convert(list));
            }
            return;
        }
        
        
        for(int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if(sub.charAt(0) == '0' && sub.length() > 1) {
                continue;
            }
            long v = Long.parseLong(sub);
            
            // + 
            list.add("+");
            list.add(sub);
            dfs(list, s, i + 1, v, total + v);
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
            
            // -
            list.add("-");
            list.add(sub);
            dfs(list, s, i + 1, -v, total - v);
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
            
            // *
            list.add("*");
            list.add(sub);
            
            if(pval < 0) {
                dfs(list, s, i + 1, pval * v, total - pval + (pval * v));
            } else {
                dfs(list, s, i + 1, pval * v, total - pval + (pval * v));
            }
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }
    
    public String convert(List<String> list) {
        StringBuilder str = new StringBuilder();
        for(String s : list) {
            str.append(s);
        }
        return str.toString();
    }
}