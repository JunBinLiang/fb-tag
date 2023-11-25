class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        for(int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == '/') continue;
            int j = i;
            if(path.charAt(i) == '.') {
                StringBuilder str = new StringBuilder();
                while(j < path.length() && path.charAt(j) != '/') {
                    str.append(path.charAt(j));
                    j++;
                }
                
                if(str.toString().equals("..")) {
                    if(stk.size() > 0) stk.pop();
                } else if(str.toString().equals(".")) {
                    
                } else {
                    stk.push(str.toString());
                }
                i = j - 1;
            } else {
                StringBuilder str = new StringBuilder();
                while(j < path.length() && path.charAt(j) != '/') {
                    str.append(path.charAt(j++));
                }
                i = j;
                stk.push(str.toString());
            }
        }
        
        List<String> list = new ArrayList<>(stk);
        StringBuilder res = new StringBuilder();
        res.append("/");
        for(int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            res.append(s);
            if(i != list.size() - 1) {
                res.append("/");
            }
        }
        
        return res.toString();
    }
}