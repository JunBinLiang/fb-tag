class Solution {
    public int calculate(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                continue;
            } else if(isdigit(s.charAt(i))) {
                int j = i;
                StringBuilder str = new StringBuilder();
                while(j < s.length() && isdigit(s.charAt(j))) {
                    str.append(s.charAt(j));
                    j++;
                }
                list.add(str.toString());
                i = j - 1;
            } else {
                list.add("" + s.charAt(i));
            }
        }
        
        
        int match[] = new int[list.size()];
        Stack<Integer> stk = new Stack<>();
        Arrays.fill(match, -1);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("(")) {
                stk.push(i);
            } else if(list.get(i).equals(")")) {
                match[stk.pop()] = i;
            }
        }
        
        long x = dfs(match, list, 0, list.size() - 1, 1);
        return (int)(x);
    }
    
    public boolean isdigit(char c) {
        return c - '0' >= 0 && c - '0' < 10;
    }
    
    public long dfs(int match[], List<String> list, int l, int r, int symbol) {
        if(l == r) {
            return symbol * Long.parseLong(list.get(l));
        }
        
        if(list.get(l).equals("-")) {
            return symbol * dfs(match, list, l + 1, r, -1);
        }
        
        if(match[l] != -1) {
            int next = match[l];
            long x = symbol * dfs(match, list, l + 1, next - 1, 1);
            if(next + 1 <= r) {
                if(list.get(next + 1).equals("+")) {
                    x += dfs(match, list, next + 2, r, 1);
                } else {
                    x += dfs(match, list, next + 2, r, -1);
                }
            }
            return x;
        } else {
            long x = symbol * Long.parseLong(list.get(l));
            if(list.get(l + 1).equals("+")) return x + dfs(match, list, l + 2, r, 1);
            else return x + dfs(match, list, l + 2, r, -1);
        }
    }
    
    
}