class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        dfs(new ArrayList<>(), new StringBuilder(), s, 0);
        return res;
    }
    
    public String convert(List<String> list) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
            if(i != list.size() - 1) {
                str.append(".");
            }
        }
        return str.toString();
    }
    
    public boolean check(List<String> list) {
        if(list.size() != 4) {
            return false;
        }
        
        for(String s : list) {
            if(s.length() > 1 && s.charAt(0) == '0') return false;
            int val = Integer.parseInt(s);
            if(val < 0 || val > 255) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs(List<String> list, StringBuilder str, String s, int i) {
        if(i >= s.length()) {
            if(str.length() == 0 && check(list)) {
                res.add(convert(list));
            }
            return;
        }
        
        str.append(s.charAt(i));
        String t = str.toString();
        dfs(list, str, s, i + 1);
        if(t.length() <= 4) {
            list.add(t);
            dfs(list, new StringBuilder(), s, i + 1);
            list.remove(list.size() - 1);
        }
    }
}